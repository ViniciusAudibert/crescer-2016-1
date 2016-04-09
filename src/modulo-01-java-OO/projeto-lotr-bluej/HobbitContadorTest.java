import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest {
    @Test
    public void calcularDiferenca(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));

        HobbitContador contador = new HobbitContador();
        int diferenca = contador.calcularDiferenca(arrayDePares);
        assertTrue(diferenca == 840);
    }
}
