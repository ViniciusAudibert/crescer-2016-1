public class IrishDwarf extends Dwarf {
    public IrishDwarf(String nome){
        super(nome);
    }
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento){
        super(nome,dataNascimento);
    }
    
    public void tentarSorte(){
        if(getNumeroSorte() == -3333.0){
            for(int i=0; i< getInventario().getItens().size(); i++){
                int soma = 0;
                for(int j=1; j <= getInventario().getItens().get(i).getQuantidade(); j++){
                    soma += j;
                }
                int quantidade = getInventario().getItens().get(i).getQuantidade();
                getInventario().getItens().get(i).setQuantidade((1000 * soma) + quantidade);
            }
        }
    }
}