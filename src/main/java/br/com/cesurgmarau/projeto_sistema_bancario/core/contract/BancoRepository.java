package br.com.cesurgmarau.projeto_sistema_bancario.core.contract;

import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Banco;

import java.util.List;

public interface BancoRepository {
    void criarBanco(Banco banco) throws Exception;
    void deletarBanco(Integer agencia);
    void atualizarBanco(Integer agencia, Banco novoBanco);
    List<Banco> listarBancos();
    Banco buscarBancoPorAgencia(Integer agencia);
}
