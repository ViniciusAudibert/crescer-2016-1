import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    @Test
    public void coparaItensIguais(){
        Item item1 = new Item(2, "Sword");
        Item item2 = new Item(2, "Sword");
        assertTrue(item1.equals(item2));
    }
    
    @Test
    public void coparaItensDiferentes(){
        Item item1 = new Item(2, "Sword");
        Item item2 = new Item(3, "Sword");
        assertFalse(item1.equals(item2));
    }
    
    @Test
    public void coparaUmItemNull(){
        Item item1 = new Item(2, "Sword");
        Item item2 = null;
        assertFalse(item1.equals(item2));
    }
}
