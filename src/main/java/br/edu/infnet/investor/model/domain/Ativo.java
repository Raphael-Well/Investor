package br.edu.infnet.investor.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Ativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private float valor;
    private int quantidade;

    @ManyToMany(mappedBy = "ativos")
    @JsonIgnore
    private List<Portifolio> portifolios;

    @Override
    public String toString() {
        return "Ativo{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}
