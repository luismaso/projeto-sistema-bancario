package br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity;

public class Conta {
    private Integer idConta = 0;
    private Integer saldoConta = 0;
    private String numeroConta;

    public Conta(Integer idConta, Integer saldoConta, String numeroConta) {
        this.idConta = idConta;
        this.saldoConta = saldoConta;
        this.numeroConta = numeroConta;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public Integer getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(Integer saldoConta) {
        this.saldoConta = saldoConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

}
