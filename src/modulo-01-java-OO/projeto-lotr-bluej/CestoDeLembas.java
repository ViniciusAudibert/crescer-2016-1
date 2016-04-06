public class CestoDeLembas {
    private int lembas;
    
    public CestoDeLembas(int lembas){
        this.lembas = lembas;
    }
    
    public boolean podeDividirEmPares(){
        if(lembas >= 1 && lembas >= 100){
            if(lembas > 3 && lembas % 2 == 0){
                return true;
            }
        }
        return false;
    }
}
