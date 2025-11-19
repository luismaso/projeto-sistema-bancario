package br.com.cesurgmarau.projeto_sistema_bancario.core.domain.usecase;

import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.ContaRepository;
import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.ContaUseCase;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaUseCaseImpl implements ContaUseCase {
    @Autowired
    ContaRepository contaRepository;

    @Override
    public void criarConta(Conta conta) throws Exception {
        contaRepository.criarConta(conta);
    }

    @Override
    public void deletarConta(Integer IdConta) {
        contaRepository.deletarConta(IdConta);
    }

    @Override
    public List<Conta> listarConta() {
        return contaRepository.listarConta();
    }

    @Override
    public void atualizarConta(Integer idConta, Conta novaConta) {
        contaRepository.atualizarConta(idConta, novaConta);
    }
}
