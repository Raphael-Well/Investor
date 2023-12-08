package br.edu.infnet.investor.model;

import br.edu.infnet.investor.model.domain.Acao;
import br.edu.infnet.investor.model.domain.RendaFixa;
import br.edu.infnet.investor.model.service.AcoesService;
import br.edu.infnet.investor.model.service.RendaFixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(2)
@Component
public class RendaFixaLoader implements ApplicationRunner {

    @Autowired
    private RendaFixaService rendaFixaService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/renda.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            RendaFixa renda = new RendaFixa();
            renda.setCodigo(campos[0]);
            renda.setTipo(campos[1]);
            renda.setRentabilidade(Float.parseFloat(campos[2]));
            renda.setNome(campos[3]);
            renda.setValor(Float.parseFloat(campos[4]));

            rendaFixaService.incluir(renda);

            linha = leitura.readLine();
        }

        for(RendaFixa rendaFixa : rendaFixaService.obterLista()) {
            System.out.println("[Renda Fixa] " + rendaFixa);
        }

        leitura.close();
    }
}
