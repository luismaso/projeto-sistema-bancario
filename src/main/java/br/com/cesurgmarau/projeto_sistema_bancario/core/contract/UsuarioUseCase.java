package br.com.cesurgmarau.projeto_sistema_bancario.core.contract;

import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Usuario;

import java.util.List;

public interface UsuarioUseCase {
    void criarUsuario(Usuario usuario);

    void deletarUsuario(Integer idUsuario);

    List<Usuario> listarUsuario();

    void atualizarUsuario(Integer idUsuario, Usuario novoUsuario);
}
