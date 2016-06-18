package br.com.crescer.repositorios;

import br.com.crescer.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vinicius.audibert
 */
public interface PessoaRepositorio extends CrudRepository<Pessoa, Long>  {
    
}
