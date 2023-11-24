package br.edu.infnet.investor.model.domain;

public class FundosImobiliarios extends Ativo{
    private String Empresa;
    private String codigo;

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String empresa) {
        Empresa = empresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
