import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest {
    @Test
    public void testaEhBissexto366(){
        DataTerceiraEra d1 = new DataTerceiraEra(366,0,0);
        assertEquals(d1.ehBissexto(), true);
    }
    
    @Test
    public void testaEhBissexto365(){
        DataTerceiraEra d2 = new DataTerceiraEra(365,0,0);
        assertEquals(d2.ehBissexto(), false);
    }
    
    @Test
    public void testaEhBissexto400(){
        DataTerceiraEra d3 = new DataTerceiraEra(400,0,0);
        assertEquals(d3.ehBissexto(), false);
    }
    
}
