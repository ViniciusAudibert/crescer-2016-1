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
    
    public String getDescricoesItens(){
        String retorno = "";
        for(int i=0; i<itens.size(); i++){
            retorno += itens.get(i).getDescricao();
            if(i != itens.size()-1){
                retorno += ",";
            }
        }
        return retorno;
    }
}
