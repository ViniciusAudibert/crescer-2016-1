public class Dwarf {
    private String nome;
    private int vida;

    public Dwarf(String nome){
        this.nome = nome;
        this.vida = 110;
    }
    
    public void perdeVida(){
        this.vida -= 10;
    }
}
