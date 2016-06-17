package br.com.crescer.services;

import br.com.crescer.Pessoa;
import br.com.crescer.repositorios.PessoaRepositorio;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinicius.audibert
 */
@Service
public class PessoaService {

    @Autowired
    PessoaRepositorio pessoaaRep;
    
    public List<Pessoa> list() {
        Pessoa p = new Pessoa();
        p.setNome("Vinicius Audibert");
        p.setDataNascimento(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }
    
    public Iterable<Pessoa> toList(){
        return this.pessoaaRep.findAll();
    }

}
