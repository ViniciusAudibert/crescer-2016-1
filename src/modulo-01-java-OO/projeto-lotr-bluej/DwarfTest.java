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
        assertTrue(dwarf.getStatus() == Status.VIVO);
        assertTrue(dwarf.getDataNascimento().getDia() == 1);
        assertTrue(dwarf.getDataNascimento().getMes() == 1);
        assertTrue(dwarf.getDataNascimento().getAno() == 1);
    }
    
    @Test
     public void testaConstrutor2(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(12,7,2015);
        Dwarf dwarf = new Dwarf("Jumbeto", dataNascimento);
        assertEquals(110, dwarf.getVida());
        assertEquals("Jumbeto", dwarf.getNome());
        assertTrue(dwarf.getStatus() == Status.VIVO);
        assertTrue(dwarf.getDataNascimento().getDia() == 12);
        assertTrue(dwarf.getDataNascimento().getMes() == 7);
        assertTrue(dwarf.getDataNascimento().getAno() == 2015);
    }
    
    @Test
    public void testaAdicionarItem(){
        Dwarf dwarf = new Dwarf("Jumbeto");
        Item item = new Item(1,"Sword");
        dwarf.adicionarItem(item);
        assertTrue(dwarf.getInventario().getItens().get(0) == item);
    }
    
    @Test
    public void testaPerderItem(){
        Dwarf dwarf = new Dwarf("Jumbeto");
        Item item = new Item(1,"Sword");
        dwarf.adicionarItem(item);
        dwarf.perderItem(item);
        assertTrue(dwarf.getInventario().getItens().isEmpty());
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
    
    @Test
    public void testaDwarfVidaNegativa(){
        Dwarf dwarf = new Dwarf("Anao");
        for(int i=0; i<15; i++){
            dwarf.perdeVida();
        }
        assertEquals(dwarf.getStatus(), Status.MORTO);
        assertTrue(dwarf.getVida() >= 0);
    }
}
