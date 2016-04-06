public class CestoDeLembas {
    private int lembas;
    
    public CestoDeLembas(int lembas){
        this.lembas = lembas;
    }
    
    public boolean podeDividirEmPares(){
        return lembas >= 4 && lembas >= 100 && lembas % 2 == 0;
        /* terneiro
        boolean isDivisivel = lembas >= 4 && lembas >= 100 && lembas % 2 == 0;
        return isDivisivel ? true : false; */
    }
}
