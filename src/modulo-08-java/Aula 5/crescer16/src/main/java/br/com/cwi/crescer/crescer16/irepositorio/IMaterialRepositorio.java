package br.com.cwi.crescer.crescer16.irepositorio;

import br.com.cwi.crescer.crescer16.entity.Material;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public interface IMaterialRepositorio {

    void insert(Material material);

    int delete(int id);

    int update(Material material);

    List<Material> toList();
}
