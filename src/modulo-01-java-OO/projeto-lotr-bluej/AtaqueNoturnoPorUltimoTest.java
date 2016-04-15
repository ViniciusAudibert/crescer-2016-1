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
    
    private void alistaElfos(ExercitoDeElfos exercito){
        exercito.alistaElfo(new ElfoNoturno("Ranger"));
        exercito.alistaElfo(new ElfoVerde("Fredyl"));
        exercito.alistaElfo(new ElfoVerde("Nephil"));
        exercito.alistaElfo(new ElfoNoturno("Gorroko"));
        exercito.alistaElfo(new ElfoVerde("Jardan"));
    }
    
    @Test
    public void exercitoAtacaDwarfsEstrategiaNoturnoPorUltimo(){
        ExercitoDeElfos exercitoElfos = new ExercitoDeElfos();
        ArrayList<Dwarf> exercitoDwarfs = exercitoDeDwarfs();
        Estrategia estrategia = new AtaqueNoturnoPorUltimo();
        alistaElfos(exercitoElfos);
        estrategia.atacar(exercitoElfos,exercitoDwarfs); 
        for(Dwarf dwarf : exercitoDwarfs){
            assertTrue(dwarf.getVida() == 60);
        }
        assertEquals(exercitoElfos.getExercitoDeElfosStatus().get(Status.VIVO).get(3).getNome(),"Ranger");
        assertEquals(exercitoElfos.getExercitoDeElfosStatus().get(Status.VIVO).get(4).getNome(),"Gorroko");
    }
}
