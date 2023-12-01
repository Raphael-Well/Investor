package br.edu.infnet.investor.model.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FundosImobiliario extends Ativo{
    private String Empresa;
    private String codigo;

}
