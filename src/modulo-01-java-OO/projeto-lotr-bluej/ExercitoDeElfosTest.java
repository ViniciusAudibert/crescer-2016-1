import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class ExercitoDeElfosTest {
    @Test
    public void alistaElfos(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo e1 = new Elfo("Ranger");
        Elfo e2 = new ElfoVerde("Nopturne");
        Elfo e3 = new ElfoNoturno("Legolas");
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e3);
        assertNull(exercito.getExercitoDeElfos().get("Ranger"));
        assertEquals(exercito.getExercitoDeElfos().get("Nopturne"),e2);
        assertEquals(exercito.getExercitoDeElfos().get("Legolas"),e3);
    }
    
    @Test
    public void buscaElfo(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo e1 = new Elfo("Ranger");
        Elfo e2 = new ElfoVerde("Nopturne");
        Elfo e3 = new ElfoNoturno("Legolas");
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e3);
        assertNull(exercito.buscaElfo("Ranger"));
        assertEquals(exercito.buscaElfo("Nopturne"),e2);
        assertEquals(exercito.buscaElfo("Legolas"),e3);
    }
    
    @Test
    public void agruparPorStatus(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo e1 = new ElfoVerde("Ranger");
        Elfo e2 = new ElfoVerde("Nopturne",120);
        Elfo e3 = new ElfoNoturno("Legolas",120);
        Elfo e4 = new ElfoNoturno("Night One",120);
        Elfo e5 = new ElfoNoturno("Star Arrower");
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e3);
        exercito.alistaElfo(e4);
        exercito.alistaElfo(e5);
        for(int i=0; i<90; i++){
            e3.atirarFlecha(new Dwarf("Morto"));
            e4.atirarFlecha(new Dwarf("Morto"));
        }
        exercito.agruparPorStatus();
        assertTrue(exercito.buscaPeloStatus(Status.MORTO).contains("Legolas"));
        assertTrue(exercito.buscaPeloStatus(Status.MORTO).contains("Night One"));
    }
    
    @Test
    public void buscaPeloStatus(){
    
    }
}
