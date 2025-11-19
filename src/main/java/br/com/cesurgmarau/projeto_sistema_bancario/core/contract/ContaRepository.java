package br.com.cesurgmarau.projeto_sistema_bancario.core.contract;

import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Conta;

import java.util.List;

public interface ContaRepository {
    void criarConta(Conta conta) throws Exception;

    void deletarConta(Integer IdConta);

    List<Conta> listarConta();

    void atualizarConta(Integer idConta, Conta novaConta);
}
