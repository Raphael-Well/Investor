package br.edu.infnet.investor.model.service;

import br.edu.infnet.investor.model.domain.Acao;
import br.edu.infnet.investor.model.domain.FundosImobiliario;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FundosImobiliariosService {
    private Map<String, FundosImobiliario> mapa = new HashMap<>();

    public void incluir(FundosImobiliario fundo){
        mapa.put(fundo.getCodigo(), fundo);
    }

    public Collection<FundosImobiliario> obterLista(){
        return mapa.values();
    }
}
