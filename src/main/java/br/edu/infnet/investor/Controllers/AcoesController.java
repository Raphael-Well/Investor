package br.edu.infnet.investor.Controllers;

import br.edu.infnet.investor.model.domain.Acao;
import br.edu.infnet.investor.model.domain.Portifolio;
import br.edu.infnet.investor.model.service.AcoesService;
import br.edu.infnet.investor.model.service.PortifolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acoes")
public class AcoesController {

    @Autowired
    private AcoesService acoesService;

    @GetMapping(value = "/listar")
    public List<Acao> obterLista(){
        return (List<Acao>) acoesService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Acao acao) {
        acoesService.incluir(acao);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        acoesService.excluir(id);
    }
}
