package br.edu.infnet.investor.model.service;

import br.edu.infnet.investor.model.domain.FundosImobiliario;
import br.edu.infnet.investor.model.domain.RendaFixa;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RendaFixaService {
    private Map<String, RendaFixa> mapa = new HashMap<>();

    public void incluir(RendaFixa renda){ mapa.put(renda.getCodigo(), renda);
    }

    public Collection<RendaFixa> obterLista(){
        return mapa.values();
    }
}
