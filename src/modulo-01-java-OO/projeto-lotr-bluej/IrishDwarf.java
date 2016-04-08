public class IrishDwarf {
    private String nome;
    private int vida, experiencia;
    private Status status;
    private Inventario inventario;
    private DataTerceiraEra dataNascimento;

    public IrishDwarf(String nome){
        this.nome = nome;
        this.vida = 110;
        this.experiencia = 0;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento){
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
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        this.inventario.removerItem(item);
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
                int soma = 0;
                for(int j=1; j <= this.getInventario().getItens().get(i).getQuantidade(); j++){
                    soma += j;
                }
                int quantidade = this.getInventario().getItens().get(i).getQuantidade();
                this.getInventario().getItens().get(i).setQuantidade((1000 * soma) + quantidade);
            }
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
    
    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }
    
    public Inventario getInventario(){
        return this.inventario;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
}