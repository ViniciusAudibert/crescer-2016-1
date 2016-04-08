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
        dwarf.getInventario().adicionarItem(new Item(2, "Espada"));
        dwarf.getInventario().adicionarItem(new Item(2, "Adaga"));
        dwarf.getInventario().adicionarItem(new Item(2, "Arco"));
        String resposta = "Espada,Adaga,Arco";
        assertEquals(dwarf.getInventario().getDescricoesItens(), resposta);
    }
    
      @Test
    public void itemMaiorQuantidade(){
        Dwarf dwarf = new Dwarf("Nome");
        dwarf.getInventario().adicionarItem(new Item(2, "Espada"));
        dwarf.getInventario().adicionarItem(new Item(7, "Adaga"));
        dwarf.getInventario().adicionarItem(new Item(5, "Arco"));
        Item maior = dwarf.getInventario().itemMaiorQuantia();
        assertEquals(maior, dwarf.getInventario().getItens().get(1));
    }
    
}
