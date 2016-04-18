import java.util.*;
public interface Estrategia {
    public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarfList);
    public ArrayList<Elfo> getOrdemDoUltimoAtaque();
}