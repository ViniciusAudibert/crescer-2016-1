public class Atributos {
    private String nome;
    protected int experiencia;
    private Inventario inventario;
    
    public Atributos(String nome){
        this.nome = nome;
        this.experiencia = 0;
        this.inventario = new Inventario();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public Inventario getInventario(){
        return this.inventario;
    }
}
