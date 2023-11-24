package br.edu.infnet.investor.model;

import br.edu.infnet.investor.model.domain.Investidor;
import br.edu.infnet.investor.model.service.InvestidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class InvestidorLoader implements ApplicationRunner {

    @Autowired
    private InvestidorService investidorService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/investidores.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Investidor investidor = new Investidor(campos[0],campos[1], campos[2]);


            investidorService.incluir(investidor);

            linha = leitura.readLine();
        }

        for(Investidor investidor : investidorService.obterLista()) {
            System.out.println("[INVESTIDOR] " + investidor);
        }

        leitura.close();
    }
}
