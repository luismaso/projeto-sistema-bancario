package br.com.cesurgmarau.projeto_sistema_bancario.infra.repository;

import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.UsuarioRepository;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Usuario;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final List<Usuario> usuarios = new ArrayList<>();
    private int contadorId = 1;

    @Override
    public void criarUsuario(Usuario usuario) {
        boolean cpfExiste = usuarios.stream()
                .anyMatch(u -> u.getCpf().equals(usuario.getCpf()));

        if (cpfExiste) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já cadastrado: " + usuario.getCpf());
        }
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
