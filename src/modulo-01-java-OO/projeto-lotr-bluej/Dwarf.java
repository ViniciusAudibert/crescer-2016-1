public class Dwarf extends Atributos {
    private int vida;
    private Status status;
    private DataTerceiraEra dataNascimento;

    public Dwarf(String nome){
        super(nome);
        this.vida = 110;
        this.status = Status.VIVO;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this(nome);
        this.dataNascimento = dataNascimento;
    }
    
    private void perdeVida(){
        if(vida - 10 < 0){
            this.vida = 0;
            status = status.MORTO;
        }
        else{
            this.vida -= 10;
            if(vida <= 0){
            status = status.MORTO;
            }
        }
    }
    
    public void receberFlecha(){
        if(this.getNumeroSorte() < 0){
            this.experiencia += 2;
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
        if(this.getDataNascimento().ehBissexto() && (this.getVida() >= 80 && this.getVida() <= 90)){
            return numero * -33;
        }
        if(!this.getDataNascimento().ehBissexto() && (this.getNome().equalsIgnoreCase("Seixas") ||
        this.getNome().equalsIgnoreCase("Meireles"))){
            return (numero * 33) % 100;
        }
        return numero;
    }
    
    public void tentarSorte(){
        if(this.getNumeroSorte() == -3333.0){
            for(int i=0; i<this.getInventario().getItens().size(); i++){
                this.getInventario().getItens().get(i).setQuantidade(this.getInventario().getItens().get(i).getQuantidade() + 1000);
            }
        }
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }
}