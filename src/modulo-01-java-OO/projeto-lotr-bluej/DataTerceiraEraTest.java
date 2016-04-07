import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest {
    @Test
    public void testaEhBissexto2016(){
        DataTerceiraEra d1 = new DataTerceiraEra(25,2,2016);
        assertEquals(d1.ehBissexto(), true);
    }
    
    @Test
    public void testaEhBissexto2015(){
        DataTerceiraEra d2 = new DataTerceiraEra(5,2,2015);
        assertEquals(d2.ehBissexto(), false);
    }
    
    @Test
    public void testaEhBissexto2017(){
        DataTerceiraEra d3 = new DataTerceiraEra(31,1,2017);
        assertEquals(d3.ehBissexto(), false);
    }
    
    @Test
    public void testaEhBissexto2020(){
        DataTerceiraEra d3 = new DataTerceiraEra(31,1,2020);
        assertEquals(d3.ehBissexto(), true);
    }
}
