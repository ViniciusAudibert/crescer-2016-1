import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void testaConstrutor(){
        Elfo elfo = new Elfo("Guga");
        assertEquals(42, elfo.getFlechas());
        assertEquals("Guga", elfo.getNome());
        assertEquals(0, elfo.getExperiencia());
    }
    
    @Test
    public void testaSobrecargaConstrutor(){
        Elfo elfo = new Elfo("Guga",77);
        assertEquals("Guga",elfo.getNome());
        assertEquals(77, elfo.getFlechas());
        assertEquals(0, elfo.getExperiencia());
    }
    
    @Test
    public void testaAtirarFlecha(){
        Elfo elfo = new Elfo("Guga");
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        assertEquals(41, elfo.getFlechas());
        assertEquals(1, elfo.getExperiencia());
        assertEquals(dwarf.getVida(),100);
    }
    
    @Test
    public void testaToString(){
        Elfo elfo = new Elfo("Guga");
        assertEquals(elfo.toString(), elfo.getNome() + " possui "+ elfo.getFlechas() + " flechas e "
        + elfo.getExperiencia() + " níveis de experiência.");
    }
}
