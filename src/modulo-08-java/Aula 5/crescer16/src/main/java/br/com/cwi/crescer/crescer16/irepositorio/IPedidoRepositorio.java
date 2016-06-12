package br.com.cwi.crescer.crescer16.irepositorio;

import br.com.cwi.crescer.crescer16.entity.Pedido;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public interface IPedidoRepositorio {

    void insert(Pedido pedido);

    int delete(int id);

    int update(Pedido pedido);

    List<Pedido> toList();
}
