import java.util.*;
public class AtaqueNoturnoPorUltimo implements Estrategia {
    private ArrayList<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
    
    @Override
    public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarfList){
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.getExercitoDeElfosStatus().get(Status.VIVO);
        ArrayList<Integer> indicesNoturnos = new ArrayList<>();
        for(int i=0; i<elfosVivos.size(); i++){
            Elfo elfo = elfosVivos.get(i);
            if(elfo instanceof ElfoVerde){
                this.tiraVidaDosDwarfs(dwarfList,elfo);
                this.ordemDeAtaque.add(elfo);
            }
            else{
                indicesNoturnos.add(i);
            }
        }
        for(int i=0; i<indicesNoturnos.size(); i++){
            Elfo elfo = elfosVivos.get(indicesNoturnos.get(i));
            this.tiraVidaDosDwarfs(dwarfList,elfo);
            this.ordemDeAtaque.add(elfo);
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
