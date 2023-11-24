package br.edu.infnet.investor.model.service;

import br.edu.infnet.investor.model.domain.Ativo;
import br.edu.infnet.investor.model.domain.Investidor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class InvestidorService {
    private Map<String, Investidor> mapa = new HashMap<>();

    public void incluir(Investidor investidor){
        mapa.put(investidor.getCpf(), investidor);
    }

    public Collection<Investidor> obterLista(){
        return mapa.values();
    }
}
