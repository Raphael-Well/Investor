package br.edu.infnet.investor.model.service;

import br.edu.infnet.investor.model.domain.*;
import br.edu.infnet.investor.repositories.PortifolioRepository;
import br.edu.infnet.investor.repositories.RendaFixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RendaFixaService {

    @Autowired
    private RendaFixaRepository rendaFixaRepository;

    public void incluir(RendaFixa renda){ rendaFixaRepository.save(renda);
    }

    public Collection<RendaFixa> obterLista(){
        return (Collection<RendaFixa>) rendaFixaRepository.findAll();
    }

    public RendaFixa buscar(int id){
        return rendaFixaRepository.findById(id).orElse(null);
    }

    public void excluir(int id){
        RendaFixa rendaFixa = buscar(id);
        rendaFixaRepository.delete(rendaFixa);
    }
}
