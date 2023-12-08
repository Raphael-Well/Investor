package br.edu.infnet.investor.model.service;

import br.edu.infnet.investor.model.domain.Investidor;
import br.edu.infnet.investor.model.domain.Portifolio;
import br.edu.infnet.investor.model.domain.RendaFixa;
import br.edu.infnet.investor.repositories.InvestidorRepository;
import br.edu.infnet.investor.repositories.PortifolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PortifolioService {

    @Autowired
    private PortifolioRepository portifolioRepository;

    public void incluir(Portifolio portifolio){
        portifolioRepository.save(portifolio);
    }

    public Collection<Portifolio> obterLista(){
        return (Collection<Portifolio>) portifolioRepository.findAll();
    }

    public Portifolio buscar(int id){
        return portifolioRepository.findById(id).orElse(null);
    }
}
