package br.com.cesurgmarau.projeto_sistema_bancario.infra.repository;

import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.UsuarioRepository;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Usuario;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final List<Usuario> usuarios = new ArrayList<>();
    private int contadorId = 1;

    @Override
    public void criarUsuario(Usuario usuario) {
        usuario.setIdUsuario(contadorId++);
        usuarios.add(usuario);
    }

    @Override
    public void deletarUsuario(Integer idUsuario) {
        for (Usuario u : new ArrayList<>(usuarios)){
            if(u.getIdUsuario() == idUsuario){
                usuarios.remove(u);
                break;
            }
        }
    }

    @Override
    public List<Usuario> listarUsuario() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public void atualizarUsuario(Integer idUsuario, Usuario novoUsuario) {
        for(int i = 0; i < usuarios.size(); i++){
            if (usuarios.get(i).getIdUsuario().equals(idUsuario)) {
                novoUsuario.setIdUsuario(idUsuario);
                usuarios.set(i, novoUsuario);
                break;
            }
        }
    }
}
