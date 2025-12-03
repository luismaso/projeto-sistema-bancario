package br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity;

public class Conta {
    private Integer idConta = 0;
    private int saldoConta = 0;
    private String numeroConta;
    private String tipoConta;

    //novos
    private Banco banco;
    private Usuario usuario;

    public Conta() {
        this.setTipoConta("Corrente");
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Conta(Integer idConta, int saldoConta, String numeroConta, String tipoConta, Banco banco, Usuario usuario) {
        this.idConta = idConta;
        this.saldoConta = saldoConta;
        this.numeroConta = numeroConta;
        this.tipoConta = "Corrente";
        this.banco = banco;
        this.usuario = usuario;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public void setSaldoConta(int saldoConta) {
        this.saldoConta = saldoConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }


}
