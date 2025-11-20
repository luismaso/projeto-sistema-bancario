package br.com.cesurgmarau.projeto_sistema_bancario.core.contract;

import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Banco;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.model.Error;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BancoController {
    ResponseEntity<Error> criarBanco(Banco banco);
    void deletarBanco(Integer agencia);
    void atualizarBanco(Integer agencia, Banco novoBanco);
    List<Banco> listarBancos();
}
