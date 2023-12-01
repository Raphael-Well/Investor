package br.edu.infnet.investor.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RendaFixa extends Ativo{

    private String tipo;
    private float rentabilidade;
    private String codigo;

}
