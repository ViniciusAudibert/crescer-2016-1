package br.com.crescer.repositorios;

import br.com.crescer.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author vinicius.audibert
 */
public interface PessoaRepositorio extends PagingAndSortingRepository<Pessoa, Long>  {
    
}
