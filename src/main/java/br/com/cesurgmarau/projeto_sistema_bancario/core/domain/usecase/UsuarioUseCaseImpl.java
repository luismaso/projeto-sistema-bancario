package br.com.cesurgmarau.projeto_sistema_bancario.core.domain.usecase;

import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.UsuarioRepository;
import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.UsuarioUseCase;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {
    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public void criarUsuario(Usuario usuario) {
        usuarioRepository.criarUsuario(usuario);
    }

    @Override
    public void deletarUsuario(Integer idUsuario) {
        usuarioRepository.deletarUsuario(idUsuario);

    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepository.listarUsuario();
    }

    @Override
    public void atualizarUsuario(Integer idUsuario, Usuario novoUsuario) {
        usuarioRepository.atualizarUsuario(idUsuario, novoUsuario);
    }
}
