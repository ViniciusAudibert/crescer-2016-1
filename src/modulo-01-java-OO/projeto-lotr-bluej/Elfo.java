public class Elfo {
    private String nome;
    private int experiencia, flechas = 42;
    
    public Elfo(String nome) {
        this.nome = nome;
        this.experiencia = 0;
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
    
    public String getNome(){
        return this.nome;
    }
    
    public String toString(){
        boolean flechaNoSingular = Math.abs(this.flechas) == 1;
        boolean experienciaNoSingular = Math.abs(this.experiencia) == 1;
        return String.format("%s possui %d %s e %d %s de experiência.",
        this.nome,
        this.flechas,
        flechaNoSingular ? "flecha" : "flechas",
        this.experiencia,
        experienciaNoSingular ? "nível" : "níveis");
        /* return getNome() + " possui "+ getFlechas() + " flechas e "
        + getExperiencia() + " níveis de experiência."; */
    }
}