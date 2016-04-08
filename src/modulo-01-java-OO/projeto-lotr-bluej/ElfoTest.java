import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void testaConstrutor(){
        Elfo elfo = new Elfo("Orelha");
        assertEquals(42, elfo.getFlechas());
        assertEquals("Orelha", elfo.getNome());
        assertEquals(0, elfo.getExperiencia());
    }
    
    @Test
    public void testaSobrecargaConstrutor(){
        Elfo elfo = new Elfo("Orelha",77);
        assertEquals("Orelha",elfo.getNome());
        assertEquals(77, elfo.getFlechas());
        assertEquals(0, elfo.getExperiencia());
    }
    
    @Test
    public void testaAtirarUmaFlecha(){
        Elfo elfo = new Elfo("Orelha");
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        assertEquals(41, elfo.getFlechas());
        assertEquals(1, elfo.getExperiencia());
        assertEquals(dwarf.getVida(),100);
    }
    
    @Test
    public void testaAtirarDuasFlechas(){
        Elfo elfo = new Elfo("Orelha");
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        assertEquals(40, elfo.getFlechas());
        assertEquals(2, elfo.getExperiencia());
        assertEquals(dwarf.getVida(),90);
    }
    
    @Test
    public void testaAtirarTresFlechas(){
        // Arrange
        Elfo elfo = new Elfo("Orelha", 120);
        Dwarf dwarf = new Dwarf("Jumbe");
        // Act
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        // Assert
        assertEquals(117, elfo.getFlechas());
        assertEquals(3, elfo.getExperiencia());
        assertEquals(dwarf.getVida(),80);
    }
    
    @Test
    public void testaToString(){
        Elfo elfo = new Elfo("Orelha");
        assertEquals(elfo.toString(), "Orelha possui 42 flechas e 0 níveis de experiência.");
    }
    
    @Test
    public void testaToString1(){
        Elfo elfo = new Elfo("Orelha", 1);
        assertEquals(elfo.toString(), "Orelha possui 1 flecha e 0 níveis de experiência.");
    }
    
    @Test
    public void testaToString2(){
        Elfo elfo = new Elfo("Orelha", 100);
        elfo.atirarFlecha(new Dwarf("Anao"));
        assertEquals(elfo.toString(), "Orelha possui 99 flechas e 1 nível de experiência.");
    }
}
