package br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity;

public class ContaPoupanca extends Conta {
    private double taxaRendimento = 0.005;

    public ContaPoupanca(){
        super();
        this.setTipoConta("Poupança");
    }

    ContaPoupanca(Integer idConta, int saldoConta, String numeroConta, Banco banco, Usuario usuario) {
        super(idConta, saldoConta, numeroConta, "Poupança", banco, usuario);
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
}
