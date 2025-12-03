package br.com.cesurgmarau.projeto_sistema_bancario.core.contract;

import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioController {
    ResponseEntity criarUsuario(Usuario usuario);

    void deletarUsuario(Integer idUsuario);

    List<Usuario> listarUsuario();

    void atualizarUsuario(Integer idUsuario, Usuario novoUsuario);
}