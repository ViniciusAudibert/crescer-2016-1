import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest {
    @Test
    public void atiraUmaFlecha(){
        Elfo elfo = new ElfoVerde("Orelha");
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        assertTrue(41 == elfo.getFlechas());
        assertTrue(2 == elfo.getExperiencia());
        assertTrue(dwarf.getVida() == 100);
    }
    
    @Test
    public void atiraDuasFlechas(){
        Elfo elfo = new ElfoVerde("Orelha");
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        assertTrue(40 == elfo.getFlechas());
        assertTrue(4 == elfo.getExperiencia());
        assertTrue(dwarf.getVida() == 90);
    }
    
    @Test
    public void atirarTresFlechas(){
        Elfo elfo = new ElfoVerde("Orelha", 120);
        Dwarf dwarf = new Dwarf("Jumbe");
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        assertTrue(117 == elfo.getFlechas());
        assertTrue(6 == elfo.getExperiencia());
        assertTrue(dwarf.getVida() == 80);
    }
    
    @Test
    public void adicionarUmItemPermitido(){
        ElfoVerde elfo = new ElfoVerde("Jumbeto");
        Item item = new Item(1,"Espada de aço valiriano");
        elfo.adicionarItem(item);
        assertTrue(elfo.getInventario().getItens().get(0) == item);
    }
    
    @Test
    public void adicionarUmItemNaoPermitido(){
        ElfoVerde elfo = new ElfoVerde("Ranger");
        Item item = new Item(1,"Sword");
        elfo.adicionarItem(item);
        assertTrue(elfo.getInventario().getItens().isEmpty());
    }
    
    @Test
    public void adicionarDoisItensPermitidos(){
        ElfoVerde elfo = new ElfoVerde("Ranger");
        Item item = new Item(1,"Espada de aço valiriano");
        Item item2 = new Item(1,"Arco e Flecha de Vidro");
        elfo.adicionarItem(item);
        elfo.adicionarItem(item2);
        assertTrue(elfo.getInventario().getItens().get(0) == item);
        assertTrue(elfo.getInventario().getItens().get(1) == item2);
    }
}
