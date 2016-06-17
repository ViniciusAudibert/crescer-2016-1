package br.com.crescer.servico;

import br.com.crescer.entity.Cidade;
import br.com.crescer.irepositorio.IRepositorioCidade;

/**
 *
 * @author vinicius.audibert
 */
public class CidadeServico {
    
    private IRepositorioCidade repositorio;
    
    public CidadeServico(IRepositorioCidade repositorio){
        this.repositorio = repositorio;
    }
    
    public long adicionar(Cidade cidade){
        return this.repositorio.adicionar(cidade);
    }
    
    public long remover(Cidade cidade){
        return this.repositorio.remover(cidade);
    }
}
