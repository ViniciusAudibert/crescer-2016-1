import java.util.*;
public class SindarinParaPortugues implements TradutorSindarin {
    private HashMap<String,String> dicionario = new HashMap<String,String>() {
        {
            put("naur","fogo");
        }
    };
    
    @Override
    public String traduzir(String palavraEmSindarin){
        return dicionario.get(palavraEmSindarin);
    }
    
    public void limpar(){
        dicionario.clear();
    }
}
