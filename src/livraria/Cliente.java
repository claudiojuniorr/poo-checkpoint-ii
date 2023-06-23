package livraria;

import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private String telefone;
    private Endereco endereco;

    public Cliente(String nome, String telefone, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void atualizarInformacoesCliente(Scanner scanner, List<Cliente> clientes, Cliente nomeCliente) {
        System.out.print("Digite o nome do cliente que deseja atualizar as informações: ");
        String nome = scanner.next();

        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado != null) {
            System.out.print("Deseja atualizar o telefone do cliente? (S/N): ");
            String atualizarTelefone = scanner.next();

            if (atualizarTelefone.equalsIgnoreCase("S")) {
                System.out.print("Digite o novo telefone do cliente: ");
                String telefone = scanner.next();
                clienteEncontrado.setTelefone(telefone);
            }

            System.out.print("Deseja atualizar o endereço do cliente? (S/N): ");
            String atualizarEndereco = scanner.next();

            if (atualizarEndereco.equalsIgnoreCase("S")) {
                System.out.println("Atualizando o endereço do cliente...");
                System.out.print("Informe a Rua: ");
                String rua = scanner.next();
                System.out.print("Informe o Número: ");
                String numero = scanner.next();
                System.out.print("Informe a Cidade: ");
                String cidade = scanner.next();
                System.out.print("Informe o Estado: ");
                String estado = scanner.next();
                System.out.print("Informe o CEP: ");
                String cep = scanner.next();
                Endereco novoEndereco = new Endereco(rua, numero, cidade, estado, cep);
                clienteEncontrado.setEndereco(novoEndereco);
            }

            System.out.println("Informações do cliente atualizadas com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
