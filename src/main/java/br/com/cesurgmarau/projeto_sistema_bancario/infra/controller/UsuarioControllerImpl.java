package br.com.cesurgmarau.projeto_sistema_bancario.infra.controller;

import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.UsuarioController;
import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.UsuarioUseCase;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Usuario;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.model.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    UsuarioUseCase usuarioUseCase;

    @PostMapping
    @Override
    public ResponseEntity<Error> criarUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioUseCase.criarUsuario(usuario);
        } catch (Exception e) {
            Error erro = new Error();
            erro.setMessage(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(erro);
        }
        return null;
    }

    @DeleteMapping("/{idUsuario}")
    @Override
    public void deletarUsuario(@PathVariable Integer idUsuario) {
        usuarioUseCase.deletarUsuario(idUsuario);
    }

    @GetMapping
    @Override
    public List<Usuario> listarUsuario() {
        return usuarioUseCase.listarUsuario();
    }

    @PutMapping("/{idUsuario}")
    @Override
    public void atualizarUsuario(@PathVariable Integer idUsuario, @RequestBody Usuario novoUsuario) {
        usuarioUseCase.atualizarUsuario(idUsuario, novoUsuario);
    }
}
