package br.edu.infnet.investor.model.service;

import br.edu.infnet.investor.model.domain.Acao;
import br.edu.infnet.investor.model.domain.FundosImobiliario;
import br.edu.infnet.investor.model.domain.Investidor;
import br.edu.infnet.investor.model.domain.Portifolio;
import br.edu.infnet.investor.repositories.AcaoRepository;
import br.edu.infnet.investor.repositories.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AcoesService {
    @Autowired
    private AcaoRepository acaoRepository;

    public void incluir(Acao acao){
        acaoRepository.save(acao);
    }

    public Collection<Acao> obterLista(){
        return (Collection<Acao>) acaoRepository.findAll();
    }

    public Acao buscar(int id){
        return acaoRepository.findById(id).orElse(null);
    }

    public void excluir(int id){
        Acao acao = buscar(id);
        acaoRepository.delete(acao);
    }
}
