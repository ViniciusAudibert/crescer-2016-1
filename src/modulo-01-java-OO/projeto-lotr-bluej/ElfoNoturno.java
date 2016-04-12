public class ElfoNoturno extends Elfo {
    public ElfoNoturno(String nome){
        super(nome);
    }
    public ElfoNoturno(String nome, int flechas){
        super(nome, flechas);
    }
    
    public void atirarFlecha(Dwarf dwarf){ // Elfos Noturnos nao morrem pois nao existe um parametro que cheque se sua vida está zerada, pois entao ele poderia continuar até suas flechas acabarem.
        if(atributos.getStatus() == Status.VIVO){
            super.atirarFlecha(dwarf);
            atributos.experiencia += 2;
            atributos.vida -= atributos.getVida() * 0.05;
            if(atributos.getVida() <= 0){
                atributos.setStatus(Status.MORTO);
            }
        }
    }
}