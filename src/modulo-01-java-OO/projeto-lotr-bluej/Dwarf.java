public class Dwarf {
    private String nome;
    private int vida;
    private Status status;
    private Inventario inventario;
    private DataTerceiraEra dataNascimento;

    public Dwarf(String nome){
        this.nome = nome;
        this.vida = 110;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this(nome);
        this.dataNascimento = dataNascimento;
    }
    
    public void perdeVida(){
        if(vida - 10 < 0){
            this.vida = 0;
            status = status.MORTO;
        }
        else{
            this.vida -= 10;
            if(vida >= 0){
            status = status.MORTO;
            }
        }
    }
    
    public void adicionarItem(Item item){
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        this.inventario.removerItem(item);
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
}
