public class Elfo {
    private int flechas;
    protected Atributos atributos;
    
    public Elfo(String nome) {
        this.atributos = new Atributos(nome,100);
        this.flechas = 42;
    }
    
    public Elfo(String nome, int flechas){
        this(nome);
        this.flechas = flechas;
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        if(this.flechas > 0){
            atributos.experiencia++;
            flechas--;
            dwarf.receberFlecha();
        }
    }
    
    public int getFlechas(){
        return this.flechas;
    }
    
    public String toString(){
        boolean flechaNoSingular = Math.abs(this.flechas) == 1;
        boolean experienciaNoSingular = Math.abs(atributos.experiencia) == 1;
        return String.format("%s possui %d %s e %d %s de experiência.",
        atributos.getNome(),
        this.getFlechas(),
        flechaNoSingular ? "flecha" : "flechas",
        atributos.getExperiencia(),
        experienciaNoSingular ? "nível" : "níveis");
    }
    
    public Atributos getAtributos(){
        return this.atributos;
    }
}