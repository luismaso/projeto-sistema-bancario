package br.com.cesurgmarau.projeto_sistema_bancario.infra.request;

public class ContaRequest {
    private String numeroConta;
    private int saldoInicial;
    private Integer agenciaBanco;
    private String cpfUsuario;
    private String tipoConta;
    private Integer limiteCredito;

    public ContaRequest() {
    }

    public ContaRequest(String numeroConta, int saldoInicial, Integer agenciaBanco, String cpfUsuario, String tipoConta) {
        this.numeroConta = numeroConta;
        this.saldoInicial = saldoInicial;
        this.agenciaBanco = agenciaBanco;
        this.cpfUsuario = cpfUsuario;
        this.tipoConta = tipoConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(int saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Integer getAgenciaBanco() {
        return agenciaBanco;
    }

    public void setAgenciaBanco(Integer agenciaBanco) {
        this.agenciaBanco = agenciaBanco;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public Integer getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Integer limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
}
