package br.com.cesurgmarau.projeto_sistema_bancario.infra.repository;

import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.BancoRepository;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Banco;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Conta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BancoRepositoryImpl implements BancoRepository {
    private final List<Banco> bancos = new ArrayList<>();
    private int contadorAgencia = 1;

    @Override
    public void criarBanco(Banco banco) throws Exception {
        if (banco.getAgencia() == null) {
            throw new Exception("O número da agência deve ser informado.");
        }

        if (buscarBancoPorAgencia(banco.getAgencia()) != null) {
            throw new Exception("Agência já cadastrada.");
        }
        bancos.add(banco);
    }


    @Override
    public void deletarBanco(Integer agencia) {
        for (Banco b : new ArrayList<>(bancos) ){
            if(b.getAgencia().equals(agencia)){
                bancos.remove(b);
                break;
            }
        }
    }

    @Override
    public void atualizarBanco(Integer agencia, Banco novoBanco) {
        System.out.println("JSON: " + novoBanco.getNomeAgencia());

        for (int i = 0; i < bancos.size(); i++) {
            if(bancos.get(i).getAgencia().equals(agencia)) {
                novoBanco.setAgencia(agencia);
                bancos.set(i, novoBanco);
            }
        }
    }

    @Override
    public List<Banco> listarBancos() {
        return new ArrayList<>(bancos);
    }

    @Override
    public Banco buscarBancoPorAgencia(Integer agencia) {
        for (Banco b : bancos){
            if(b.getAgencia().equals(agencia)){
                return b;
            }
        }

        return null;
    }


}
