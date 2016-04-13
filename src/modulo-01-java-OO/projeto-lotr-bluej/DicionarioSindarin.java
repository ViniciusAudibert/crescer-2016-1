import java.util.*;

public class DicionarioSindarin {
    public static void main(String[] args){
        HashMap<String, String> dicionarioSindarin = new HashMap<>();
        dicionarioSindarin.put("terra","amar");
        dicionarioSindarin.put("fogo","naur");
        dicionarioSindarin.put("vento","gwaew");
        dicionarioSindarin.put("água","nen");
        dicionarioSindarin.put("coração","gûr");
        
        String terraEmSindarin = dicionarioSindarin.get("terra");
        // Adicona Objeto
        dicionarioSindarin.put("água", "nîn");
        // Remove objeto
        dicionarioSindarin.remove("água");
        // Está vazio?
        boolean estaVazio = dicionarioSindarin.isEmpty();
        // Tamanho
        int tamanhoDoDicionario = dicionarioSindarin.size();
        // Contem chave?
        boolean contemAgua = dicionarioSindarin.containsKey("água");
        // Contem Valor?
        boolean contemNaur = dicionarioSindarin.containsValue("naur");
        // Adiciona valore com HashCode iguais
        dicionarioSindarin.put("FB", "Facebook");
        dicionarioSindarin.put("Ea","Eletronic Arts");    
        // Mostra todas os valores
        for(String chave : dicionarioSindarin.values()){
            System.out.println(chave);
        }
        System.out.println();
         // Mostra todas as chaves
        for(String chave : dicionarioSindarin.keySet()){
            System.out.println(chave);
        }
        // Mostra quantidade de valores naur
        int cont = 0;
        for(Map.Entry<String, String> chaveValor : dicionarioSindarin.entrySet()){
            if(chaveValor.getValue().equals("naur")){
                cont++;
            }
        }
        System.out.println("\nQuantidade de naur " + cont);
        
        
    }
}
