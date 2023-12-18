package br.edu.infnet.investor.Controllers;

import br.edu.infnet.investor.model.domain.Acao;
import br.edu.infnet.investor.model.domain.RendaFixa;
import br.edu.infnet.investor.model.service.AcoesService;
import br.edu.infnet.investor.model.service.RendaFixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/renda")
public class RendaFixaController {

    @Autowired
    private RendaFixaService rendaFixaService;

    @GetMapping(value = "/listar")
    public List<RendaFixa> obterLista(){
        return (List<RendaFixa>) rendaFixaService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody RendaFixa rendaFixa) {
        rendaFixaService.incluir(rendaFixa);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        rendaFixaService.excluir(id);
    }
}
