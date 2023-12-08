package br.edu.infnet.investor.model;

import br.edu.infnet.investor.model.domain.Acao;
import br.edu.infnet.investor.model.domain.FundosImobiliario;
import br.edu.infnet.investor.model.service.AcoesService;
import br.edu.infnet.investor.model.service.FundosImobiliariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class FundosImobiliarioLoader implements ApplicationRunner {

    @Autowired
    private FundosImobiliariosService fundosImobiliariosService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/fundos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            FundosImobiliario fundos = new FundosImobiliario();
            fundos.setEmpresa(campos[0]);
            fundos.setCodigo(campos[1]);
            fundos.setNome(campos[2]);
            fundos.setValor(Float.parseFloat(campos[3]));
            fundos.setQuantidade(Integer.parseInt(campos[4]));


            fundosImobiliariosService.incluir(fundos);

            linha = leitura.readLine();
        }

        for(FundosImobiliario fundo : fundosImobiliariosService.obterLista()) {
            System.out.println("[FUNDO IMOBILIARIO] " + fundo);
        }

        leitura.close();
    }
}
