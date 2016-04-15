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
        dwarfList.add(new Dwarf("Onyotto"));
        return dwarfList;
    }
    
    private void alistaElfos(ExercitoDeElfos exercito){
        exercito.alistaElfo(new ElfoNoturno("Ranger"));
        exercito.alistaElfo(new ElfoNoturno("Fredyl"));
        exercito.alistaElfo(new ElfoNoturno("Nephil"));
        exercito.alistaElfo(new ElfoNoturno("Gorroko"));
        exercito.alistaElfo(new ElfoNoturno("Jardan"));
    }
    
    @Test
    public void exercitoAtacaDwarfsEstrategiPorIntencoes(){
        ExercitoDeElfos exercitoElfos = new ExercitoDeElfos();
        ArrayList<Dwarf> exercitoDwarfs = exercitoDeDwarfs();
        Estrategia estrategia = new AtaquePorIntencao();
        alistaElfos(exercitoElfos);
    estrategia.atacar(exercitoElfos,exercitoDwarfs); 
        for(Dwarf dwarf : exercitoDwarfs){
            assertTrue(dwarf.getVida() == 70);
        }
        assertTrue(exercitoElfos.getExercitoDeElfosStatus().get(Status.VIVO).get(4).getVida() == 100); // Ultimo elfo nao ataca e nao perde a vida.
    }
}
