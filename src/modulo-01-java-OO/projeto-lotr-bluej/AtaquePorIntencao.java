import java.util.*;
public class AtaquePorIntencao implements Estrategia {
    @Override
    public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarfList){
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.getExercitoDeElfosStatus().get(Status.VIVO);
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
    
    @Override
    public void tiraVidaDosDwarfs(ArrayList<Dwarf> dwarfList, Elfo elfo){
        for(Dwarf dwarf : dwarfList){
            elfo.atirarFlecha(dwarf);
        }
    }
}
