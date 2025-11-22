package br.com.cesurgmarau.projeto_sistema_bancario.core.contract;

import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Conta;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.model.Error;
import br.com.cesurgmarau.projeto_sistema_bancario.infra.request.ContaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ContaController {


    @PostMapping
    ResponseEntity<?> criarConta(@RequestBody ContaRequest request);

    void deletarConta(Integer IdConta);

    List<Conta> listarConta();

    void atualizarConta(Integer idConta, Conta novaConta);
}
