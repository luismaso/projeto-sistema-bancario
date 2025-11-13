package br.com.cesurgmarau.projeto_sistema_bancario.core.contract;

import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Usuario;

import java.util.List;

public interface UsuarioController {
    void criarUsuario(Usuario usuario);

    void deletarUsuario(Integer idUsuario);

    List<Usuario> listarUsuario();

    void atualizarUsuario(Integer idUsuario, Usuario novoUsuario);
}