package br.edu.infnet.investor.model;

import br.edu.infnet.investor.model.domain.Investidor;
import br.edu.infnet.investor.model.domain.Portifolio;
import br.edu.infnet.investor.model.service.InvestidorService;
import br.edu.infnet.investor.model.service.PortifolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class PortifolioLoader implements ApplicationRunner {

    @Autowired
    private PortifolioService portifolioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/portifolios.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Investidor investidor = new Investidor(campos[2],campos[3], campos[4]);
            Portifolio portifolio = new Portifolio(campos[0],campos[1], investidor);


            portifolioService.incluir(portifolio);

            linha = leitura.readLine();
        }

        for(Portifolio portifolio : portifolioService.obterLista()) {
            System.out.println("[PORTIFOLIO] " + portifolio);
        }

        leitura.close();
    }
}
