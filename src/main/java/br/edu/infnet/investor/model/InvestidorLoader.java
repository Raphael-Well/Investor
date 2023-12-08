package br.edu.infnet.investor.model;

import br.edu.infnet.investor.model.domain.Ativo;
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
import java.util.ArrayList;
import java.util.List;

@Order(5)
@Component
public class InvestidorLoader implements ApplicationRunner {

    @Autowired
    private InvestidorService investidorService;

    @Autowired
    private PortifolioService portifolioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/investidores.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        boolean isFirstInvestor = true;
        List<Portifolio> portifolios = new ArrayList<>();
        portifolios.add(portifolioService.buscar(1));

        while(linha != null) {
            campos = linha.split(";");

            Investidor investidor = new Investidor(campos[0],campos[1], campos[2]);

            if (isFirstInvestor) {
                investidor.setPortifolios(portifolios);
                isFirstInvestor = false;
            }

            investidorService.incluir(investidor);

            linha = leitura.readLine();
        }

        for(Investidor investidor : investidorService.obterLista()) {
            System.out.println("[INVESTIDOR] " + investidor);
        }

        leitura.close();
    }
}
