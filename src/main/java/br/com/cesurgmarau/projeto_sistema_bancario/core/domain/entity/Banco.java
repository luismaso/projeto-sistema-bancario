package br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity;

public class Banco {

    private Integer agencia = 0;
    private String nomeAgencia;

    public Banco() {
    }

    public Banco(Integer agencia, String nomeAgencia) {
        this.agencia = agencia;
        this.nomeAgencia = nomeAgencia;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }
}