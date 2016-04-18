import java.util.*;
public class AtaquePorIntencao implements Estrategia {
    private ArrayList<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
    int contagemDosAtaques = 0;
    
    @Override
    public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarfList){
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.getExercitoDeElfosStatus().get(Status.VIVO);
        int intencaoDeAtaque = elfosVivos.size() * dwarfList.size();
        intencaoDeAtaque *= 0.3;
        for(Elfo elfo : elfosVivos){
            if(elfo instanceof ElfoVerde){
                this.tiraVidaDosDwarfs(dwarfList,elfo);
                ordemDeAtaque.add(elfo);
            }
            else if((contagemDosAtaques < intencaoDeAtaque)&& elfo instanceof ElfoNoturno){
                this.tiraVidaDosDwarfs(dwarfList,elfo);
                ordemDeAtaque.add(elfo);
            }
        }
    }
   
    public void tiraVidaDosDwarfs(ArrayList<Dwarf> dwarfList, Elfo elfo){
        for(Dwarf dwarf : dwarfList){
            elfo.atirarFlecha(dwarf);
            contagemDosAtaques++;
        }
    }
    
    @Override
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){     
        return ordemDeAtaque;
    }
}
