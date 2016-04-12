public class Dwarf extends Personagem {
    private DataTerceiraEra dataNascimento;
    public Dwarf(String nome){
        super(nome, 110);
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        super(nome,110);
        this.dataNascimento = dataNascimento;
    }
    
    private void perdeVida(){
        if(vida - 10 < 0){
            vida = 0;
            setStatus(Status.MORTO);
        }
        else{
            vida -= 10;
            if(getVida() <= 0){
            setStatus(Status.MORTO);
            }
        }
    }
    
    public void receberFlecha(){
        if(this.getNumeroSorte() < 0){
            experiencia += 2;
        }
        else if(this.getNumeroSorte() < 0 || this.getNumeroSorte() > 100){
            this.perdeVida();
        }
    }
    
    public void adicionarItem(Item item){
        getInventario().adicionarItem(item);
    }
    
    public void perderItem(Item item){
        getInventario().removerItem(item);
    }
    
    public double getNumeroSorte(){
        double numero = 101.0;
        if(this.getDataNascimento().ehBissexto() && (getVida() >= 80 && getVida() <= 90)){
            return numero * -33;
        }
        if(!this.getDataNascimento().ehBissexto() && (getNome().equalsIgnoreCase("Seixas") ||
        getNome().equalsIgnoreCase("Meireles"))){
            return (numero * 33) % 100;
        }
        return numero;
    }
    
    public void tentarSorte(){
        if(this.getNumeroSorte() == -3333.0){
            for(int i=0; i<getInventario().getItens().size(); i++){
                getInventario().getItens().get(i).setQuantidade(getInventario().getItens().get(i).getQuantidade() + 1000);
            }
        }
    }
    
    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }
}