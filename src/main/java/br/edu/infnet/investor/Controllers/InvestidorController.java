package br.edu.infnet.investor.Controllers;

import br.edu.infnet.investor.model.domain.Investidor;
import br.edu.infnet.investor.model.service.InvestidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investidor")
public class InvestidorController {

    @Autowired
    private InvestidorService investidorService;

    @GetMapping(value = "/listar")
    public List<Investidor> obterLista(){
        return (List<Investidor>) investidorService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Investidor investidor) {
        investidorService.incluir(investidor);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        investidorService.excluir(id);
    }
}
