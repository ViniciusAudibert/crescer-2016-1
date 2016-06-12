package br.com.cwi.crescer.crescer16.irepositorio;

import br.com.cwi.crescer.crescer16.entity.ProdutoMaterial;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public interface IProdutoMaterialRepositorio {

    void insert(ProdutoMaterial produtoMaterial);

    int delete(int id);

    int update(ProdutoMaterial produtoMaterial);

    List<ProdutoMaterial> toList();
}
