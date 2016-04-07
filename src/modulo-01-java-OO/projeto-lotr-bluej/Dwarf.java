public class Dwarf {
    private String nome;
    private int vida;
    private Status status;

    public Dwarf(String nome){
        this.nome = nome;
        this.vida = 110;
        this.status = Status.VIVO;
    }
    
    public void perdeVida(){
        this.vida -= 10;
        if(vida >= 0){
            status = status.MORTO;
        }
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Status getStatus(){
        return this.status;
    }
}
