import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {
    @Test
    public void testaConstrutor(){
        Dwarf dwarf = new Dwarf("Jumbeto");
        assertEquals(110, dwarf.getVida());
        assertEquals("Jumbeto", dwarf.getNome());
    }
    
    @Test
    public void testaPerdeVida(){
        Dwarf dwarf = new Dwarf("Jumbeto");
        dwarf.perdeVida();
        assertEquals(100, dwarf.getVida()); 
    }
}
