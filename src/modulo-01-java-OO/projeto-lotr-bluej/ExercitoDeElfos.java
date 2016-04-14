import java.util.*;

public class ExercitoDeElfos {
    private HashMap<String,Elfo> exercitoDeElfos;
    private HashMap<Status,ArrayList<Elfo>> exercitoDeElfosStatus;
        
    public ExercitoDeElfos(){
        this.exercitoDeElfos = new HashMap<>();
        this.exercitoDeElfosStatus = new HashMap<>();
    }
    
    public void alistaElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            exercitoDeElfos.put(elfo.getNome(),elfo);
        }
    }
    
    public Elfo buscaElfo(String nome){
        return exercitoDeElfos.get(nome);
    }
    
    public void agruparPorStatus(){
        for(Elfo chaveValor : exercitoDeElfos.values()){
            Status status = chaveValor.getStatus();
            if(!exercitoDeElfosStatus.containsKey(status)){
                exercitoDeElfosStatus.put(status,new ArrayList<Elfo>());
            }
            exercitoDeElfosStatus.get(status).add(chaveValor);
        }
    }
    
    public ArrayList<Elfo> buscaPeloStatus(Status status){
        ArrayList<Elfo> listaDeElfosPorStatus = new ArrayList<>();
        for(Elfo chaveValor : exercitoDeElfos.values()){
            if(chaveValor.getStatus() == status){
                listaDeElfosPorStatus.add(chaveValor);
            }
        }
        return listaDeElfosPorStatus;
    }
    
    public HashMap<String,Elfo> getExercitoDeElfos(){
        return this.exercitoDeElfos;
    }
    
    public HashMap<Status,ArrayList<Elfo>> getExercitoDeElfosStatus(){
        return this.exercitoDeElfosStatus;
    }
}
