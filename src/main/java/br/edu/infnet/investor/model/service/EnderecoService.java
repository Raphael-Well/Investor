package br.edu.infnet.investor.model.service;

import br.edu.infnet.investor.clients.IEnderecoClient;
import br.edu.infnet.investor.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private IEnderecoClient enderecoClient;

    public Endereco buscarCep(String cep) {
        return enderecoClient.buscarCep(cep);
    }

}
