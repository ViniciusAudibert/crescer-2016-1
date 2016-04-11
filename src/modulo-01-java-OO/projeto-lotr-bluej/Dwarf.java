public class Dwarf {
    private DataTerceiraEra dataNascimento;
    protected Atributos atributos;
    public Dwarf(String nome){
        this.atributos = new Atributos(nome, 110);
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this(nome);
        this.dataNascimento = dataNascimento;
    }
    
    private void perdeVida(){
        if(atributos.vida - 10 < 0){
            atributos.vida = 0;
            atributos.setStatus(Status.MORTO);
        }
        else{
            atributos.vida -= 10;
            if(atributos.getVida() <= 0){
            atributos.setStatus(Status.MORTO);
            }
        }
    }
    
    public void receberFlecha(){
        if(this.getNumeroSorte() < 0){
            atributos.experiencia += 2;
        }
        else if(this.getNumeroSorte() < 0 || this.getNumeroSorte() > 100){
            this.perdeVida();
        }
    }
    
    public void adicionarItem(Item item){
        atributos.getInventario().adicionarItem(item);
    }
    
    public void perderItem(Item item){
        atributos.getInventario().removerItem(item);
    }
    
    public double getNumeroSorte(){
        double numero = 101.0;
        if(this.getDataNascimento().ehBissexto() && (atributos.getVida() >= 80 && atributos.getVida() <= 90)){
            return numero * -33;
        }
        if(!this.getDataNascimento().ehBissexto() && (atributos.getNome().equalsIgnoreCase("Seixas") ||
        atributos.getNome().equalsIgnoreCase("Meireles"))){
            return (numero * 33) % 100;
        }
        return numero;
    }
    
    public void tentarSorte(){
        if(this.getNumeroSorte() == -3333.0){
            for(int i=0; i<atributos.getInventario().getItens().size(); i++){
                atributos.getInventario().getItens().get(i).setQuantidade(atributos.getInventario().getItens().get(i).getQuantidade() + 1000);
            }
        }
    }
    
    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }
    
    public Atributos getAtributos(){
        return this.atributos;
    }
}