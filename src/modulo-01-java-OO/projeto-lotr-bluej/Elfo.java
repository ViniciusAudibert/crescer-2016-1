public class Elfo extends Personagem {
    protected int flechas;
    private static int contadorDeElfos;
    
    public Elfo(String nome) {
        super(nome,100);
        this.flechas = 42;
        this.contadorDeElfos++;
    }
    
    public Elfo(String nome, int flechas){
        super(nome,100);
        this.flechas = flechas;
        this.contadorDeElfos++;
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        if(flechas > 0){
            experiencia++;
            flechas--;
            dwarf.receberFlecha();
        }
    }
    
    public int getFlechas(){
        return this.flechas;
    }
    
    public String toString(){
        boolean flechaNoSingular = Math.abs(this.flechas) == 1;
        boolean experienciaNoSingular = Math.abs(experiencia) == 1;
        return String.format("%s possui %d %s e %d %s de experiência.",
        getNome(),
        this.getFlechas(),
        flechaNoSingular ? "flecha" : "flechas",
        getExperiencia(),
        experienciaNoSingular ? "nível" : "níveis");
    }
    
    public static int getContadorDeElfos(){
        return contadorDeElfos;
    }
}