package br.com.crescer.controllers;

import br.com.crescer.entity.Pessoa;
import br.com.crescer.services.PessoaService;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author vinicius.audibert
 */
@Controller
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    PessoaService service;

    @RequestMapping(value = "" ,method = RequestMethod.GET)
    public String toConsulta(Model model, Pageable pageable) {
        model.addAttribute("pessoas", service.toList(pageable));
        model.addAttribute("totalPages", 3);
        return "consulta-pessoa";
    }
    
    @RequestMapping(value = "/cadastro-pessoa", method = RequestMethod.GET)
    public String toCadastro(Model model) {
        model.addAttribute("p", new Pessoa(Long.valueOf(0),"",BigInteger.valueOf(0),new Date()));
        return "cadastro-pessoa";
    }
    
    @RequestMapping(value = "/{id}/editar-pessoa", method = RequestMethod.GET)
    public String toEditar(@PathVariable(value = "id") Long id, Model model) {
        Pessoa p = service.findById(Long.valueOf(id));
        model.addAttribute("p", p);
        return "cadastro-pessoa";
    }
    
    @RequestMapping(value = "/{id}/deletar-pessoa", method = RequestMethod.GET)
    public ModelAndView toDeletar(@PathVariable(value = "id") Long id, Model model) {
        service.delete(id);
        return new ModelAndView("redirect:/pessoa");
    }
    
    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ModelAndView salvar(@ModelAttribute Pessoa p, @RequestParam("id") Long id, Model model, @RequestParam("data") String data) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            p.setDataNascimento(format.parse(data));
        } catch (ParseException ex) {
            System.err.println("Data Error");
        }
        if(id == null)
            p.setIdpessoa(Long.valueOf(0));
        else
            p.setIdpessoa(id);
        service.save(p);
        return new ModelAndView("redirect:/pessoa");
    }
}
