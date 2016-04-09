import java.util.*;
public class HobbitContador {
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares){
        int somaDaDiferenca = 0;
        ArrayList<Integer> produtoDoArray = new ArrayList<>();
        ArrayList<Integer> mmcDoArray = new ArrayList<>();
        for(int i=0; i<arrayDePares.size(); i++){
            produtoDoArray.add(arrayDePares.get(i).get(0) * arrayDePares.get(i).get(1));
            for(int j=1; true; j++){
                if((j % arrayDePares.get(i).get(0) == 0) && (j % arrayDePares.get(i).get(1) == 0)){
                    mmcDoArray.add(j);
                    break;
                }
            }
            somaDaDiferenca += produtoDoArray.get(i) - mmcDoArray.get(i);
        }
        return somaDaDiferenca;
    }
}
