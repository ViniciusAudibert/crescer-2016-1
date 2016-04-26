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
    
     @Test
    public void ordenaOsItens(){
        Dwarf dwarf = new Dwarf("Nome");
        dwarf.getInventario().adicionarItem(new Item(10, "Espada"));
        dwarf.getInventario().adicionarItem(new Item(7, "Adaga"));
        dwarf.getInventario().adicionarItem(new Item(5, "Arco"));
        dwarf.getInventario().adicionarItem(new Item(1, "Escudo"));
        dwarf.getInventario().ordenarItens();
        assertEquals(dwarf.getInventario().getItens().get(0).getDescricao(), "Escudo");
        assertEquals(dwarf.getInventario().getItens().get(1).getDescricao(), "Arco");
        assertEquals(dwarf.getInventario().getItens().get(2).getDescricao(), "Adaga");
        assertEquals(dwarf.getInventario().getItens().get(3).getDescricao(), "Espada");
    }
    
    @Test
    public void getDescricoesItensVazio() {
        Inventario inventario = new Inventario();
        String obtido = inventario.getDescricoesItens();
        assertEquals("", obtido);
    }

    @Test
    public void getDescricoesComUmItem() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item(1, "Espada"));
        String obtido = inventario.getDescricoesItens();
        assertEquals("Espada", obtido);
    }

    @Test
    public void getDescricoesComDoisItens() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item(1, "Espada"));
        inventario.adicionarItem(new Item(1, "Escudo"));
        String obtido = inventario.getDescricoesItens();
        assertEquals("Espada,Escudo", obtido);
    }

    @Test
    public void getItemComMaiorQuantidadeComInventarioVazio() {
        Inventario inventario = new Inventario();
        assertNull(inventario.itemMaiorQuantia());
    }

    @Test
    public void getItemComMaiorQuantidadeComApenasUmItem() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item(2, "Semente dos Deuses"));
        assertEquals(2, inventario.itemMaiorQuantia().getQuantidade());
    }

    @Test
    public void getItemComMaiorQuantidadeComTresItens() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item(15, "Flechas de gelo"));
        inventario.adicionarItem(new Item(20, "Lembas"));
        inventario.adicionarItem(new Item(2, "Semente dos Deuses"));
        assertEquals(20, inventario.itemMaiorQuantia().getQuantidade());
    }

    @Test
    public void ordenarItensMisturados() {
        Inventario mochila = new Inventario();
        Item elderScroll = new Item(9, "Elder Scroll");
        Item escudo = new Item(99, "Escudo");
        Item canivete = new Item(2, "Canivete suíço");
        mochila.adicionarItem(elderScroll);
        mochila.adicionarItem(escudo);
        mochila.adicionarItem(canivete);
        mochila.ordenarItens();
        assertEquals(canivete, mochila.getItens().get(0));
        assertEquals(elderScroll, mochila.getItens().get(1));
        assertEquals(escudo, mochila.getItens().get(2));
    }
    
    @Test
    public void ordenarItensComMesmaQuantidade() {
        Inventario mochila = new Inventario();
        Item elderScroll = new Item(9, "Elder Scroll");
        Item escudo = new Item(9, "Escudo");
        Item canivete = new Item(9, "Canivete suíço");
        mochila.adicionarItem(elderScroll);
        mochila.adicionarItem(escudo);
        mochila.adicionarItem(canivete);
        mochila.ordenarItens();
        assertEquals(elderScroll, mochila.getItens().get(0));
        assertEquals(escudo, mochila.getItens().get(1));
        assertEquals(canivete, mochila.getItens().get(2));
    }
    
    @Test
    public void ordenarItensVazio() {
        Inventario mochila = new Inventario();
        mochila.ordenarItens();
        assertEquals(0, mochila.getItens().size());
    }
}
