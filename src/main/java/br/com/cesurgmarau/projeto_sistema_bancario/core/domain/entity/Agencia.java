package br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity;

public class Agencia {
    private Integer idAgencia;
    private String agencia;

    public Agencia(Integer idAgencia, String agencia) {
        this.idAgencia = idAgencia;
        this.agencia = agencia;
    }

    public Integer getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
}
