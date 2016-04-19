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
    
    private void alistaElfosMisturadosDesigual(ExercitoDeElfos exercito){
        exercito.alistaElfo(new ElfoNoturno("Ranger"));
        exercito.alistaElfo(new ElfoNoturno("Fredyl"));
        exercito.alistaElfo(new ElfoNoturno("Nephil"));
        exercito.alistaElfo(new ElfoNoturno("Gorroko"));
        exercito.alistaElfo(new ElfoNoturno("Jardan"));
    }
    
    private void alistaElfosMisturadosComIgualdade(ExercitoDeElfos exercito){
        exercito.alistaElfo(new ElfoVerde("Ranger"));
        exercito.alistaElfo(new ElfoNoturno("Fredyl"));
        exercito.alistaElfo(new ElfoNoturno("Gorroko"));
        exercito.alistaElfo(new ElfoVerde("Nephil"));
        
    }
    
    private void alistaUmElfoVerdePrimeiro(ExercitoDeElfos exercito){
        exercito.alistaElfo(new ElfoNoturno("Fredyl"));
        exercito.alistaElfo(new ElfoNoturno("Gorroko"));
        exercito.alistaElfo(new ElfoNoturno("Nephil"));
        exercito.alistaElfo(new ElfoVerde("Ranger")); // HashCode deste elfo é o primeiro no arrayList dos vivos
        exercito.alistaElfo(new ElfoNoturno("Yagmoto"));
        exercito.alistaElfo(new ElfoVerde("Mitamo"));
        exercito.alistaElfo(new ElfoVerde("Mitsume"));
        exercito.alistaElfo(new ElfoVerde("Karazuko"));
        
    }
    
    private void alistaUmElfoNoturnoPrimeiro(ExercitoDeElfos exercito){
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
    public void exercitoAtacaDwarfsEstrategiaPorIntercalacaoSemIgualdade(){
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
    public void exercitoAtacaDwarfsEstrategiaPorIntercalacaoComIgualdade(){
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
    public void atacaDwarfsEstrategiaPorIntercalacaoGetOrdemVerdePrimeiro(){
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
    public void atacaDwarfsEstrategiaPorIntercalacaoGetOrdemNoturnoPrimeiro(){
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
}
