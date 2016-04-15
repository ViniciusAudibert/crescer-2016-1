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
    
    private void tiraVidaDosDwarfs(ArrayList<Dwarf> dwarfList, Elfo elfo){
        for(Dwarf dwarf : dwarfList){
            elfo.atirarFlecha(dwarf);
        }
    }
    
    public void atacarDwarfsEstrategiaPorIntencoes(ArrayList<Dwarf> dwarfList){
        this.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercitoDeElfosStatus.get(Status.VIVO);
        int intencaoDeAtaque = elfosVivos.size() * dwarfList.size();
        intencaoDeAtaque *= 0.3;
        int contagemDosAtaques = 0;
        for(Elfo elfo : elfosVivos){
            if(elfo instanceof ElfoVerde){
                this.tiraVidaDosDwarfs(dwarfList,elfo);
            }
            else if((contagemDosAtaques < intencaoDeAtaque)&& elfo instanceof ElfoNoturno){
                this.tiraVidaDosDwarfs(dwarfList,elfo);
                contagemDosAtaques++;
            }
        }
    }
    
    public HashMap<String,Elfo> getExercitoDeElfos(){
        return this.exercitoDeElfos;
    }
    
    public HashMap<Status,ArrayList<Elfo>> getExercitoDeElfosStatus(){
        return this.exercitoDeElfosStatus;
    }
}
