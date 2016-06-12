package br.com.cwi.crescer.crescer16.irepositorio;

import br.com.cwi.crescer.crescer16.entity.Produto;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public interface IProdutoRepositorio {

    void insert(Produto produto);

    int delete(int id);

    int update(Produto produto);

    List<Produto> toList();
}
