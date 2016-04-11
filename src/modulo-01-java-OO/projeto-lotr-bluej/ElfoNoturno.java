public class ElfoNoturno extends Elfo {
    public ElfoNoturno(String nome){
        super(nome);
    }
    public ElfoNoturno(String nome, int flechas){
        super(nome, flechas);
    }
    
    public void atirarFlecha(Dwarf dwarf){
        super.atirarFlecha(dwarf);
        atributos.experiencia += 2;
        atributos.vida -= atributos.getVida() * 0.05;
    }
}