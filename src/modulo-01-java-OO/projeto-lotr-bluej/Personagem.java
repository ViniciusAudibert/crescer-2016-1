public class Personagem {
    private String nome;
    protected int experiencia;
    protected double vida;
    private Inventario inventario;
    private Status status;
    
    public Personagem(String nome,int vida){
        this.nome = nome;
        this.vida = vida;
        this.experiencia = 0;
        this.inventario = new Inventario();
        this.status = Status.VIVO;
    }
    
    public Personagem(String nome){
        this.nome = nome;
        this.vida = 0;
        this.experiencia = 0;
        this.inventario = new Inventario();
        this.status = Status.VIVO;
    }
    
    public double getVida(){
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
