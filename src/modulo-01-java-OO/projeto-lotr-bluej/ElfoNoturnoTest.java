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
        assertTrue(41 == elfo.getFlechas());
        assertTrue(3 == elfo.getExperiencia());
        assertTrue(dwarf.getVida() == 100);
        assertTrue(elfo.getVida() == 95);
    }
    
    @Test
    public void atiraDuasFlechas(){
        ElfoNoturno elfo = new ElfoNoturno("NightOne");
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        assertTrue(40 == elfo.getFlechas());
        assertTrue(6 == elfo.getExperiencia());
        assertTrue(dwarf.getVida() == 90);
        assertTrue((int)elfo.getVida() == 90);
    }
    
    @Test
    public void atirarTresFlechas(){
        ElfoNoturno elfo = new ElfoNoturno("NightOne", 120);
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        assertTrue(117 == elfo.getFlechas());
        assertTrue(9 == elfo.getExperiencia());
        assertTrue(dwarf.getVida() == 80);
        assertTrue((int)elfo.getVida() == 85);
    }
    
    @Test
    public void atirarFlechasAteMorrer(){
        ElfoNoturno elfo = new ElfoNoturno("NightOne", 120);
        Dwarf dwarf = new Dwarf("Jumbe");
        for(int i= 0; i<100; i++){
            elfo.atirarFlecha(dwarf);
        }
        assertTrue(30 == elfo.getFlechas());
        assertTrue(270 == elfo.getExperiencia());
        assertTrue(elfo.getVida() == 0);
        assertTrue(elfo.getStatus() == Status.MORTO);
    }
}
