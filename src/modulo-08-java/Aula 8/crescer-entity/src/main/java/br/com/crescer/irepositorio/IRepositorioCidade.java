package br.com.crescer.irepositorio;

import br.com.crescer.entity.Cidade;
import java.util.List;

/**
 *
 * @author vinicius.audibert
 */
public interface IRepositorioCidade {
    public long adicionar(Cidade cidade);
    public long remover(Cidade cidade);
    public long atualizar(Cidade cidade);
    public List<Cidade> toList();
    public Cidade buscar(Cidade cidade);
}
