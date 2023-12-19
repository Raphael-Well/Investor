package br.edu.infnet.investor.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
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
    @JoinColumn(name = "idInvestidor")
    @JsonIgnore
    private Investidor investidor;

    @ManyToMany
    @JoinTable(
            name = "portifolio_ativo",
            joinColumns = @JoinColumn(name = "portifolio_id"),
            inverseJoinColumns = @JoinColumn(name = "ativo_id"))
    private List<Ativo> ativos;

    public Portifolio() {

    }

    @Override
    public String toString() {
        return "Portifolio{" +
                "name='" + name + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                '}';
    }
}
