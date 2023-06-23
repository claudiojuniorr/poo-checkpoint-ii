package livraria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Criação da livraria
        Livraria livraria = new Livraria("Minha Livraria", new Endereco("Rua A", "123", "Campina Grande", "PB", "00000-000"), "123456789");

        // Listas para armazenar funcionários, livros e clientes
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        // Criando quatro funcionários
        Endereco enderecoFuncionario1 = new Endereco("Rua A", "123", "Cidade A", "Estado A", "11111-111");
        Funcionario funcionario1 = new Funcionario("João", "111111111", enderecoFuncionario1, "Vendedor", 2000.0);

        Endereco enderecoFuncionario2 = new Endereco("Rua B", "456", "Cidade B", "Estado B", "22222-222");
        Funcionario funcionario2 = new Funcionario("Maria", "222222222", enderecoFuncionario2, "Atendente", 1800.0);

        Endereco enderecoFuncionario3 = new Endereco("Rua C", "789", "Cidade C", "Estado C", "33333-333");
        Funcionario funcionario3 = new Funcionario("Pedro", "333333333", enderecoFuncionario3, "Gerente", 3000.0);

        Endereco enderecoFuncionario4 = new Endereco("Rua D", "987", "Cidade D", "Estado D", "44444-444");
        Funcionario funcionario4 = new Funcionario("Ana", "444444444", enderecoFuncionario4, "Estoquista", 1500.0);

        // Adicionando funcionários à lista
        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);
        funcionarios.add(funcionario3);
        funcionarios.add(funcionario4);

        // Criando quatro livros
        Livro livro1 = new Fantasia("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997, 10, "Aventura", 29.90);
        Livro livro2 = new Ficcao("1984", "George Orwell", 1949, 5, "Horror", 19.90);
        Livro livro3 = new Horror("It", "Stephen King", 1986, 7, "Terror", 24.90);
        Livro livro4 = new Misterio("O Código Da Vinci", "Dan Brown", 2003, 3, "Suspense", 30.00);

        // Adicionando livros à lista
        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);
        livros.add(livro4);

        // Criando quatro clientes
        Endereco enderecoCliente1 = new Endereco("Rua X", "111", "Cidade X", "Estado X", "55555-555");
        Cliente cliente1 = new Cliente("Fulano", "555555555", enderecoCliente1);

        Endereco enderecoCliente2 = new Endereco("Rua Y", "222", "Cidade Y", "Estado Y", "66666-666");
        Cliente cliente2 = new Cliente("Ciclano", "666666666", enderecoCliente2);

        Endereco enderecoCliente3 = new Endereco("Rua Z", "333", "Cidade Z", "Estado Z", "77777-777");
        Cliente cliente3 = new Cliente("Beltrano", "777777777", enderecoCliente3);

        Endereco enderecoCliente4 = new Endereco("Rua W", "444", "Cidade W", "Estado W", "88888-888");
        Cliente cliente4 = new Cliente("Sicrano", "888888888", enderecoCliente4);

        // Adicionando clientes à lista
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 10) {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    livraria.listarLivros(livros);
                    break;
                case 2:
                    livraria.listarFuncionarios(funcionarios);
                    break;
                case 3:
                    livraria.cadastrarLivro(scanner, livros);
                    break;
                case 4:
                    livraria.removerLivro(scanner, livros);
                    break;
                case 5:
                    System.out.print("Digite o nome do cliente que deseja atualizar as informações: ");
                    String nomeCliente = scanner.next();

                    Cliente clienteEncontrado = null;
                    for (Cliente cliente : clientes) {
                        if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                            clienteEncontrado = cliente;
                            break;
                        }
                    }

                    if (clienteEncontrado != null) {
                        clienteEncontrado.atualizarInformacoesCliente(scanner, clientes, clienteEncontrado);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 6:
                    System.out.print("Digite o nome do funcionário que realizará a venda: ");
                    String nomeFuncionario = scanner.next();

                    // Procura o funcionário com base no nome
                    Funcionario funcionarioEncontrado = null;
                    for (Funcionario funcionario : funcionarios) {
                        if (funcionario.getNome().equalsIgnoreCase(nomeFuncionario)) {
                            funcionarioEncontrado = funcionario;
                            break;
                        }
                    }

                    if (funcionarioEncontrado != null) {
                        System.out.print("Digite o nome do livro que deseja vender: ");
                        String tituloLivro = scanner.next();
                        funcionarioEncontrado.realizarVenda(tituloLivro, livros);
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;
                case 7:
                    livraria.cadastrarCliente(scanner, clientes);
                    break;
                case 8:
                    livraria.listarClientes(clientes);
                    break;
                case 9:
                    System.out.println("=== Modo Supervisor ===");
                    System.out.println("Escolha uma opção:");
                    System.out.println("1. Cadastrar funcionário");
                    System.out.println("2. Demitir funcionário");
                    System.out.print("Opção: ");

                    int opcao1 = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao1) {
                        case 1:
                            System.out.println("=== Cadastro de Funcionário ===");
                            livraria.cadastrarFuncionario(scanner, funcionarios);
                            break;
                        case 2:
                            System.out.println("=== Demissão de Funcionário ===");
                            livraria.demitirFuncionario(scanner, funcionarios);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;
                case 10:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1 - Listar Livros");
        System.out.println("2 - Listar Funcionários");
        System.out.println("3 - Cadastrar Livro");
        System.out.println("4 - Remover Livro");
        System.out.println("5 - Atualizar Informações do Cliente");
        System.out.println("6 - Realizar venda do Livro");
        System.out.println("7 - Cadastrar Cliente");
        System.out.println("8 - Listar Clientes");
        System.out.println("9 - Modo Supervisor");
        System.out.println("10 - Sair");
        System.out.print("Escolha uma opção: ");
    }
}
