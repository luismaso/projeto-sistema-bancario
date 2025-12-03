package br.com.cesurgmarau.projeto_sistema_bancario.core.contract;

import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Conta;

import java.util.List;

public interface ContaUseCase {
    Conta criarConta(String numeroConta, int saldoInicial, String tipoConta, Integer agenciaBanco, String cpfUsuario, Integer limiteCredito) throws Exception;

    void deletarConta(Integer IdConta);

    List<Conta> listarConta();

    void atualizarConta(Integer idConta, Conta novaConta);

    void depositar(String numeroConta, int valor) throws Exception;

    void transferir(String contaOrigem, String contaDestino, int valorTransferencia) throws Exception;

    void aplicarRendimento(String numeroConta) throws Exception;

    void compraCredito(String numeroConta, int valor) throws Exception;
}
