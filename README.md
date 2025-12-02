# API de Sistema Bancário – JAVA 

Esta é uma **API bancária desenvolvida em Java**, utilizando princípios de **abstração**, **DTOs** e uma arquitetura organizada em **Controller**, **Use Case**, **Repository** e **Entity**.
Os testes foram realizados com o cliente de exemplo **UseBruno**.

A API utiliza um **banco de dados em memória**, permitindo testes rápidos, execução simples e fácil manutenção durante o desenvolvimento.

---

## 🧱 Arquitetura Utilizada

A API segue uma estrutura inspirada na Clean Architecture:

* **Entity** – Entidades principais do domínio (Banco, Usuário, Conta).
* **Repository** – Interfaces e implementações de persistência com **armazenamento em memória**.
* **Use Case** – Regras de negócio e fluxo central da aplicação.
* **Controller** – Pontos de entrada da API, onde chegam as requisições.
* **DTO (Data Transfer Object)** – Objetos usados para envio e recebimento de dados entre camadas.

---

## 📦 Funcionalidades

### ✔ CRUD de Banco

Armazena:

* Número da agência
* Nome da agência

### ✔ CRUD de Usuário

Armazena:

* idUsuario
* Nome
* Sobrenome
* CPF

### ✔ CRUD de Conta

Recebe dados completos de Banco e Usuário.
Armazena:

* idConta
* saldoConta
* numeroConta
* tipoConta

  * **Poupança**
  * **Crédito**
  * **Corrente**

---

## 🏦 Tipos de Conta e Regras

### 💳 Conta de Crédito

* Possui **limite para compras**

### 🏦 Conta Poupança

* Permite **aplicação de rendimento percentual** sobre o saldo

### 💼 Todas as Contas

* Depósitos
* Transferências entre contas

---

## ❗ Tratamento de Erros

A API possui **tratamento de erros bem definido**, garantindo respostas claras para o cliente.

---

## 🧪 Testes com UseBruno

O projeto foi testado utilizando o cliente **UseBruno**, que simula requisições reais para os endpoints da API.

---

## 🗄 Banco de Dados em Memória

A persistência é feita utilizando **estruturas de dados locais (listas, maps, etc.)**, eliminando a necessidade de um banco de dados externo. Ideal para:

* Protótipos
* Demonstrações
* Projetos acadêmicos
* Testes rápidos

---

## 🚀 Objetivo da API

* Aplicar **abstração** em Java
* Demonstrar arquitetura organizada em camadas
* Simular um sistema bancário completo
* Usar persistência **em memória**
* Fornecer tratamento de erros **claro e especificado**
* Facilitar estudos e testes com uma API funcional



## 💳 JSON - CRIAR CONTAS 
## END POINT (http://localhost:8080/contas)
```json
{
    "numeroConta": "1",
    "saldoInicial": 550,
    "tipoConta": "Poupança",
    "agenciaBanco": 1001, 
    "cpfUsuario": "05266511024" 
}
```


## 👤 JSON - CRIAR USUÁRIO
## END POINT (http://localhost:8080/usuarios)
```json
{
  "nome": "Luis",
  "sobrenome": "Maso",
  "cpf": "05266511024"
}
```

## 🏦 JSON - CRIAR BANCO
## END POINT (http://localhost:8080/banco)
```json
{
    "agencia": 1001,
    "nomeAgencia": "Agencia Central"
}
```


## 🛍️ JSON - COMPRA (CRÉDITO)
## END POINT (http://localhost:8080/contas/credito/comprar)
```json
{
  "numeroConta": "1",
  "valor": "1500"
}
```

## 💵 JSON - DEPÓSITO
## END POINT (http://localhost:8080/contas/depositar)
```json
{
  "numeroConta": "1",
  "valor": 4000
}
```

## 🔁 JSON - TRANSFERIR
## END POINT (http://localhost:8080/contas/transferir)
```json
{
  "contaOrigem": "1",
  "contaDestino": "2",
  "valorTransferencia": 13
}
```




 
