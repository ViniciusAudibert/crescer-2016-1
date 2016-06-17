package br.com.crescer.controllers;

import br.com.crescer.Pessoa;
import br.com.crescer.services.PessoaService;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vinicius.audibert
 */
@RestController
public class PessoaRest {
    @Autowired
    PessoaService service;

    @RequestMapping(value = "/current_date_time")
    public Date date() {
        return new Date();
    }

    @RequestMapping("/pessoa-obj")
    public List<Pessoa> list() {
        Pessoa p = new Pessoa();
        p.setNome("Vinicus audibert");
        p.setDataNascimento(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }

    @RequestMapping("/pessoa-list")
    public List<Pessoa> toList(){
        return this.service.list();
    }
    
    @ResponseBody
    @RequestMapping(value = "/pessoa.json", method = RequestMethod.POST)
    public List<Pessoa> list(@RequestBody Pessoa p) {
        p.setDataNascimento(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }
}
