import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    @Test
    public void contrutor(){
        Item item = new Item(2, "Sword");
        assertTrue(item.getQuantidade() == 2);
        assertTrue(item.getDescricao() == "Sword");
    }
}
