import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfosVerdesTest {
    @Test
    public void atiraUmaFlecha(){
        Elfo elfo = new ElfoVerde("Orelha");
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        assertEquals(41, elfo.getFlechas());
        assertEquals(2, elfo.getExperiencia());
        assertEquals(dwarf.getVida(),100);
    }
    
    @Test
    public void atiraDuasFlechas(){
        Elfo elfo = new ElfoVerde("Orelha");
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        assertEquals(40, elfo.getFlechas());
        assertEquals(4, elfo.getExperiencia());
        assertEquals(dwarf.getVida(),90);
    }
    
    @Test
    public void atirarTresFlechas(){
        Elfo elfo = new ElfoVerde("Orelha", 120);
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        assertEquals(117, elfo.getFlechas());
        assertEquals(6, elfo.getExperiencia());
        assertEquals(dwarf.getVida(),80);
    }
}
