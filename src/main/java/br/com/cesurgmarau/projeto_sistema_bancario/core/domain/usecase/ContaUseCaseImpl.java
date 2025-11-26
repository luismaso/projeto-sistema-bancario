package br.com.cesurgmarau.projeto_sistema_bancario.core.domain.usecase;

import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.BancoRepository;
import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.ContaRepository;
import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.ContaUseCase;
import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.UsuarioRepository;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Banco;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Conta;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.ContaPoupanca;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Conta criarConta(String numeroConta, int saldoInicial, String tipoConta, Integer agenciaBanco, String cpfUsuario, Integer limiteCredito) throws Exception {
        Banco banco = bancoRepository.buscarBancoPorAgencia(agenciaBanco);
        Usuario usuario = usuarioRepository.buscarUsuarioPorCpf(cpfUsuario);
        if(usuario == null){
            throw new Exception("CPF inválido");
        }
        Conta novaConta;
        String tipoC = tipoConta.toLowerCase();

        if(tipoC.equalsIgnoreCase("poupança")){
            novaConta = new ContaPoupanca();
        }else if(tipoC.equals("corrente")){
            novaConta = new Conta();
        }else if(tipoC.equals("crédito")){
            novaConta = new Conta();
        }else{
            throw new Exception("Tipo de conta inválido");
        }

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

    @Override
    public void transferir(String contaOrigem, String contaDestino, int valorTransferencia) throws Exception {
        Conta origem = contaRepository.buscarContaPorNumero(contaOrigem);
        Conta destino = contaRepository.buscarContaPorNumero(contaDestino);

        if(origem == null){
            throw new Exception("conta de origem não encontrada");
        }
        if(destino == null){
            throw new Exception("conta de destino não encontrada");
        }
        if(origem.getSaldoConta() < valorTransferencia){
            throw new Exception("Não tem o valor suficiente");
        }

        int novoSaldoOrigem = origem.getSaldoConta() - valorTransferencia;
        origem.setSaldoConta(novoSaldoOrigem);
        int novoSaldoDestino = destino.getSaldoConta() + valorTransferencia;
        destino.setSaldoConta(novoSaldoDestino);

        contaRepository.atualizarConta(origem.getIdConta(), origem);
        contaRepository.atualizarConta(destino.getIdConta(), destino);

    }

    @Override
    public void aplicarRendimento (String numeroConta) throws Exception{
        Conta conta = contaRepository.buscarContaPorNumero(numeroConta);

        if(conta == null){
            throw new Exception("Conta inválida");
        }

        if (conta instanceof ContaPoupanca) {

            ContaPoupanca poupanca = (ContaPoupanca) conta;

            poupanca.aplicarRendimento();
            contaRepository.atualizarConta(poupanca.getIdConta(), poupanca);

        } else {
            throw new Exception("Rendimento só pode ser aplicado em Contas Poupanças");
        }

    }

}
