package br.edu.infnet.investor.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Investidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String cpf;

    @OneToMany(mappedBy = "investidor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Portifolio> portifolios;

    public Investidor(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public Investidor() {

    }


    @Override
    public String toString() {
        return "Investidor{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
