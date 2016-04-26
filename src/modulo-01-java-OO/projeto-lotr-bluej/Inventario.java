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
    
    public Item itemMaiorQuantia(){
        if(this.itens.isEmpty()){return null;}
        Item maior = this.getItens().get(0);
        for(int i=0; i<this.getItens().size(); i++){
            if(this.getItens().get(i).getQuantidade() > maior.getQuantidade()){
                maior = this.getItens().get(i);
            }
        }
        return maior;
    }
    
    public void ordenarItens(){
        boolean flag = true;
        while(flag){
            flag = false;
            for(int j=1; j<this.itens.size(); j++){
                if(this.itens.get(j).getQuantidade() < this.itens.get(j - 1).getQuantidade()){
                    Item temp = this.itens.get(j);
                    this.itens.set(j, this.itens.get(j - 1));
                    this.itens.set(j - 1, temp);
                    flag = true;
                }
            }
        }
    }
}
