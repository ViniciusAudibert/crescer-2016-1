import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest {
    @Test
    public void Construtor(){
        Dwarf dwarf = new Dwarf("Jumbeto");
        assertEquals(110, dwarf.getVida());
        assertEquals("Jumbeto", dwarf.getNome());
        assertTrue(dwarf.getStatus() == Status.VIVO);
        assertTrue(dwarf.getDataNascimento().getDia() == 1);
        assertTrue(dwarf.getDataNascimento().getMes() == 1);
        assertTrue(dwarf.getDataNascimento().getAno() == 1);
    }
    
    @Test
     public void segundoConstrutor(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(12,7,2015);
        Dwarf dwarf = new Dwarf("Jumbeto", dataNascimento);
        assertEquals(110, dwarf.getVida());
        assertEquals("Jumbeto", dwarf.getNome());
        assertTrue(dwarf.getStatus() == Status.VIVO);
        assertTrue(dwarf.getDataNascimento().getDia() == 12);
        assertTrue(dwarf.getDataNascimento().getMes() == 7);
        assertTrue(dwarf.getDataNascimento().getAno() == 2015);
    }
    
    @Test
    public void adicionarUmItem(){
        Dwarf dwarf = new Dwarf("Jumbeto");
        Item item = new Item(1,"Sword");
        dwarf.adicionarItem(item);
        assertTrue(dwarf.getInventario().getItens().get(0) == item);
    }
    
    @Test
    public void perdeUmItem(){
        Dwarf dwarf = new Dwarf("Jumbeto");
        Item item = new Item(1,"Sword");
        dwarf.adicionarItem(item);
        dwarf.perderItem(item);
        assertTrue(dwarf.getInventario().getItens().isEmpty());
    }
    
    @Test
    public void perdeVida(){
        Dwarf dwarf = new Dwarf("Jumbeto");
        dwarf.receberFlecha();
        assertEquals(100, dwarf.getVida()); 
    }
    
    @Test
    public void dwarfStatusVivo(){
        Dwarf dwarf = new Dwarf("Anao");
        assertEquals(dwarf.getStatus(), Status.VIVO);
    }
    
    @Test
    public void dwarfStatusMorto(){
        Dwarf dwarf = new Dwarf("Anao");
        for(int i=0; i<11; i++){
            dwarf.receberFlecha();
        }
        assertEquals(dwarf.getStatus(), Status.MORTO);
    }
    
    @Test
    public void perdeTodaVida(){
        Dwarf dwarf = new Dwarf("Anao");
        for(int i=0; i<15; i++){
            dwarf.receberFlecha();
        }
        assertEquals(dwarf.getStatus(), Status.MORTO);
        assertTrue(dwarf.getVida() >= 0);
    }
    
    @Test
    public void sorteiaNumero(){
        Dwarf dwarf = new Dwarf("Anao");
        assertTrue(dwarf.getNumeroSorte() == 101.0);
    }
    
    @Test
    public void sorteiaNumeroComAnoBissexto(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(5,6,1016);
        Dwarf dwarf = new Dwarf("Anao",dataNascimento);
        assertTrue(dwarf.getNumeroSorte() == 101.0);    
        for(int i = 0; i <= 2; i++){
            dwarf.receberFlecha();
        }
        double retorno = 101.0 * -33;
        assertTrue(dwarf.getNumeroSorte() == retorno);
    }
    
    @Test
    public void sorteiaNumeroComNomeSeixas(){
        Dwarf dwarf = new Dwarf("Seixas");
        double retorno = (101.0 * 33) % 100;
        assertTrue(dwarf.getNumeroSorte() == retorno);
    }
    
    @Test
    public void recebeUmaFlechadaDwarfAnoBissexto(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(5,6,1016);
        Dwarf dwarf = new Dwarf("Anao",dataNascimento);
        for(int i = 0 ; i <= 6 ; i++){
            dwarf.receberFlecha();
        }
        assertTrue(dwarf.getVida() == 90);
        assertTrue(dwarf.getExperiencia() == 10);
    }
    
    @Test
    public void recebeUmaFlechadaDwarfMeireles(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(5,6,1021);
        Dwarf dwarf = new Dwarf("Meireles",dataNascimento);
        for(int i = 0 ; i <= 6 ; i++){
            dwarf.receberFlecha();
        }
        assertTrue(dwarf.getVida() == 110);
        assertTrue(dwarf.getExperiencia() == 0);
    }
    
    @Test
    public void recebeFlechadaSeteVezes(){
        Dwarf dwarf = new Dwarf("joca");
        for(int i = 0 ; i <= 6 ; i++){
            dwarf.receberFlecha();
        }
        assertTrue(dwarf.getVida() == 40);
        assertTrue(dwarf.getExperiencia() == 0);
    }
    
    @Test
    public void tentaSorteUmItem(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(5,6,1016);
        IrishDwarf dwarf = new IrishDwarf("Anao",dataNascimento);
        dwarf.getInventario().adicionarItem(new Item(2,"Adaga"));
        for(int i = 0; i <= 2; i++){
            dwarf.receberFlecha();
        }
        dwarf.tentarSorte();
        assertEquals(dwarf.getInventario().getItens().get(0).getQuantidade(), 3002);
    }
    
    @Test
    public void tentaSorteDoisItens(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(5,6,1016);
        IrishDwarf dwarf = new IrishDwarf("Anao",dataNascimento);
        dwarf.getInventario().adicionarItem(new Item(2,"Adaga"));
        dwarf.getInventario().adicionarItem(new Item(4,"Escudo"));
        for(int i = 0; i <= 2; i++){
            dwarf.receberFlecha();
        }
        dwarf.tentarSorte();
        assertEquals(dwarf.getInventario().getItens().get(0).getQuantidade(), 3002);
        assertEquals(dwarf.getInventario().getItens().get(1).getQuantidade(), 10004);
    }
}