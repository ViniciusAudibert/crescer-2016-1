import java.util.*;
public class AtaqueNoturnoPorUltimo implements Estrategia {
    @Override
    public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarfList){
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.getExercitoDeElfosStatus().get(Status.VIVO);
        ordenaArrayDeElfosVivos(elfosVivos);
        for(Elfo elfo : elfosVivos){
            if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
                this.tiraVidaDosDwarfs(dwarfList,elfo);
            }
        }
    }
    
    private void tiraVidaDosDwarfs(ArrayList<Dwarf> dwarfList, Elfo elfo){
        for(Dwarf dwarf : dwarfList){
            elfo.atirarFlecha(dwarf);
        }
    }
    
    public void ordenaArrayDeElfosVivos(ArrayList<Elfo> elfoList){
        if(elfoList != null){
            for(int i=0; i<elfoList.size()-1; i++){
                    for(int j=1; j<elfoList.size(); j++){
                        if(elfoList.get(j-1) instanceof ElfoNoturno){
                            Elfo temp = elfoList.get(j);
                            elfoList.remove(j);
                            elfoList.add(j, elfoList.get(j-1));
                            elfoList.remove(j-1);
                            elfoList.add(j-1,temp);
                        }
                    }
            }
        }
    }
}
