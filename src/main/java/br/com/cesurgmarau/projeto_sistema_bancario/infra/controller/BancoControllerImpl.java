package br.com.cesurgmarau.projeto_sistema_bancario.infra.controller;


import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.BancoController;
import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.BancoUseCase;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Banco;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.model.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco")
public class BancoControllerImpl implements BancoController {

    @Autowired
    BancoUseCase bancoUseCase;

    @PostMapping
    @Override
    public ResponseEntity<Error> criarBanco(@RequestBody Banco banco) {
        try{
            bancoUseCase.criarBanco(banco);
        }catch (Exception e){
            Error erro = new Error();
            erro.setMessage(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(erro);
        }
        return null;
    }

    @DeleteMapping("/{agencia}")
    @Override
    public void deletarBanco(@PathVariable Integer agencia) {
        bancoUseCase.deletarBanco(agencia);
    }

    @PutMapping("/{agencia}")
    @Override
    public void atualizarBanco(@PathVariable Integer agencia, @RequestBody Banco novoBanco) {
        bancoUseCase.atualizarBanco(agencia, novoBanco);
    }

    @GetMapping
    @Override
    public List<Banco> listarBancos() {
        return bancoUseCase.listarBancos();
    }
}
