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
    
    private void alistaElfos(ExercitoDeElfos exercito){
        exercito.alistaElfo(new ElfoNoturno("Ranger"));
        exercito.alistaElfo(new ElfoVerde("Fredyl"));
        exercito.alistaElfo(new ElfoNoturno("Nephil"));
        exercito.alistaElfo(new ElfoNoturno("Gorroko"));
    }
    
    @Test
    public void exercitoAtacaDwarfsEstrategiPorIntencoes(){
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
    public void exercitoAtacaDwarfsEstrategiPorIntencoesGetOrdem(){
        ExercitoDeElfos exercitoElfos = new ExercitoDeElfos();
        ArrayList<Dwarf> exercitoDwarfs = exercitoDeDwarfs();
        Estrategia estrategia = new AtaquePorIntencao();
        alistaElfos(exercitoElfos);
        estrategia.atacar(exercitoElfos,exercitoDwarfs); 
        assertEquals(estrategia.getOrdemDoUltimoAtaque().get(0).getNome(), "Ranger");
        assertEquals(estrategia.getOrdemDoUltimoAtaque().get(1).getNome(), "Fredyl");
    }
}
