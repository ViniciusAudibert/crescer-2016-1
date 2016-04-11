import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest {
    @Test
    public void calcularDiferencaComTresPares(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));

        HobbitContador contador = new HobbitContador();
        int diferenca = contador.calcularDiferenca(arrayDePares);
        assertTrue(diferenca == 840);
    }
    
    @Test
    public void calcularDiferencaComSeisPares(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(13, 20)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(40, 40)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(14, 20)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 16)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(1, 28)));           
        arrayDePares.add(new ArrayList<>(Arrays.asList(60, 7)));
        
        HobbitContador contador = new HobbitContador();
        int diferenca = contador.calcularDiferenca(arrayDePares);
        assertTrue(diferenca == 1748);
    }
    
    @Test
    public void obterMaiorMultiploDeTresAte27(){
        HobbitContador contador = new HobbitContador();
        assertTrue(contador.obterMaiorMultiploDeTresAte(27) == 27);
    }
    
    @Test
    public void obterMaiorMultiploDeTresAte1012(){
        HobbitContador contador = new HobbitContador();
        assertTrue(contador.obterMaiorMultiploDeTresAte(1012) == 1011);
    }
    
    @Test
    public void retornaArrayListComMultiplosDeTresAte27(){
        HobbitContador contador = new HobbitContador();
        ArrayList<Integer> esperado = contador.retornaArrayListComMultiplosDeTresAte(27);
        assertTrue(esperado.get(esperado.size()-1) == 27);
    }
    
    @Test
    public void retornaArrayListComMultiplosDeTresAte1012(){
        HobbitContador contador = new HobbitContador();
        ArrayList<Integer> esperado = contador.retornaArrayListComMultiplosDeTresAte(1012);
        assertTrue(esperado.get(esperado.size()-1) == 1011);
    }
}
