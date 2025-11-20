package br.com.cesurgmarau.projeto_sistema_bancario.core.contract;

import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Conta;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.model.Error;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContaRepository {
    ResponseEntity<Error> criarConta(Conta conta) throws Exception;

    void deletarConta(Integer IdConta);

    List<Conta> listarConta();

    void atualizarConta(Integer idConta, Conta novaConta);
}
