import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void testaConstrutor(){
        Inventario inventario = new Inventario();
        assertTrue(inventario.getItens().isEmpty());
    }
    
    @Test
    public void testaAdicionarItem(){
        Inventario inventario = new Inventario();
        Item item = new Item(50, "Sword");
        inventario.adicionarItem(item);
        assertTrue(inventario.getItens().get(0) == item);
    }
    
     @Test
    public void testaRemoveItem(){
        Inventario inventario = new Inventario();
        Item item = new Item(50, "Sword");
        inventario.adicionarItem(item);
        inventario.removerItem(item);
        assertTrue(inventario.getItens().isEmpty());
    }
}
