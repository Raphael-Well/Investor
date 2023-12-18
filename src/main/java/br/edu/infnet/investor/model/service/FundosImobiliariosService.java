package br.edu.infnet.investor.model.service;

import br.edu.infnet.investor.model.domain.Acao;
import br.edu.infnet.investor.model.domain.FundosImobiliario;
import br.edu.infnet.investor.model.domain.RendaFixa;
import br.edu.infnet.investor.repositories.FundosImobiliarioRepository;
import br.edu.infnet.investor.repositories.RendaFixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FundosImobiliariosService {

    @Autowired
    private FundosImobiliarioRepository fundosImobiliarioRepository;

    public void incluir(FundosImobiliario fundosImobiliario){ fundosImobiliarioRepository.save(fundosImobiliario);
    }

    public Collection<FundosImobiliario> obterLista(){
        return (Collection<FundosImobiliario>) fundosImobiliarioRepository.findAll();
    }

    public FundosImobiliario buscar(int id){
        return fundosImobiliarioRepository.findById(id).orElse(null);
    }

    public void excluir(int id){
        FundosImobiliario fundosImobiliario = buscar(id);
        fundosImobiliarioRepository.delete(fundosImobiliario);
    }
}
