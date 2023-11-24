package br.edu.infnet.investor.model.service;

import br.edu.infnet.investor.model.domain.Portifolio;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PortifolioService {

    private Map<String, Portifolio> mapa = new HashMap<String, Portifolio>();

    public void incluir(Portifolio portifolio){
        mapa.put(portifolio.getName(), portifolio);
    }

    public Collection<Portifolio> obterLista(){
        return mapa.values();
    }
}
