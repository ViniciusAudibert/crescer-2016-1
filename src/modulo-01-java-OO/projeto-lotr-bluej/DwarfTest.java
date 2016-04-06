import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {
    @Test
    public void testaConstrutor(){
        Dwarf dwarf = new Dwarf("Jumbeto");
        boolean esperado = true;
        boolean obtido = dwarf.getVida() == 110;
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void testaPerdeVida(){
        Dwarf dwarf = new Dwarf("Jumbeto");
        boolean esperado = true;
        dwarf.perdeVida();
        boolean obtido = dwarf.getVida() == 100;
        assertEquals(esperado, obtido); 
    }
}
