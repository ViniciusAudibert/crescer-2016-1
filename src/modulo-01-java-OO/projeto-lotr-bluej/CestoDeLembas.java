public class CestoDeLembas {
    private int lembas;
    
    public CestoDeLembas(int lembas){
        this.lembas = lembas;
    }
    
    public boolean podeDividirEmPares(){
        if(lembas >= 4 && lembas >= 100 && lembas % 2 == 0){
                return true;
        }
        return false;
    }
}
