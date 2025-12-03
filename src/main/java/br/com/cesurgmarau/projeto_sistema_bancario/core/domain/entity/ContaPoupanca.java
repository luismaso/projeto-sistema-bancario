package br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity;

public class ContaPoupanca extends Conta {
    private double taxaRendimento = 0.005;
    private boolean rendimentoAplicado = false;

    public ContaPoupanca(){
        super();
        this.setTipoConta("Poupança");
    }

    public ContaPoupanca(double taxaRendimento, boolean rendimentoAplicado) {
        this.taxaRendimento = taxaRendimento;
        this.rendimentoAplicado = rendimentoAplicado;
    }

    public ContaPoupanca(Integer idConta, int saldoConta, String numeroConta, String tipoConta, Banco banco, Usuario usuario, double taxaRendimento, boolean rendimentoAplicado) {
        super(idConta, saldoConta, numeroConta, tipoConta, banco, usuario);
        this.taxaRendimento = taxaRendimento;
        this.rendimentoAplicado = rendimentoAplicado;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public void aplicarRendimento(){
        int novoSaldo = (int) (this.getSaldoConta() * (1 + this.taxaRendimento));
        this.setSaldoConta(novoSaldo);
    }

    public boolean isRendimentoAplicado() {
        return rendimentoAplicado;
    }

    public void setRendimentoAplicado(boolean rendimentoAplicado) {
        this.rendimentoAplicado = rendimentoAplicado;
    }
}
