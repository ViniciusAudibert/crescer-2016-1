import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest {
    @Test
    public void testaEhBissexto(){
        DataTerceiraEra d1 = new DataTerceiraEra(0,0,366);
        DataTerceiraEra d2 = new DataTerceiraEra(0,0,365);
        DataTerceiraEra d3 = new DataTerceiraEra(0,0,400);
        assertEquals(d1.ehBissexto(), true);
        assertEquals(d2.ehBissexto(), false);
        assertEquals(d3.ehBissexto(), false);
    }
}
