import java.util.*;
public class SindarinParaIngles implements TradutorSindarin {
    private HashMap<String,String> dicionario = new HashMap<String,String>() {
        {
            put("naur","fire");
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
