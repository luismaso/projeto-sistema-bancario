package br.com.cesurgmarau.projeto_sistema_bancario.infra.request;

public class CompraCreditoRequest {
    private String numeroConta;
    private int valor;


    public CompraCreditoRequest() {
    }

    public CompraCreditoRequest(String numeroConta, int valor) {
        this.numeroConta = numeroConta;
        this.valor = valor;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
