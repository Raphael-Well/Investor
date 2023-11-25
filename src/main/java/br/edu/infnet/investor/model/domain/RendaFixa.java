package br.edu.infnet.investor.model.domain;

public class RendaFixa extends Ativo{

    private String tipo;
    private float rentabilidade;
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getRentabilidade() {
        return rentabilidade;
    }

    public void setRentabilidade(float rentabilidade) {
        this.rentabilidade = rentabilidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
