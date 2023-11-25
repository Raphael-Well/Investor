package br.edu.infnet.investor.model;

import br.edu.infnet.investor.model.domain.Acao;
import br.edu.infnet.investor.model.domain.Investidor;
import br.edu.infnet.investor.model.service.AcoesService;
import br.edu.infnet.investor.model.service.PortifolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(2)
@Component
public class AcaoLoader implements ApplicationRunner {

    @Autowired
    private AcoesService acoesService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/acoes.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Acao acao = new Acao();
            acao.setEmpresa(campos[0]);
            acao.setCodigo(campos[1]);
            acao.setNome(campos[2]);
            acao.setValor(Float.parseFloat(campos[3]));


            acoesService.incluir(acao);

            linha = leitura.readLine();
        }

        for(Acao acao : acoesService.obterLista()) {
            System.out.println("[AÇÃO] " + acao);
        }

        leitura.close();
    }
}
