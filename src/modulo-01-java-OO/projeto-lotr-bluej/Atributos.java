public class Atributos {
    private String nome;
    protected int experiencia, vida;
    private Inventario inventario;
    private Status status;
    
    public Atributos(String nome,int vida){
        this.nome = nome;
        this.vida = vida;
        this.experiencia = 0;
        this.inventario = new Inventario();
        this.status = Status.VIVO;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public Inventario getInventario(){
        return this.inventario;
    }
    
    public void setStatus(Status status){
        this.status = status;
    }
}
