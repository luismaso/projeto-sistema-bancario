package br.com.cesurgmarau.projeto_sistema_bancario.core.domain.usecase;

import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.BancoRepository;
import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.ContaRepository;
import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.ContaUseCase;
import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.UsuarioRepository;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Banco;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Conta;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaUseCaseImpl implements ContaUseCase {
    @Autowired
    private final ContaRepository contaRepository;
    private final BancoRepository bancoRepository;
    private final UsuarioRepository usuarioRepository;

    public ContaUseCaseImpl(ContaRepository contaRepository, BancoRepository bancoRepository, UsuarioRepository usuarioRepository) {
        this.contaRepository = contaRepository;
        this.bancoRepository = bancoRepository;
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Conta criarConta(String numeroConta, int saldoInicial, String tipoConta, Integer agenciaBanco, String cpfUsuario) throws Exception {
        Banco banco = bancoRepository.buscarBancoPorAgencia(agenciaBanco);
        Usuario usuario = usuarioRepository.buscarUsuarioPorCpf(cpfUsuario);
        Conta novaConta = new Conta();
        novaConta.setNumeroConta(numeroConta);
        novaConta.setSaldoConta(saldoInicial);
        novaConta.setTipoConta(tipoConta);
        novaConta.setBanco(banco);
        novaConta.setUsuario(usuario);

        contaRepository.criarConta(novaConta);

        return novaConta;

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

    @Override
    public void depositar(String numeroConta, int valor) throws Exception {
        Conta conta = contaRepository.buscarContaPorNumero(numeroConta);
        if(conta == null){
            throw new Exception("Conta não encontrada");
        }
        if(valor<=0){
            throw new Exception("O valor para deposito deve ser positivo");
        }

        int novoSaldo = conta.getSaldoConta() + valor;
        conta.setSaldoConta(novoSaldo);

        contaRepository.atualizarConta(conta.getIdConta(), conta);
    }


}
