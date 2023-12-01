package br.edu.infnet.investor.model.service;

import br.edu.infnet.investor.model.domain.Ativo;
import br.edu.infnet.investor.model.domain.FundosImobiliario;
import br.edu.infnet.investor.repositories.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AtivoService {

    @Autowired
    private AtivoRepository ativoRepository;

    public void incluir(Ativo ativo){
        ativoRepository.save(ativo);
    }

    public Collection<Ativo> obterLista() {
        return (Collection<Ativo>) ativoRepository.findAll();
    }
}
