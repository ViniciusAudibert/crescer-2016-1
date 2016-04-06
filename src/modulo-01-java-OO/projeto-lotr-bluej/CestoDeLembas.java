public class CestoDeLembas {
    private int lembas;
    private int paes;
    
    public CestoDeLembas(int lembas, int paes){
        this.lembas = lembas;
        this.paes = paes;
    }
    
    private boolean podeDividirEmPares(){
        if(paes >= 1 && paes >= 100){
            if(lembas > 3 && lembas%2 == 0){
                return true;
            }
        }
        return false;
    }
}
