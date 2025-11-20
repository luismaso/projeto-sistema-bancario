package br.com.cesurgmarau.projeto_sistema_bancario.infra.controller;


import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.ContaController;
import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.ContaUseCase;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.model.Error;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaControllerImpl implements ContaController {

    @Autowired
    ContaUseCase contaUseCase;

    @PostMapping
    @Override
    public ResponseEntity<Error> criarConta(@RequestBody Conta conta) {
        try {
            contaUseCase.criarConta(conta);
        } catch (Exception e) {
            Error erro = new Error();
            erro.setMessage(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(erro);
        }
        return null;
    }

    @DeleteMapping("/{idConta}")
    @Override
    public void deletarConta(@PathVariable Integer idConta) {
        contaUseCase.deletarConta(idConta);
    }

    @GetMapping
    @Override
    public List<Conta> listarConta() {
        return contaUseCase.listarConta();
    }

    @PutMapping("/{idConta}")
    @Override
    public void atualizarConta(@PathVariable Integer idConta, @RequestBody Conta novaConta) {
        contaUseCase.atualizarConta(idConta, novaConta);
    }
}
