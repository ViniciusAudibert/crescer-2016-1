import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void contrutor(){
        Elfo elfo = new Elfo("Orelha");
        assertEquals(42, elfo.getFlechas());
        assertEquals("Orelha", elfo.getNome());
        assertEquals(0, elfo.getExperiencia());
    }
    
    @Test
    public void sobrecargaDoConstrutor(){
        Elfo elfo = new Elfo("Orelha",77);
        assertEquals("Orelha",elfo.getNome());
        assertEquals(77, elfo.getFlechas());
        assertEquals(0, elfo.getExperiencia());
    }
    
    @Test
    public void atiraUmaFlecha(){
        Elfo elfo = new Elfo("Orelha");
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        assertTrue(41 == elfo.getFlechas());
        assertTrue(1 == elfo.getExperiencia());
        assertTrue(dwarf.getVida() ==100);
    }
    
    @Test
    public void atiraDuasFlechas(){
        Elfo elfo = new Elfo("Orelha");
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        assertTrue(40 == elfo.getFlechas());
        assertTrue(2 == elfo.getExperiencia());
        assertTrue(dwarf.getVida() == 90);
    }
    
    @Test
    public void atirarTresFlechas(){
        // Arrange
        Elfo elfo = new Elfo("Orelha", 120);
        Dwarf dwarf = new Dwarf("Jumbe");
        // Act
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        // Assert
        assertTrue(117 == elfo.getFlechas());
        assertTrue(3 == elfo.getExperiencia());
        assertTrue(dwarf.getVida() == 80);
    }
    
    @Test
    public void toStringComVariaveisNoPlural(){
        Elfo elfo = new Elfo("Orelha");
        assertEquals(elfo.toString(), "Orelha possui 42 flechas e 0 níveis de experiência.");
    }
    
    @Test
    public void toStringComFlechasNoSingular(){
        Elfo elfo = new Elfo("Orelha", 1);
        
        assertEquals(elfo.toString(), "Orelha possui 1 flecha e 0 níveis de experiência.");
    }
    
    @Test
    public void toStringComNiveisNoSingular(){
        Elfo elfo = new Elfo("Orelha", 100);
        elfo.atirarFlecha(new Dwarf("Anao"));
        assertEquals(elfo.toString(), "Orelha possui 99 flechas e 1 nível de experiência.");
    }
}
