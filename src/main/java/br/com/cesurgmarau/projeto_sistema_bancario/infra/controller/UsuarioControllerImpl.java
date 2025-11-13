package br.com.cesurgmarau.projeto_sistema_bancario.infra.controller;

import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.UsuarioController;
import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.UsuarioUseCase;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    UsuarioUseCase usuarioUseCase;

    @PostMapping
    @Override
    public void criarUsuario(@RequestBody Usuario usuario) {
        usuarioUseCase.criarUsuario(usuario);
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
