import java.util.*;
public class AtaqueNoturnoPorUltimo implements Estrategia {
    private ArrayList<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
    
    @Override
    public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarfList){
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.getExercitoDeElfosStatus().get(Status.VIVO);
        exercito.ordenaArrayDeElfosVivos(elfosVivos);
        for(Elfo elfo : elfosVivos){
            if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
                this.tiraVidaDosDwarfs(dwarfList,elfo);
                ordemDeAtaque.add(elfo);
            }
        }
    }
    
    @Override
    public void tiraVidaDosDwarfs(ArrayList<Dwarf> dwarfList, Elfo elfo){
        for(Dwarf dwarf : dwarfList){
            elfo.atirarFlecha(dwarf);
        }
    }
    
    @Override
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){     
        return ordemDeAtaque;
    }
}
