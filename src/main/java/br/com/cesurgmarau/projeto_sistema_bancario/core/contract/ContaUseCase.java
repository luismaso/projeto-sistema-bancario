package br.com.cesurgmarau.projeto_sistema_bancario.core.contract;

import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Conta;

import java.util.List;

public interface ContaUseCase {
    void criarConta(String numeroConta, int saldoInicial, Integer agenciaBanco, String cpfUsuario) throws Exception;

    void deletarConta(Integer IdConta);

    List<Conta> listarConta();

    void atualizarConta(Integer idConta, Conta novaConta);
}
