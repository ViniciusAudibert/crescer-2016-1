import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest {
    @Test
    public void testaEhBissextoFevereiro29(){
        DataTerceiraEra d1 = new DataTerceiraEra(29,2,0);
        assertEquals(d1.ehBissexto(), true);
    }
    
    @Test
    public void testaEhBissextoFevereiro29(){
        DataTerceiraEra d2 = new DataTerceiraEra(28,2,0);
        assertEquals(d2.ehBissexto(), false);
    }
    
    @Test
    public void testaEhBissextoJaneiro31(){
        DataTerceiraEra d3 = new DataTerceiraEra(31,1,0);
        assertEquals(d3.ehBissexto(), false);
    }
    
}
