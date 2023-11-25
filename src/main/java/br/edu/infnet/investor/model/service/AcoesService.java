package br.edu.infnet.investor.model.service;

import br.edu.infnet.investor.model.domain.Acao;
import br.edu.infnet.investor.model.domain.FundosImobiliario;
import br.edu.infnet.investor.model.domain.Investidor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AcoesService {
    private Map<String, Acao> mapa = new HashMap<>();

    public void incluir(Acao acao){
        mapa.put(acao.getCodigo(), acao);
    }

    public Collection<Acao> obterLista(){
        return mapa.values();
    }
}
