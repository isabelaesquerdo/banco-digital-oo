package conta;

import java.util.HashMap;
import java.util.Map;

public class Banco {
    private Map<String, Conta> contas = new HashMap<>();
    private Map<String, Cliente> clientes = new HashMap<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    public void criarContaCorrente(String numero, String clienteId, double chequeEspecial) {
        Cliente cliente = clientes.get(clienteId);
        if (cliente != null) {
            ContaCorrente cc = new ContaCorrente(numero, cliente, chequeEspecial);
            contas.put(numero, cc);
        }
    }

    public void criarContaPoupanca(String numero, String clienteId, double rendimento) {
        Cliente cliente = clientes.get(clienteId);
        if (cliente != null) {
            ContaPoupanca cp = new ContaPoupanca(numero, cliente, rendimento);
            contas.put(numero, cp);
        }
    }

    public Conta buscarConta(String numero) {
        return contas.get(numero);
    }

    public void realizarDeposito(String numero, double valor) {
        Conta conta = buscarConta(numero);
        if (conta != null) {
            conta.depositar(valor);
        }
    }

    public void realizarSaque(String numero, double valor) {
        Conta conta = buscarConta(numero);
        if (conta != null) {
            conta.sacar(valor);
        }
    }

    public void realizarTransferencia(String origem, String destino, double valor) {
        Conta contaOrigem = buscarConta(origem);
        Conta contaDestino = buscarConta(destino);
        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.transferir(valor, contaDestino);
        }
    }
}