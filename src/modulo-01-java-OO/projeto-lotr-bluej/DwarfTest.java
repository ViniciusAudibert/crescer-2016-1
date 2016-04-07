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
    
    @Test
    public void testaDwarfStatusVivo(){
        Dwarf dwarf = new Dwarf("Anao");
        assertEquals(dwarf.getStatus(), Status.VIVO);
    }
    
    @Test
    public void testaDwarfStatusMorto(){
        Dwarf dwarf = new Dwarf("Anao");
        for(int i=0; i<11; i++){
            dwarf.perdeVida();
        }
        assertEquals(dwarf.getStatus(), Status.MORTO);
    }
}