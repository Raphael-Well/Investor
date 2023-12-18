package br.edu.infnet.investor.Controllers;

import br.edu.infnet.investor.model.domain.Investidor;
import br.edu.infnet.investor.model.domain.Portifolio;
import br.edu.infnet.investor.model.service.InvestidorService;
import br.edu.infnet.investor.model.service.PortifolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portifolio")
public class PortifolioController {

    @Autowired
    private PortifolioService portifolioService;

    @GetMapping(value = "/listar")
    public List<Portifolio> obterLista(){
        return (List<Portifolio>) portifolioService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Portifolio portifolio) {
        portifolioService.incluir(portifolio);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        portifolioService.excluir(id);
    }
}
