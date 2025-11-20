package br.com.cesurgmarau.projeto_sistema_bancario.core.domain.usecase;

import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.BancoRepository;
import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.BancoUseCase;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Banco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoUseCaseImpl implements BancoUseCase {
    @Autowired
    BancoRepository bancoRepository;

    @Override
    public void criarBanco(Banco banco) throws Exception {
        bancoRepository.criarBanco(banco);
    }

    @Override
    public void deletarBanco(Integer agencia){
        bancoRepository.deletarBanco(agencia);
    }

    @Override
    public void atualizarBanco(Integer agencia, Banco novoBanco){
        bancoRepository.atualizarBanco(agencia, novoBanco);
    }

    @Override
    public List<Banco> listarBancos() {
        return bancoRepository.listarBancos();

    }
}
