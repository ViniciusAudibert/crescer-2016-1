import java.util.*;
public class AtaqueIntercalado implements Estrategia {
    private ArrayList<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
    
    public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarfList){
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.getExercitoDeElfosStatus().get(Status.VIVO);
        if(this.igualdadeDeElfos(elfosVivos)){
            elfosVivos = this.ordenaParaIntercalar(elfosVivos);
            for(int i=0; i<elfosVivos.size()/2; i++){
                this.tiraVidaDosDwarfs(dwarfList,elfosVivos.get(i));
                ordemDeAtaque.add(elfosVivos.get(i));
                this.tiraVidaDosDwarfs(dwarfList,elfosVivos.get(i + elfosVivos.size()/2));
                ordemDeAtaque.add(elfosVivos.get(i + elfosVivos.size()/2));
            }
        }
    }
    
    private void tiraVidaDosDwarfs(ArrayList<Dwarf> dwarfList, Elfo elfo){
        for(Dwarf dwarf : dwarfList){
            elfo.atirarFlecha(dwarf);
        }
    }
    
    private boolean igualdadeDeElfos(ArrayList<Elfo> elfosVivos){
        int contElfoVerde = 0;
        int contElfoNoturno = 0;
        for(Elfo elfo : elfosVivos){
            if(elfo instanceof ElfoVerde){contElfoVerde++;}
            else if(elfo instanceof ElfoNoturno){contElfoNoturno++;}
        }
        return contElfoVerde == contElfoNoturno;
    }
    
    @Override
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){     
        return ordemDeAtaque;
    }
    
    private ArrayList<Elfo> ordenaParaIntercalar(ArrayList<Elfo> elfosList){
        ArrayList<Elfo> arrayOrdenado = new ArrayList<>();
        ArrayList<Integer> indicesDosUltimos = new ArrayList<>();
        Elfo elfo;
        Elfo primeiroElfo = elfosList.get(0);
        for(int i=0; i<elfosList.size(); i++){
            elfo = elfosList.get(i);
            if(elfo.getClass().equals(primeiroElfo.getClass())){
                arrayOrdenado.add(elfo);
            }
            else{
                indicesDosUltimos.add(i);
            }
        }
        for(int i=0; i<indicesDosUltimos.size(); i++){
            elfo = elfosList.get(indicesDosUltimos.get(i));
            arrayOrdenado.add(elfo);
        }
        return arrayOrdenado;
    }
}
