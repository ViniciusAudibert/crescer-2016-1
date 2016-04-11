public class IrishDwarf extends Dwarf {
    public IrishDwarf(String nome){
        super(nome);
    }
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento){
        super(nome,dataNascimento);
    }
    
    public void tentarSorte(){
        if(getNumeroSorte() == -3333.0){
            for(int i=0; i<getAtributos().getInventario().getItens().size(); i++){
                int soma = 0;
                for(int j=1; j <= getAtributos().getInventario().getItens().get(i).getQuantidade(); j++){
                    soma += j;
                }
                int quantidade = getAtributos().getInventario().getItens().get(i).getQuantidade();
                getAtributos().getInventario().getItens().get(i).setQuantidade((1000 * soma) + quantidade);
            }
        }
    }
}