import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SindarinParaPortuguesTest {
    @Test
    public void traduzirNauParaPortugues(){
        TradutorSindarin tradutorPortugues = new SindarinParaPortugues();
        assertEquals("fogo",tradutorPortugues.traduzir("naur"));
    }
    
    @Test
    public void traduzirNullParaPortugues(){
        TradutorSindarin tradutorPortugues = new SindarinParaPortugues();
        assertNull(tradutorPortugues.traduzir("jabulaine"));
    }
}
