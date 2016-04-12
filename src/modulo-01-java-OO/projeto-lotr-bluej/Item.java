public class Item{
    private int quantidade;
    private String descricao;
    
    public Item(int quantidade, String descricao){
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    
    public boolean equals(Object obj){
        return ((Item)obj) != null &&
        ((Item)obj).getDescricao() != null &&
        this.descricao != null &&
        this.quantidade == ((Item)obj).getQuantidade() && 
        this.descricao.equals(((Item)obj).getDescricao());
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
}