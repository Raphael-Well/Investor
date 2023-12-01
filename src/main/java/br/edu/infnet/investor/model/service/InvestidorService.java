package br.edu.infnet.investor.model.service;

import br.edu.infnet.investor.model.domain.Ativo;
import br.edu.infnet.investor.model.domain.Investidor;
import br.edu.infnet.investor.repositories.InvestidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class InvestidorService {

    @Autowired
    private InvestidorRepository investidorRepository;

    public void incluir(Investidor investidor){
        investidorRepository.save(investidor);
    }

    public Collection<Investidor> obterLista(){
        return (Collection<Investidor>) investidorRepository.findAll();
    }
}
