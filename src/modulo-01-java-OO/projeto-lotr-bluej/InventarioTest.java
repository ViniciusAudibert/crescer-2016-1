import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void construtor(){
        Inventario inventario = new Inventario();
        assertTrue(inventario.getItens().isEmpty());
    }
    
    @Test
    public void adicionarUmItem(){
        Inventario inventario = new Inventario();
        Item item = new Item(50, "Sword");
        inventario.adicionarItem(item);
        assertTrue(inventario.getItens().get(0) == item);
    }
    
     @Test
    public void removeUmItem(){
        Inventario inventario = new Inventario();
        Item item = new Item(50, "Sword");
        inventario.adicionarItem(item);
        inventario.removerItem(item);
        assertTrue(inventario.getItens().isEmpty());
    }
    
     @Test
    public void getDescricoesDosItens(){
        Dwarf dwarf = new Dwarf("Nome");
        Item item = new Item(2, "Espada");
        Item item2 = new Item(2, "Adaga");
        Item item3 = new Item(2, "Arco");
        dwarf.getInventario().adicionarItem(item);
        dwarf.getInventario().adicionarItem(item2);
        dwarf.getInventario().adicionarItem(item3);
        String resposta = "Espada,Adaga,Arco";
        assertEquals(dwarf.getInventario().getDescricoesItens(), resposta);
    }
    
}
