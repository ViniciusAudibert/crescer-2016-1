import java.util.*;

public class ExercitoDeElfos {
    private HashMap<String,Elfo> exercitoDeElfos;
    private HashMap<Status,Elfo> exercitoDeElfosStatus;
        
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
        for(Map.Entry<String, Elfo> chaveValor : exercitoDeElfos.entrySet()){
            exercitoDeElfosStatus.put(chaveValor.getValue().getStatus(),chaveValor.getValue());
        }
    }
    
    public ArrayList<Elfo> buscaPeloStatus(Status status){
        ArrayList<Elfo> listaDeElfosPorStatus = new ArrayList<>();
        for(Map.Entry<String, Elfo> chaveValor : exercitoDeElfos.entrySet()){
            if(chaveValor.getValue().getStatus() == status){
                listaDeElfosPorStatus.add(chaveValor.getValue());
            }
        }
        return listaDeElfosPorStatus;
    }
    
    public HashMap<String,Elfo> getExercitoDeElfos(){
        return this.exercitoDeElfos;
    }
    
    public HashMap<Status,Elfo> getExercitoDeElfosStatus(){
        return this.exercitoDeElfosStatus;
    }
}
