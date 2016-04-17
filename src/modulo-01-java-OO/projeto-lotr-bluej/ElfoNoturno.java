public class ElfoNoturno extends Elfo {
    public ElfoNoturno(String nome){
        super(nome);
    }
    public ElfoNoturno(String nome, int flechas){
        super(nome,flechas);
    }
    
    public void atirarFlecha(Dwarf dwarf){ // Elfos Noturnos nao morrem pois nao existe um parametro que cheque se sua vida está zerada, pois entao ele poderia continuar até suas flechas acabarem.
        if(( getStatus() == Status.VIVO ) && ( getFlechas() > 0 )){
            super.atirarFlecha(dwarf);
            experiencia += 2;
            vida -= vida * 0.05;
            if(vida < 1){
                status = Status.MORTO;
                vida = 0;
            }
        }
    }   
}