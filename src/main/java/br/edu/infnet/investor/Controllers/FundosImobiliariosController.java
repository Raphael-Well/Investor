package br.edu.infnet.investor.Controllers;

import br.edu.infnet.investor.model.domain.FundosImobiliario;
import br.edu.infnet.investor.model.domain.Portifolio;
import br.edu.infnet.investor.model.service.FundosImobiliariosService;
import br.edu.infnet.investor.model.service.PortifolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fundos")
public class FundosImobiliariosController {

    @Autowired
    private FundosImobiliariosService fundosImobiliariosService;

    @GetMapping(value = "/listar")
    public List<FundosImobiliario> obterLista(){
        return (List<FundosImobiliario>) fundosImobiliariosService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody FundosImobiliario fundosImobiliario) {
        fundosImobiliariosService.incluir(fundosImobiliario);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        fundosImobiliariosService.excluir(id);
    }
}
