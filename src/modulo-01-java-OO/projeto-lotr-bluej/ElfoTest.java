import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void testaConstrutor(){
        Elfo elfo = new Elfo("Guga");
        boolean esperado = true;
        boolean obtido = elfo.getExperiencia() == 0;
        assertEquals(esperado, obtido);
        assertEquals("Guga", elfo.getNome());
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
}
