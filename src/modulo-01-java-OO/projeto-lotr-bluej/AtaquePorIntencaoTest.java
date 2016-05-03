import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AtaquePorIntencaoTest {
     private ArrayList<Dwarf> exercitoDeDwarfs(){
        ArrayList<Dwarf> dwarfList = new ArrayList<>();
        dwarfList.add(new Dwarf("Jimle"));
        dwarfList.add(new Dwarf("Kanuzi"));
        return dwarfList;
    }
    
    private void alistaElfos(ExercitoDeElfos exercito) throws NaoPodeAlistarException{
        exercito.alistaElfo(new ElfoNoturno("Ranger"));
        exercito.alistaElfo(new ElfoVerde("Fredyl"));
        exercito.alistaElfo(new ElfoNoturno("Nephil"));
        exercito.alistaElfo(new ElfoNoturno("Gorroko"));
    }
    
    @Test
    public void exercitoAtacaDwarfsEstrategiPorIntencoes() throws NaoPodeAlistarException{
        ExercitoDeElfos exercitoElfos = new ExercitoDeElfos();
        ArrayList<Dwarf> exercitoDwarfs = exercitoDeDwarfs();
        Estrategia estrategia = new AtaquePorIntencao();
        alistaElfos(exercitoElfos);
        estrategia.atacar(exercitoElfos,exercitoDwarfs); 
        for(Dwarf dwarf : exercitoDwarfs){
            assertTrue(dwarf.getVida() == 90);
        }
        assertTrue(exercitoElfos.getExercitoDeElfosStatus().get(Status.VIVO).get(2).getVida() == 100); // Penultimo elfo nao ataca e nao perde a vida.
        assertTrue(exercitoElfos.getExercitoDeElfosStatus().get(Status.VIVO).get(3).getVida() == 100); // Ultimo elfo nao ataca e nao perde a vida.
    }
    
    @Test
    public void exercitoAtacaDwarfsEstrategiPorIntencoesGetOrdem() throws NaoPodeAlistarException{
        ExercitoDeElfos exercitoElfos = new ExercitoDeElfos();
        ArrayList<Dwarf> exercitoDwarfs = exercitoDeDwarfs();
        Estrategia estrategia = new AtaquePorIntencao();
        alistaElfos(exercitoElfos);
        estrategia.atacar(exercitoElfos,exercitoDwarfs); 
        assertEquals(estrategia.getOrdemDoUltimoAtaque().get(0).getNome(), "Ranger");
        assertEquals(estrategia.getOrdemDoUltimoAtaque().get(1).getNome(), "Fredyl");
    }
    
    @Test
    public void ataqueCom3Noturnos1Verde2Dwarves() throws NaoPodeAlistarException {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoNoturno1 = new ElfoNoturno("EN1");
        Elfo elfoNoturno2 = new ElfoNoturno("EN2");
        Elfo elfoNoturno3 = new ElfoNoturno("EN3");
        Elfo elfoVerde1 = new ElfoVerde("EV1");
        exercito.alistaElfo(elfoNoturno1);
        exercito.alistaElfo(elfoNoturno2);
        exercito.alistaElfo(elfoNoturno3);
        exercito.alistaElfo(elfoVerde1);
        ArrayList<Dwarf> dwarves = new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2")));
        exercito.atacar(dwarves);
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        assertEquals(elfoVerde1, ordemAtaque.get(0));
        // para o hashmap deste exército, EN2 virá antes, depois EN1 e EN3.
        assertEquals(elfoNoturno2, ordemAtaque.get(1));
        assertEquals(4, ordemAtaque.size());
    }

    @Test
    public void ataqueCom3Noturnos4Dwarves() throws NaoPodeAlistarException {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoNoturno1 = new ElfoNoturno("EN1");
        Elfo elfoNoturno2 = new ElfoNoturno("EN2");
        Elfo elfoNoturno3 = new ElfoNoturno("EN3");
        exercito.alistaElfo(elfoNoturno1);
        exercito.alistaElfo(elfoNoturno2);
        exercito.alistaElfo(elfoNoturno3);
        ArrayList<Dwarf> dwarves = new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"), new Dwarf("D4")));
        exercito.atacar(dwarves);
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        // para o hashmap deste exército, EN2 virá antes, depois EN1 e EN3.
        assertEquals(elfoNoturno2, ordemAtaque.get(0));
    }

    @Test
    public void ataqueCom3VerdesApenas() throws NaoPodeAlistarException {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoVerde1 = new ElfoVerde("EV1");
        Elfo elfoVerde2 = new ElfoVerde("EV2");
        Elfo elfoVerde3 = new ElfoVerde("EV3");
        exercito.alistaElfo(elfoVerde1);
        exercito.alistaElfo(elfoVerde2);
        exercito.alistaElfo(elfoVerde3);
        ArrayList<Dwarf> dwarves = new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2")));
        exercito.atacar(dwarves);
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        // para o hashmap deste exército, EV2 virá antes, depois EV1 e EV3.
        assertEquals(elfoVerde2, ordemAtaque.get(0));
        assertEquals(elfoVerde1, ordemAtaque.get(1));
        assertEquals(elfoVerde3, ordemAtaque.get(2));
    }

    @Test
    public void ataqueComExercitoVazio() throws NaoPodeAlistarException {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ArrayList<Dwarf> dwarves = new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2")));
        exercito.atacar(dwarves);
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        assertTrue(ordemAtaque.isEmpty());
    }

    @Test
    public void ataque1VerdeOutroMorto() throws NaoPodeAlistarException {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoVerde1 = new ElfoVerde("EV1");
        Elfo en1 = new ElfoNoturno("EN1");
        for (int i = 0; i < 90; i++) en1.atirarFlecha(new Dwarf("D1"));
        exercito.alistaElfo(elfoVerde1);
        exercito.alistaElfo(en1);
        ArrayList<Dwarf> dwarves = new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2")));
        exercito.atacar(dwarves);
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        assertEquals(elfoVerde1, ordemAtaque.get(0));
        assertEquals(elfoVerde1, ordemAtaque.get(0));
        assertEquals(2, ordemAtaque.size());
    }
}
