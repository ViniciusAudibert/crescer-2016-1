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
        exercito.alistaElfo(new ElfoVerde("Nephil"));
        exercito.alistaElfo(new ElfoNoturno("Gorroko"));
    }
    
    @Test
    public void exercitoAtacaDwarfsEstrategiaPorIntercacaoSemIgualdade(){
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
    public void exercitoAtacaDwarfsEstrategiaPorIntercacaoComIgualdade(){
        ExercitoDeElfos exercitoElfos = new ExercitoDeElfos();
        ArrayList<Dwarf> exercitoDwarfs = exercitoDeDwarfs();
        Estrategia estrategia = new AtaqueIntercalado();
        alistaElfosMisturadosComIgualdade(exercitoElfos);
        estrategia.atacar(exercitoElfos,exercitoDwarfs); 
        for(Dwarf dwarf : exercitoDwarfs){
            assertTrue(dwarf.getVida() == 70);
        }
    }
}
