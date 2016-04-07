import java.util.*;

public class Inventario
{
    private ArrayList<Item> itens;
    
    public Inventario(){
        this.itens = new ArrayList<Item>();
    }
    
    public void adicionarItem(Item item){
        itens.add(item);
    }
    
    public void  removerItem(Item item){
        itens.remove(item);
    }
    
    public ArrayList<Item> getItens(){
        return this.itens;
    }
}
