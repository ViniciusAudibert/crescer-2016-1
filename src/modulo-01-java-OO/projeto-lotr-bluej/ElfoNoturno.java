public class ElfoNoturno extends Elfo {
    private double vidaReal;
    public ElfoNoturno(String nome){
        super(nome);
        this.vidaReal = atributos.getVida();
    }
    public ElfoNoturno(String nome, int flechas){
        super(nome, flechas);
        this.vidaReal = atributos.getVida();
    }
    
    public void atirarFlecha(Dwarf dwarf){ // Elfos Noturnos nao morrem pois nao existe um parametro que cheque se sua vida está zerada, pois entao ele poderia continuar até suas flechas acabarem.
        if(atributos.getStatus() == Status.VIVO){
            super.atirarFlecha(dwarf);
            atributos.experiencia += 2;
            this.vidaReal -= this.vidaReal * 0.05;
            atributos.vida = (int) this.vidaReal;
            if(atributos.vida < 1){
                atributos.setStatus(Status.MORTO);
                atributos.vida = 0;
            }
        }
    }   
}