package br.com.cesurgmarau.projeto_sistema_bancario.infra.request;

public class TransferenciaRequest {
    private String contaOrigem;
    private String contaDestino;
    private int valorTransferencia;

    public TransferenciaRequest() {
    }

    public TransferenciaRequest(String contaOrigem, String contaDestino, int valorTransferencia) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valorTransferencia = valorTransferencia;
    }

    public String getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public int getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(int valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }
}
