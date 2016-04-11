public class ElfoVerde extends Elfo {
    public ElfoVerde(String nome){
        super(nome);
    }
    
    public ElfoVerde(String nome, int flechas){
        super(nome,flechas);
    }
    
    public void atirarFlecha(Dwarf dwarf){
        super.atirarFlecha(dwarf);
        experiencia++;
    }
}
