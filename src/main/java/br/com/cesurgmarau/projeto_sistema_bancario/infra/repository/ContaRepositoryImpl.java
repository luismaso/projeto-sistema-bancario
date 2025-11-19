package br.com.cesurgmarau.projeto_sistema_bancario.infra.repository;

import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.ContaRepository;
import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Conta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Repository
public class ContaRepositoryImpl implements ContaRepository {
    private final List<Conta> contas = new ArrayList<>();
    private int contadorId = 1;
    


    @Override
    public void criarConta(Conta conta) throws Exception {
        boolean NumeroContaExiste = false;

        for (int i = 0; i < contas.size(); i++) {
            if(conta.getNumeroConta().equals(contas.get(i).getNumeroConta())){
                NumeroContaExiste = !NumeroContaExiste;
            }
        }
        if (NumeroContaExiste){
            throw new Exception("Número de conta já existe");
        }else{
            conta.setIdConta(contadorId++);
            conta.setSaldoConta(0);
            contas.add(conta);
        }
    }

    @Override
    public void deletarConta(Integer idConta) {
        for(Conta u : new ArrayList<>(contas)){
            if(u.getIdConta().equals(idConta)){
                contas.remove(u);
                break;
            }
        }
        
    }

    @Override
    public List<Conta> listarConta() {
        return new ArrayList<>(contas);
    }

    @Override
    public void atualizarConta(Integer idConta, Conta novaConta) {
        for (int i = 0; i < contas.size(); i++) {
            if(contas.get(i).getIdConta().equals(idConta)){
                novaConta.setIdConta(idConta);
                contas.set(i, novaConta);
                break;
            }
        }
    }
}
