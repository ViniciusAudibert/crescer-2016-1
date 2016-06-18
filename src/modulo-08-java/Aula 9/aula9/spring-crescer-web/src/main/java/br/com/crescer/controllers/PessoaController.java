package br.com.crescer.controllers;

import br.com.crescer.entity.Pessoa;
import br.com.crescer.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vinicius.audibert
 */
@Controller
public class PessoaController {

    @Autowired
    PessoaService service;

    @RequestMapping(value = "/cadastro-pessoa")
    String toCadastro(Model model) {
        return "cadastro-pessoa";
    }
    @RequestMapping(value = "/consulta-pessoa")
    String toConsulta(Model model) {
        String f = null;
        Iterable<Pessoa> pessoass = service.toList();
        model.addAttribute("pessoas", service.toList());
        return "consulta-pessoa";
    }
}
