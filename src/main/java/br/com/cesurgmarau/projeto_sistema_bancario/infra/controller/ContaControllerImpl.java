    package br.com.cesurgmarau.projeto_sistema_bancario.infra.controller;


    import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.ContaController;
    import br.com.cesurgmarau.projeto_sistema_bancario.core.contract.ContaUseCase;
    import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.entity.Conta;
    import br.com.cesurgmarau.projeto_sistema_bancario.infra.request.CompraCreditoRequest;
    import br.com.cesurgmarau.projeto_sistema_bancario.infra.request.ContaRequest;
    import br.com.cesurgmarau.projeto_sistema_bancario.infra.request.DepositoRequest;
    import br.com.cesurgmarau.projeto_sistema_bancario.infra.request.TransferenciaRequest;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import br.com.cesurgmarau.projeto_sistema_bancario.core.domain.model.Error;

    import java.util.List;

    @RestController
    @RequestMapping("/contas")
    public class ContaControllerImpl implements ContaController {

        @Autowired
        ContaUseCase contaUseCase;

        @PostMapping
        @Override
        public ResponseEntity<?> criarConta(@RequestBody ContaRequest request) {
            try {
                contaUseCase.criarConta(
                        request.getNumeroConta(),
                        request.getSaldoInicial(),
                        request.getTipoConta(),
                        request.getAgenciaBanco(),
                        request.getCpfUsuario(),
                        request.getLimiteCredito()
                );
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .build();
            } catch (Exception e) {
                Error erro = new Error();
                erro.setMessage(e.getMessage());
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(erro);
            }
        }

        @DeleteMapping("/{idConta}")
        @Override
        public void deletarConta(@PathVariable Integer idConta) {
            contaUseCase.deletarConta(idConta);
        }

        @GetMapping
        @Override
        public List<Conta> listarConta() {
            return contaUseCase.listarConta();
        }

        @PutMapping("/{idConta}")
        @Override
        public void atualizarConta(@PathVariable Integer idConta, @RequestBody Conta novaConta) {
            contaUseCase.atualizarConta(idConta, novaConta);
        }

        @PostMapping("/depositar")
        public ResponseEntity<?> depositar(@RequestBody DepositoRequest request){
            try{
                contaUseCase.depositar(request.getNumeroConta(), request.getValor());
                return ResponseEntity.ok("Deposito realizado");
            } catch (Exception e) {
                Error erro = new Error();
                erro.setMessage(e.getMessage());
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(erro);
            }
        }

        @PostMapping("/transferir")
        public ResponseEntity<?> transferir(@RequestBody TransferenciaRequest request){
            try{
                contaUseCase.transferir(request.getContaOrigem(), request.getContaDestino(), request.getValorTransferencia());
                return ResponseEntity.ok("Valor transferido");
            } catch (Exception e) {
                Error erro = new Error();
                erro.setMessage(e.getMessage());
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(erro);
            }

        }

        @PostMapping("/rendimento/{numeroConta}")
        public ResponseEntity<?> aplicarRendimento(@PathVariable String numeroConta){
            try{
                contaUseCase.aplicarRendimento(numeroConta);
                return ResponseEntity.ok("Rendimento aplicado");
            } catch (Exception e) {
                Error erro = new Error();
                erro.setMessage(e.getMessage());
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(erro);
            }
        }

        @PostMapping("/credito/comprar")
        public ResponseEntity<?> compraCredito(@RequestBody CompraCreditoRequest request){
            try{
                contaUseCase.compraCredito(request.getNumeroConta(), request.getValor());
                return ResponseEntity.ok("Compra em crédito realizada");
            } catch (Exception e) {
                Error erro = new Error();
                erro.setMessage(e.getMessage());
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(erro);
            }
        }
    }