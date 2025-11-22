package br.com.cesurgmarau.projeto_sistema_bancario.infra.request;

public class ContaRequest {
    private String numeroConta;
    private int saldoInicial;
    private Integer agenciaBanco;
    private String cpfUsuario;

    public ContaRequest() {
    }

    public ContaRequest(String numeroConta, int saldoInicial, Integer agenciaBanco, String cpfUsuario) {
        this.numeroConta = numeroConta;
        this.saldoInicial = saldoInicial;
        this.agenciaBanco = agenciaBanco;
        this.cpfUsuario = cpfUsuario;
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
}
