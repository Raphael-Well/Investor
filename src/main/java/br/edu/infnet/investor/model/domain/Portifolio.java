package br.edu.infnet.investor.model.domain;

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

    @OneToMany()
    private List<Ativo> ativos;

    public Portifolio(String name, String descricao) {
        this.name = name;
        this.descricao = descricao;
    }

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
