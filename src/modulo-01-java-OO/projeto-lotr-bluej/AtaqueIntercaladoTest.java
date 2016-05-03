import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AtaqueIntercaladoTest {
    private ArrayList<Dwarf> exercitoDeDwarfs(){
        ArrayList<Dwarf> dwarfList = new ArrayList<>();
        dwarfList.add(new Dwarf("Jimle"));
        dwarfList.add(new Dwarf("Kanuzi"));
        dwarfList.add(new Dwarf("Onyotto"));
        return dwarfList;
    }
    
    private void alistaElfosMisturadosDesigual(ExercitoDeElfos exercito) throws NaoPodeAlistarException{
        exercito.alistaElfo(new ElfoNoturno("Ranger"));
        exercito.alistaElfo(new ElfoNoturno("Fredyl"));
        exercito.alistaElfo(new ElfoNoturno("Nephil"));
        exercito.alistaElfo(new ElfoNoturno("Gorroko"));
        exercito.alistaElfo(new ElfoNoturno("Jardan"));
    }
    
    private void alistaElfosMisturadosComIgualdade(ExercitoDeElfos exercito) throws NaoPodeAlistarException{
        exercito.alistaElfo(new ElfoVerde("Ranger"));
        exercito.alistaElfo(new ElfoNoturno("Fredyl"));
        exercito.alistaElfo(new ElfoNoturno("Gorroko"));
        exercito.alistaElfo(new ElfoVerde("Nephil"));
        
    }
    
    private void alistaUmElfoVerdePrimeiro(ExercitoDeElfos exercito) throws NaoPodeAlistarException{
        exercito.alistaElfo(new ElfoNoturno("Fredyl"));
        exercito.alistaElfo(new ElfoNoturno("Gorroko"));
        exercito.alistaElfo(new ElfoNoturno("Nephil"));
        exercito.alistaElfo(new ElfoVerde("Ranger")); // HashCode deste elfo é o primeiro no arrayList dos vivos
        exercito.alistaElfo(new ElfoNoturno("Yagmoto"));
        exercito.alistaElfo(new ElfoVerde("Mitamo"));
        exercito.alistaElfo(new ElfoVerde("Mitsume"));
        exercito.alistaElfo(new ElfoVerde("Karazuko"));
        
    }
    
    private void alistaUmElfoNoturnoPrimeiro(ExercitoDeElfos exercito) throws NaoPodeAlistarException{
        exercito.alistaElfo(new ElfoVerde("Fredyl"));
        exercito.alistaElfo(new ElfoNoturno("Gorroko"));
        exercito.alistaElfo(new ElfoVerde("Nephil"));
         exercito.alistaElfo(new ElfoNoturno("Ranger")); // HashCode deste elfo é o primeiro no arrayList dos vivos
        exercito.alistaElfo(new ElfoVerde("Yagmoto"));
        exercito.alistaElfo(new ElfoVerde("Mitamo"));
        exercito.alistaElfo(new ElfoNoturno("Mitsume"));
        exercito.alistaElfo(new ElfoNoturno("Karazuko"));
        
    }
    
    @Test
    public void exercitoAtacaDwarfsEstrategiaPorIntercalacaoSemIgualdade() throws NaoPodeAlistarException{
        ExercitoDeElfos exercitoElfos = new ExercitoDeElfos();
        ArrayList<Dwarf> exercitoDwarfs = exercitoDeDwarfs();
        Estrategia estrategia = new AtaqueIntercalado();
        alistaElfosMisturadosDesigual(exercitoElfos);
        estrategia.atacar(exercitoElfos,exercitoDwarfs); 
        for(Dwarf dwarf : exercitoDwarfs){
            assertFalse(dwarf.getVida() < 110);
        }
    }
    
    @Test
    public void exercitoAtacaDwarfsEstrategiaPorIntercalacaoComIgualdade() throws NaoPodeAlistarException{
        ExercitoDeElfos exercitoElfos = new ExercitoDeElfos();
        ArrayList<Dwarf> exercitoDwarfs = exercitoDeDwarfs();
        Estrategia estrategia = new AtaqueIntercalado();
        alistaElfosMisturadosComIgualdade(exercitoElfos);
        estrategia.atacar(exercitoElfos,exercitoDwarfs); 
        for(Dwarf dwarf : exercitoDwarfs){
            assertTrue(dwarf.getVida() == 70);
        }
    }
    
    @Test
    public void atacaDwarfsEstrategiaPorIntercalacaoGetOrdemVerdePrimeiro() throws NaoPodeAlistarException{
        ExercitoDeElfos exercitoElfos = new ExercitoDeElfos();
        ArrayList<Dwarf> exercitoDwarfs = exercitoDeDwarfs();
        Estrategia estrategia = new AtaqueIntercalado();
        alistaUmElfoVerdePrimeiro(exercitoElfos);
        estrategia.atacar(exercitoElfos,exercitoDwarfs); 
        int metadeDoTamanhoDoArray = exercitoElfos.getExercitoDeElfosStatus().size()/2;
        for(int i=0; i<metadeDoTamanhoDoArray; i++){
            Elfo elfoVerde = exercitoElfos.getExercitoDeElfosStatus().get(Status.VIVO).get(i);
            Elfo elfoNoturno = exercitoElfos.getExercitoDeElfosStatus().get(Status.VIVO).get(i + metadeDoTamanhoDoArray);
            assertTrue(elfoVerde instanceof ElfoVerde);
            assertTrue(elfoNoturno instanceof ElfoNoturno);
        }
    }
    
    @Test
    public void atacaDwarfsEstrategiaPorIntercalacaoGetOrdemNoturnoPrimeiro() throws NaoPodeAlistarException{
        ExercitoDeElfos exercitoElfos = new ExercitoDeElfos();
        ArrayList<Dwarf> exercitoDwarfs = exercitoDeDwarfs();
        Estrategia estrategia = new AtaqueIntercalado();
        alistaUmElfoNoturnoPrimeiro(exercitoElfos);
        estrategia.atacar(exercitoElfos,exercitoDwarfs); 
        int metadeDoTamanhoDoArray = exercitoElfos.getExercitoDeElfosStatus().size()/2;
        for(int i=0; i<metadeDoTamanhoDoArray; i++){       
            Elfo elfoNoturno = exercitoElfos.getExercitoDeElfosStatus().get(Status.VIVO).get(i);  
            Elfo elfoVerde = exercitoElfos.getExercitoDeElfosStatus().get(Status.VIVO).get(i + metadeDoTamanhoDoArray);
            assertTrue(elfoNoturno instanceof ElfoNoturno);
            assertTrue(elfoVerde instanceof ElfoVerde);
        }
    }
    
    @Test
    public void exercitoSoDeUmTipoNãoAtaca() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();  
        exercito.mudarEstrategia(new AtaqueIntercalado());
        Elfo night1 = new ElfoNoturno("Noturno 1");
        Elfo night2 = new ElfoNoturno("Elfo Noturno 2");
        exercito.alistaElfo(night1);
        exercito.alistaElfo(night2);
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void ataqueComExercitoVazio() throws NaoPodeAlistarException {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new AtaqueIntercalado());
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"))));
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        assertTrue(ordemAtaque.isEmpty());
    }

    @Test
    public void exercitoIntercaladoComElfoNoturnoMorto() throws NaoPodeAlistarException {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new AtaqueIntercalado());
        Elfo night1 = new ElfoNoturno("EN1",100);
        for (int i = 0; i < 90; i++) night1.atirarFlecha(new Dwarf("D1"));
        Elfo night2 = new ElfoNoturno("EN2");
        Elfo night3 = new ElfoNoturno("EN3");
        Elfo green1 = new ElfoVerde("EV1");
        Elfo green2 = new ElfoVerde("EV2");
        exercito.alistaElfo(night1);
        exercito.alistaElfo(night2);
        exercito.alistaElfo(night3);
        exercito.alistaElfo(green1);
        exercito.alistaElfo(green2);
        List<Elfo> esperado = new ArrayList<>(Arrays.asList(green2, night2, green1, night3));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }
}
