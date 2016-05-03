import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class ExercitoDeElfosTest {
    @Test
    public void alistaElfos() throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo e1 = new ElfoVerde("Nopturne");
        Elfo e2 = new ElfoNoturno("Legolas");
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        assertEquals(exercito.getExercitoDeElfos().get("Nopturne"),e1);
        assertEquals(exercito.getExercitoDeElfos().get("Legolas"),e2);
    }
    
    @Test
    public void buscaElfo() throws NaoPodeAlistarException{
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo e1 = new ElfoVerde("Nopturne");
        Elfo e2 = new ElfoNoturno("Legolas");
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        assertEquals(exercito.buscaElfo("Nopturne"),e1);
        assertEquals(exercito.buscaElfo("Legolas"),e2);
    }
    
    @Test
    public void agruparPorStatus() throws NaoPodeAlistarException{
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
    public void buscaPeloStatus() throws NaoPodeAlistarException{
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
        assertTrue(exercito.busca(Status.MORTO).contains(e4));
        assertTrue(exercito.busca(Status.VIVO).contains(e1));
    }
    
    @Test
    public void agrupaPorStatusDuasVezes() throws NaoPodeAlistarException{
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
      
    @Test
    public void buscarElfoPorNomeInexistente() throws NaoPodeAlistarException {
        Elfo elfo = new ElfoNoturno("Night Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(elfo);
        assertNull(exercito.buscaElfo("Birinight Legolas"));
    }

    @Test
    public void buscarElfoPorNomeInexistenteExercitoVazio() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        assertNull(exercito.buscaElfo("Birinight Legolas"));
    }

    @Test(expected=NaoPodeAlistarException.class)
    public void buscarElfoNomeValidoTipoInvalido() throws NaoPodeAlistarException {
        Elfo elfo = new Elfo("Night Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(elfo);
        assertNull(exercito.buscaElfo("Night Legolas"));
    }

    @Test
    public void buscaElfosVivos() throws NaoPodeAlistarException {
        ElfoVerde elfoVivo1 = new ElfoVerde("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        Elfo elfoMorto1 = criarElfoNoturnoMorto("Dead Elf 1");
        Elfo elfoMorto2 = criarElfoNoturnoMorto("Dead Elf 2");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(elfoMorto1);
        exercito.alistaElfo(elfoMorto2);
        exercito.alistaElfo(elfoVivo1);
        exercito.alistaElfo(elfoVivo2);
        exercito.alistaElfo(elfoVivo3);
        exercito.agruparPorStatus();
        ArrayList<Elfo> vivos = exercito.busca(Status.VIVO);
        assertTrue(vivos.contains(elfoVivo1));
        assertTrue(vivos.contains(elfoVivo2));
        assertTrue(vivos.contains(elfoVivo3));
    }

    @Test
    public void buscaElfosMortos() throws NaoPodeAlistarException {
        ExercitoDeElfos exercito = criarExercitoDeMortosEVivos();
        exercito.agruparPorStatus();
        ArrayList<Elfo> mortos = exercito.busca(Status.MORTO);
        assertTrue(mortos.contains(exercito.buscaElfo("Dead Elf 1")));
        assertTrue(mortos.contains(exercito.buscaElfo("Dead Elf 2")));
    }

    private ExercitoDeElfos criarExercitoDeMortosEVivos() throws NaoPodeAlistarException {
        ElfoVerde elfoVivo1 = new ElfoVerde("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        Elfo elfoMorto1 = criarElfoNoturnoMorto("Dead Elf 1");
        Elfo elfoMorto2 = criarElfoNoturnoMorto("Dead Elf 2");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(elfoMorto1);
        exercito.alistaElfo(elfoMorto2);
        exercito.alistaElfo(elfoVivo1);
        exercito.alistaElfo(elfoVivo2);
        exercito.alistaElfo(elfoVivo3);
        return exercito;
    }
    
    private Elfo criarElfoNoturnoMorto(String nome) {
        Elfo elfo = new ElfoNoturno(nome,100);
        for (int i = 0; i < 90; i++) {
            elfo.atirarFlecha(new Dwarf("Gimli"));
        }
        return elfo;
    }
}
