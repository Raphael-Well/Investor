package br.edu.infnet.investor.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Override
    public String toString() {
        return "Ativo{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}
