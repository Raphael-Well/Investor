package br.edu.infnet.investor.model;

import br.edu.infnet.investor.model.domain.Ativo;
import br.edu.infnet.investor.model.domain.Investidor;
import br.edu.infnet.investor.model.domain.Portifolio;
import br.edu.infnet.investor.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Order(4)
@Component
public class PortifolioLoader implements ApplicationRunner {

    @Autowired
    private PortifolioService portifolioService;

    @Autowired
    private AtivoService ativoService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/portifolios.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        List<Ativo> ativos = (List<Ativo>) ativoService.obterLista();

        while(linha != null) {
            campos = linha.split(";");

            Portifolio portifolio = new Portifolio(campos[0],campos[1]);
            portifolio.setAtivos(ativos);
            portifolio.setData(LocalDateTime.now());
            portifolioService.incluir(portifolio);

            linha = leitura.readLine();
        }

        for(Portifolio portifolio : portifolioService.obterLista()) {
            System.out.println("[PORTIFOLIO] " + portifolio);
        }

        leitura.close();
    }
}
