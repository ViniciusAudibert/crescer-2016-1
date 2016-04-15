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
        Elfo e2 = new ElfoVerde("Nopturne");
        Elfo e3 = new ElfoNoturno("Legolas",120);
        Elfo e4 = new ElfoNoturno("Night One",120);
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e3);
        exercito.alistaElfo(e4);
        for(int i=0; i<90; i++){
            e3.atirarFlecha(new Dwarf("Morto"));
            e4.atirarFlecha(new Dwarf("Morto"));
        }
        exercito.agruparPorStatus();
        assertTrue(exercito.getExercitoDeElfosStatus().get(Status.MORTO).contains(e4));
        assertTrue(exercito.getExercitoDeElfosStatus().get(Status.VIVO).contains(e2));
    }
    
    @Test
    public void buscaPeloStatus(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo e1 = new ElfoVerde("Ranger");
        Elfo e2 = new ElfoVerde("Nopturne");
        Elfo e3 = new ElfoNoturno("Legolas",120);
        Elfo e4 = new ElfoNoturno("Night One",120);
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e3);
        exercito.alistaElfo(e4);
        for(int i=0; i<90; i++){
            e3.atirarFlecha(new Dwarf("Morto"));
            e4.atirarFlecha(new Dwarf("Morto"));
        }
        exercito.agruparPorStatus();
        assertTrue(exercito.buscaPeloStatus(Status.MORTO).contains(e4));
        assertTrue(exercito.buscaPeloStatus(Status.VIVO).contains(e1));
    }
    
    @Test
    public void agrupaPorStatusDuasVezes(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo e1 = new ElfoNoturno("Ranger",120);
        Elfo e2 = new ElfoNoturno("Nopturne",120);
        Elfo e3 = new ElfoNoturno("Legolas",120);
        Elfo e4 = new ElfoNoturno("Night One",120);
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e3);
        exercito.alistaElfo(e4);
        for(int i=0; i<90; i++){
            e4.atirarFlecha(new Dwarf("DeadBorn"));
        }
        exercito.agruparPorStatus();
        assertTrue(exercito.getExercitoDeElfosStatus().get(Status.MORTO).contains(e4));
        assertTrue(exercito.getExercitoDeElfosStatus().get(Status.VIVO).contains(e2));
        for(int i=0; i<90; i++){
            e1.atirarFlecha(new Dwarf("DeadBorn"));
            e2.atirarFlecha(new Dwarf("DeadBorn"));
        }
        exercito.agruparPorStatus();
        assertFalse(exercito.getExercitoDeElfosStatus().get(Status.VIVO).contains(e1));
        assertFalse(exercito.getExercitoDeElfosStatus().get(Status.VIVO).contains(e2));
        assertFalse(exercito.getExercitoDeElfosStatus().get(Status.MORTO).contains(e3));
    }
    
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
        alistaElfos(exercitoElfos);
        exercitoElfos.atacarDwarfsEstrategiaPorIntencoes(exercitoDwarfs);
        for(Dwarf dwarf : exercitoDwarfs){
            assertTrue(dwarf.getVida() == 70);
        }
        assertTrue(exercitoElfos.getExercitoDeElfosStatus().get(Status.VIVO).get(4).getVida() == 100); // Ultimo elfo nao ataca e nao perde a vida.
    }
}
