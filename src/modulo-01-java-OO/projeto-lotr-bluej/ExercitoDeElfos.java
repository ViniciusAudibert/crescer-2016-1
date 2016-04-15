import java.util.*;

public class ExercitoDeElfos {
    private HashMap<String,Elfo> exercitoDeElfos;
    private HashMap<Status,ArrayList<Elfo>> exercitoDeElfosStatus;
    private Estrategia estrategia;
        
    public ExercitoDeElfos(){
        this.exercitoDeElfos = new HashMap<>();
        this.exercitoDeElfosStatus = new HashMap<>();
        this.estrategia = new AtaqueNoturnoPorUltimo();
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
        this.exercitoDeElfosStatus.clear();
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
}
