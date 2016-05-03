import java.util.*;

public class ExercitoDeElfos {
    private HashMap<String,Elfo> exercitoDeElfos;
    private HashMap<Status,ArrayList<Elfo>> exercitoDeElfosStatus;
    private Estrategia estrategia;
        
    public ExercitoDeElfos() {
        this.exercitoDeElfos = new HashMap<>();
        this.exercitoDeElfosStatus = new HashMap<>();
        this.estrategia = new AtaqueNoturnoPorUltimo();
    }
    
    public void alistaElfo(Elfo elfo) throws NaoPodeAlistarException{
        if(!(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)){
            throw new NaoPodeAlistarException();
        }
        exercitoDeElfos.put(elfo.getNome(),elfo);
    }
    
    public Elfo buscaElfo(String nome){
        return exercitoDeElfos.get(nome);
    }
    
    public void agruparPorStatus(){
        this.exercitoDeElfosStatus.clear();
        for(Elfo chaveValor : exercitoDeElfos.values()){
            Status status = chaveValor.getStatus();
            if(!exercitoDeElfosStatus.containsKey(status)){
                exercitoDeElfosStatus.put(status,new ArrayList<Elfo>());
            }
            exercitoDeElfosStatus.get(status).add(chaveValor);
        }
    }
    
    public ArrayList<Elfo> busca(Status status){
        this.agruparPorStatus();
        return this.getExercitoDeElfosStatus().get(status);
    }
    
    public void atacar(ArrayList<Dwarf> dwarf){
        estrategia.atacar(this,dwarf);
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){     
        return estrategia.getOrdemDoUltimoAtaque();
    }
    
    public HashMap<String,Elfo> getExercitoDeElfos(){
        return this.exercitoDeElfos;
    }
    
    public HashMap<Status,ArrayList<Elfo>> getExercitoDeElfosStatus(){
        return this.exercitoDeElfosStatus;
    }
    
    public void mudarEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }
}
