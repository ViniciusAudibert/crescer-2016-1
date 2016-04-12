import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest {
    @Test
    public void atiraUmaFlecha(){
        ElfoNoturno elfo = new ElfoNoturno("NightOne");
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        assertEquals(41, elfo.getFlechas());
        assertEquals(3, elfo.getAtributos().getExperiencia());
        assertEquals(dwarf.getAtributos().getVida(),100);
        assertTrue(elfo.atributos.getVida() == 95);
    }
    
    @Test
    public void atiraDuasFlechas(){
        ElfoNoturno elfo = new ElfoNoturno("NightOne");
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        assertEquals(40, elfo.getFlechas());
        assertEquals(6, elfo.getAtributos().getExperiencia());
        assertEquals(dwarf.getAtributos().getVida(),90);
        assertTrue(elfo.atributos.getVida() == 90);
    }
    
    @Test
    public void atirarTresFlechas(){
        ElfoNoturno elfo = new ElfoNoturno("NightOne", 120);
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        assertEquals(117, elfo.getFlechas());
        assertEquals(9, elfo.getAtributos().getExperiencia());
        assertEquals(dwarf.getAtributos().getVida(),80);
        assertTrue(elfo.atributos.getVida() == 85);
    }
    
    @Test
    public void atirarFlechasAteMorrer(){
        ElfoNoturno elfo = new ElfoNoturno("NightOne", 120);
        Dwarf dwarf = new Dwarf("Jumbe");
        for(int i= 0; i<100; i++){
            elfo.atirarFlecha(dwarf);
        }
        assertEquals(30, elfo.getFlechas());
        assertEquals(270, elfo.getAtributos().getExperiencia());
        assertTrue(elfo.atributos.getVida() == 0);
        assertTrue(elfo.atributos.getStatus() == Status.MORTO);
    }
}
