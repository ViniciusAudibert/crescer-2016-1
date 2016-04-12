public class ElfoNoturno extends Elfo {
    private double vida;
    public ElfoNoturno(String nome){
        super(nome);
        vida = atributos.getVida();
    }
    public ElfoNoturno(String nome, int flechas){
        super(nome, flechas);
        vida = atributos.getVida();
    }
    
    public void atirarFlecha(Dwarf dwarf){ // Elfos Noturnos nao morrem pois nao existe um parametro que cheque se sua vida está zerada, pois entao ele poderia continuar até suas flechas acabarem.
        if(atributos.getStatus() == Status.VIVO){
            super.atirarFlecha(dwarf);
            atributos.experiencia += 2;
            this.vida -= this.vida * 0.05;
            if(this.vida <= 0){
                atributos.setStatus(Status.MORTO);
            }
        }
    }
    
    public double getVida(){
        return this.vida;
    }
}