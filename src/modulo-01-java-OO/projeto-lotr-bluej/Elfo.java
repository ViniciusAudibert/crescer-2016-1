public class Elfo extends Atributos {
    private int flechas = 42;
    
    public Elfo(String nome) {
        super(nome);
    }
    
    public Elfo(String nome, int flechas){
        this(nome);
        this.flechas = flechas;
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        experiencia++;
        flechas--;
        dwarf.receberFlecha();
    }
    
    public int getFlechas(){
        return this.flechas;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public String toString(){
        boolean flechaNoSingular = Math.abs(this.flechas) == 1;
        boolean experienciaNoSingular = Math.abs(this.experiencia) == 1;
        return String.format("%s possui %d %s e %d %s de experiência.",
        getNome(),
        getFlechas(),
        flechaNoSingular ? "flecha" : "flechas",
        getExperiencia(),
        experienciaNoSingular ? "nível" : "níveis");
    }
}