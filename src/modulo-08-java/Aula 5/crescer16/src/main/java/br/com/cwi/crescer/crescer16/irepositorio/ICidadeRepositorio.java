package br.com.cwi.crescer.crescer16.irepositorio;

import br.com.cwi.crescer.crescer16.entity.Cidade;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public interface ICidadeRepositorio {

    void insert(Cidade cidade);

    int delete(int id);

    int update(Cidade cidade);

    List<Cidade> toList();
}
