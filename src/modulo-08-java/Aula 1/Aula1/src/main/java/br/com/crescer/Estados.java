package br.com.crescer;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vinicius.audibert
 */
public enum Estados {
    AC("Acre"), AL("Alagoas"), ES("EspíritoSanto"), AP("Amapá"),
    BA("Bahia"), CE("Ceará"), DF("DistritoFederal"), GO("Goiás"),
    MA("Maranhão"), SC("SantaCatarina"), MG("MinasGerais"),
    MT("MatoGrosso"), MS("MatoGrossodoSul"), PA("Pará"),
    RS("RioGrandedoSul"), PE("Pernambuco"), PI("Piauí"),
    AM("Amazonas"), PR("Paraná"), RJ("RiodeJaneiro"),
    RN("RioGrandedoNorte"), PB("Paraíba"), RO("Rondônia"),
    RR("Roraima"), SE("Sergipe"), SP("SãoPaulo"), TO("Tocantins");

    private String nome;

    private Estados(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String toString(){
        StringBuffer palavra = new StringBuffer();
        String lastEstado = "";
        
        for (Estados estado : Estados.values()) {
            
            if(estado.getNome().compareTo(lastEstado) > 0)
                palavra.append(estado.getNome()).append(", ");
            else
                palavra.insert(0, estado.getNome()).append(", ");
            lastEstado = estado.getNome();
        }
        
        return palavra.substring(0, palavra.length() - 2);
    }
    
    public static void main(String[] args) {
        List<Estados> sortList = Arrays.asList(Estados.values());
        sortList.sort((Estados e1, Estados e2) -> e1.getNome().compareTo(e2.getNome()));
        
        StringBuffer palavra = new StringBuffer();

        for (Estados estado : sortList) {
            palavra.append(estado.getNome()).append(", ");
        }

        palavra = palavra.delete(palavra.length() - 2, palavra.length());
        System.out.println(palavra);
    }

}