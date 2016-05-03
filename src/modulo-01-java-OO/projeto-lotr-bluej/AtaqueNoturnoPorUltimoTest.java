import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AtaqueNoturnoPorUltimoTest {
     private ArrayList<Dwarf> exercitoDeDwarfs(){
        ArrayList<Dwarf> dwarfList = new ArrayList<>();
        dwarfList.add(new Dwarf("Jimle"));
        dwarfList.add(new Dwarf("Kanuzi"));
        dwarfList.add(new Dwarf("Onyotto"));
        return dwarfList;
    }
    
    private void alistaElfos(ExercitoDeElfos exercito) throws NaoPodeAlistarException{
        exercito.alistaElfo(new ElfoNoturno("Ranger"));
        exercito.alistaElfo(new ElfoVerde("Fredyl"));
        exercito.alistaElfo(new ElfoVerde("Nephil"));
        exercito.alistaElfo(new ElfoNoturno("Gorroko"));
        exercito.alistaElfo(new ElfoVerde("Jardan"));
    }
    
    @Test
    public void exercitoAtacaDwarfsEstrategiaNoturnoPorUltimo() throws NaoPodeAlistarException{
        ExercitoDeElfos exercitoElfos = new ExercitoDeElfos();
        ArrayList<Dwarf> exercitoDwarfs = exercitoDeDwarfs();
        Estrategia estrategia = new AtaqueNoturnoPorUltimo();
        alistaElfos(exercitoElfos);
        estrategia.atacar(exercitoElfos,exercitoDwarfs); 
        for(Dwarf dwarf : exercitoDwarfs){
            assertTrue(dwarf.getVida() == 60);
        }
    }
    
    @Test
    public void exercitoAtacaDwarfsEstrategiNoturnoPorUltimoGetOrdem() throws NaoPodeAlistarException{
        ExercitoDeElfos exercitoElfos = new ExercitoDeElfos();
        ArrayList<Dwarf> exercitoDwarfs = exercitoDeDwarfs();
        Estrategia estrategia = new AtaqueNoturnoPorUltimo();
        alistaElfos(exercitoElfos);
        estrategia.atacar(exercitoElfos,exercitoDwarfs); 
        assertEquals(estrategia.getOrdemDoUltimoAtaque().get(3).getNome(), "Ranger");
        assertEquals(estrategia.getOrdemDoUltimoAtaque().get(4).getNome(), "Gorroko");
    }
    
     @Test
    public void exercitoEmbaralhadoPriorizaAtaqueComElfosVerdes() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new AtaqueNoturnoPorUltimo());
        Elfo en1 = new ElfoNoturno("Night 1");
        Elfo en2 = new ElfoNoturno("Night 2");
        Elfo ev1 = new ElfoVerde("Green 1");
        Elfo en3 = new ElfoNoturno("Night 3");
        Elfo ev2 = new ElfoVerde("Green 2");
        exercito.alistaElfo(en1);
        exercito.alistaElfo(en2);
        exercito.alistaElfo(ev1);
        exercito.alistaElfo(en3);
        exercito.alistaElfo(ev2);
        ArrayList<Elfo> esperado = new ArrayList<>(Arrays.asList(ev2, ev1, en3, en2, en1));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }

    @Test
    public void exercitoSóDeVerdes() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new AtaqueNoturnoPorUltimo());
        Elfo ev1 = new ElfoVerde("Green 1");
        Elfo ev2 = new ElfoVerde("Green 2");
        exercito.alistaElfo(ev1);
        exercito.alistaElfo(ev2);
        ArrayList<Elfo> esperado = new ArrayList<>(Arrays.asList(ev2, ev1));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }

    @Test
    public void exercitoSóDeNoturnos() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new AtaqueNoturnoPorUltimo());
        Elfo en1 = new ElfoNoturno("EN1");
        Elfo en2 = new ElfoNoturno("EN2");
        exercito.alistaElfo(en1);
        exercito.alistaElfo(en2);
        ArrayList<Elfo> esperado = new ArrayList<>(Arrays.asList(en2, en1));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }

    @Test
    public void ataqueComExercitoVazio() throws NaoPodeAlistarException {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new AtaqueNoturnoPorUltimo());
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"))));
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        assertTrue(ordemAtaque.isEmpty());
    }

    @Test
    public void ataqueComVerdesENoturnoMorto() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new AtaqueNoturnoPorUltimo());
        Elfo en1 = new ElfoNoturno("Night 1");
        Elfo en2 = new ElfoNoturno("Night 2");
        Elfo ev1 = new ElfoVerde("Green 1");
        Elfo en3 = new ElfoNoturno("Night 3");
        Elfo ev2 = new ElfoVerde("Green 2");
        for (int i = 0; i < 90; i++) en1.atirarFlecha(new Dwarf("D1"));
        exercito.alistaElfo(en1);
        exercito.alistaElfo(en2);
        exercito.alistaElfo(ev1);
        exercito.alistaElfo(en3);
        exercito.alistaElfo(ev2);
        ArrayList<Elfo> esperado = new ArrayList<>(Arrays.asList(ev2, ev1, en3, en2, en1));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }
}
