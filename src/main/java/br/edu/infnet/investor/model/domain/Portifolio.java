package br.edu.infnet.investor.model.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Portifolio {

    private String name;
    private String descricao;
    private LocalDateTime data;
    private Investidor investidor;
    private List<Ativo> ativos;

    public Portifolio(String name, String descricao, Investidor investidor) {
        this.name = name;
        this.descricao = descricao;
        this.investidor = investidor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public List<Ativo> getAtivos() {
        return ativos;
    }

    public void setAtivos(List<Ativo> ativos) {
        this.ativos = ativos;
    }
}
