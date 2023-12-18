package br.edu.infnet.investor.model.service;

import br.edu.infnet.investor.model.domain.Endereco;
import br.edu.infnet.investor.model.domain.Investidor;
import br.edu.infnet.investor.repositories.InvestidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class InvestidorService {

    @Autowired
    private InvestidorRepository investidorRepository;
    @Autowired
    private EnderecoService enderecoService;

    public void incluir(Investidor investidor){
        String cep = investidor.getEndereco().getCep();

        Endereco endereco = enderecoService.buscarCep(cep);

        investidor.setEndereco(endereco);
        investidorRepository.save(investidor);
    }

    public Collection<Investidor> obterLista(){
        return (Collection<Investidor>) investidorRepository.findAll();
    }

    public Investidor buscar(int id){
        return investidorRepository.findById(id).orElse(null);
    }

    public void excluir(int id){
        Investidor investidor = buscar(id);
        investidorRepository.delete(investidor);
    }
}
