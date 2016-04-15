import java.util.*;
public class AtaqueIntercalado implements Estrategia {
    private ArrayList<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
    
    public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarfList){
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.getExercitoDeElfosStatus().get(Status.VIVO);
        if(this.igualdadeDeElfos(elfosVivos)){
            exercito.ordenaArrayDeElfosVivos(elfosVivos);
            for(int i=0; i<elfosVivos.size()/2; i++){
                this.tiraVidaDosDwarfs(dwarfList,elfosVivos.get(i));
                ordemDeAtaque.add(elfosVivos.get(i));
                this.tiraVidaDosDwarfs(dwarfList,elfosVivos.get(i + elfosVivos.size()/2));
                ordemDeAtaque.add(elfosVivos.get(i + elfosVivos.size()/2));
            }
        }
    }
    
    @Override
    public void tiraVidaDosDwarfs(ArrayList<Dwarf> dwarfList, Elfo elfo){
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
        return contElfoVerde - contElfoNoturno == 0;
    }
    
    @Override
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){     
        return ordemDeAtaque;
    }
}
