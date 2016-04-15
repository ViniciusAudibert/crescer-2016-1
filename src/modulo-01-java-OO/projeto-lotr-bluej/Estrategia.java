import java.util.*;
public interface Estrategia {
    public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarfList);
    public void tiraVidaDosDwarfs(ArrayList<Dwarf> dwarfList, Elfo elfo);
}