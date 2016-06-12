package br.com.cwi.crescer.crescer16.irepositorio;

import br.com.cwi.crescer.crescer16.entity.Cliente;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public interface IClienteRepositorio {

    void insert(Cliente cliente);

    int delete(int id);

    int update(Cliente cliente);

    List<Cliente> toList();
}
