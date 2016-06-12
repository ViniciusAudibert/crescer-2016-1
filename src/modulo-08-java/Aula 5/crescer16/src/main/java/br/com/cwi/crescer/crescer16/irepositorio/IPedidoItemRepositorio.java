package br.com.cwi.crescer.crescer16.irepositorio;

import br.com.cwi.crescer.crescer16.entity.PedidoItem;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public interface IPedidoItemRepositorio {
    
    void insert(PedidoItem pedidoItem);

    int delete(int id);

    int update(PedidoItem pedidoItem);

    List<PedidoItem> toList();
}
