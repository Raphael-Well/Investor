package br.edu.infnet.investor.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Portifolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String descricao;
    private LocalDateTime data;

    @ManyToOne
    private Investidor investidor;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "portifolio_ativo",
            joinColumns = @JoinColumn(name = "portifolio_id"),
            inverseJoinColumns = @JoinColumn(name = "ativo_id")
    )
    private List<Ativo> ativos;

    public Portifolio(String name, String descricao, Investidor investidor) {
        this.name = name;
        this.descricao = descricao;
        this.investidor = investidor;
    }

    public Portifolio() {

    }

    @Override
    public String toString() {
        return "Portifolio{" +
                "name='" + name + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", investidor=" + investidor +
                ", ativos=" + ativos +
                '}';
    }
}
