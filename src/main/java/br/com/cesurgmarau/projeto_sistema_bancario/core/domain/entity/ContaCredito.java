package br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity;

public class ContaCredito extends Conta{
    private int limiteCredito;

    public ContaCredito(){
        super();
        this.setTipoConta("Crédito");
    }

    public ContaCredito(Integer idConta, int saldoConta, String numeroConta, Banco banco, Usuario usuario, int limiteCredito) {
        super(idConta, saldoConta, numeroConta, "Crédito", banco, usuario);
        this.limiteCredito = limiteCredito;
    }

    public int getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(int limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
}
