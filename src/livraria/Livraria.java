package livraria;

import java.util.List;
import java.util.Scanner;

public class Livraria {
    private String nome;
    private Endereco endereco;
    private String telefone;

    public Livraria(String nome, Endereco endereco, String telefone) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome da livraria é obrigatório.");
        }
        if (endereco == null) {
            throw new IllegalArgumentException("O endereço da livraria é obrigatório.");
        }
        if (telefone == null || telefone.isEmpty()) {
            throw new IllegalArgumentException("O telefone da livraria é obrigatório.");
        }

        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void cadastrarLivro(Scanner scanner, List<Livro> livros) {
        System.out.print("Título do livro: ");
        String titulo = scanner.next();
        System.out.print("Autor do livro: ");
        String autor = scanner.next();
        System.out.print("Ano de publicação do livro: ");
        int anoPublicacao = scanner.nextInt();
        System.out.print("Quantidade em estoque do livro: ");
        int estoque = scanner.nextInt();
        System.out.print("Gênero do livro (Fantasia, Ficção, Horror, Mistério): ");
        String genero = scanner.next();

        Livro livro;
        switch (genero.toLowerCase()) {
            case "fantasia":
                System.out.print("Valor do livro: ");
                double valorFantasia = scanner.nextDouble();
                livro = new Fantasia(titulo, autor, anoPublicacao, estoque, genero, valorFantasia);
                break;
            case "ficção":
                System.out.print("Valor do livro: ");
                double valorFiccao = scanner.nextDouble();
                livro = new Ficcao(titulo, autor, anoPublicacao, estoque, genero, valorFiccao);
                break;
            case "horror":
                System.out.print("Valor do livro: ");
                double valorHorror = scanner.nextDouble();
                livro = new Horror(titulo, autor, anoPublicacao, estoque, genero, valorHorror);
                break;
            case "mistério":
                System.out.print("Valor do livro: ");
                double valorMisterio = scanner.nextDouble();
                livro = new Misterio(titulo, autor, anoPublicacao, estoque, genero, valorMisterio);
                break;
            default:
                System.out.println("Tipo de livro inválido. O livro será cadastrado como Geral.");
                System.out.print("Valor do livro: ");
                double valorGeral = scanner.nextDouble();
                livro = new Livro(titulo, autor, anoPublicacao, estoque, valorGeral);
                break;
        }

        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void removerLivro(Scanner scanner, List<Livro> livros) {
        System.out.print("Digite o título do livro que deseja remover: ");
        String titulo = scanner.next();

        Livro livroEncontrado = null;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livroEncontrado = livro;
                break;
            }
        }

        if (livroEncontrado != null) {
            livros.remove(livroEncontrado);
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public void listarLivros(List<Livro> livros) {
        System.out.println("=== Listagem de Livros ===");
        int contador = 0;
        for (Livro livro : livros) {
            contador++;
            System.out.println("Livro " + contador + "\n");
            System.out.println("Titulo: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano: " + livro.getAnoPublicacao());
            System.out.println("Estoque: " + livro.getEstoque());
            if (livro instanceof Misterio) {
                Misterio livroMisterio = (Misterio) livro;
                System.out.println("Gênero: " + livroMisterio.getGenero());
            }else if(livro instanceof Fantasia){
                Fantasia livroFantasia = (Fantasia) livro;
                System.out.println("Gênero: " + livroFantasia.getGenero());
            }else if(livro instanceof Ficcao){
                Ficcao livroFiccao = (Ficcao) livro;
                System.out.println("Gênero: " + livroFiccao.getGenero());
            }else if(livro instanceof Horror){
                Horror livroHorror = (Horror) livro;
                System.out.println("Gênero: " + livroHorror.getGenero());
            }else if(livro instanceof Misterio){
                Misterio livroMisterio = (Misterio) livro;
                System.out.println("Gênero: " + livroMisterio.getGenero());
            }else if(livro instanceof Romance){
                Romance livroRomance = (Romance) livro;
                System.out.println("Gênero: " + livroRomance.getGenero());
            }
            System.out.println("==========================");
        }
    }

    public void cadastrarFuncionario(Scanner scanner, List<Funcionario> funcionarios) {
        System.out.print("Nome do funcionário: ");
        String nome = scanner.next();
        System.out.print("Telefone do funcionário: ");
        String telefone = scanner.next();
        System.out.print("Rua do funcionário: ");
        String rua = scanner.next();
        System.out.print("Número do funcionário: ");
        String numero = scanner.next();
        System.out.print("Cidade do funcionário: ");
        String cidade = scanner.next();
        System.out.print("Estado do funcionário: ");
        String estado = scanner.next();
        System.out.print("CEP do funcionário: ");
        String cep = scanner.next();
        System.out.print("Cargo do funcionário: ");
        String cargo = scanner.next();
        System.out.print("Salário do funcionário: ");
        double salario = Double.longBitsToDouble(scanner.nextInt());

        Endereco endereco = new Endereco(rua, numero, cidade, estado, cep);
        Funcionario funcionario = new Funcionario(nome, telefone, endereco, cargo, salario);
        funcionarios.add(funcionario);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public void demitirFuncionario(Scanner scanner, List<Funcionario> funcionarios) {
        System.out.print("Digite o nome do funcionário que deseja demitir: ");
        String nome = scanner.next();

        Funcionario funcionarioEncontrado = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                funcionarioEncontrado = funcionario;
                break;
            }
        }

        if (funcionarioEncontrado != null) {
            funcionarios.remove(funcionarioEncontrado);
            System.out.println("Funcionário demitido com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }
    public void listarFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("=== Listagem de Funcionários ===");
        int contador = 0;
        for (Funcionario funcionario : funcionarios) {
            contador++;
            System.out.println("Funcionário " + contador + "\n");
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("===============================");
        }
    }

    public void cadastrarCliente(Scanner scanner, List<Cliente> clientes) {
        System.out.print("Nome do cliente: ");
        String nome = scanner.next();
        System.out.print("Telefone do cliente: ");
        String telefone = scanner.next();

        System.out.println("== Endereço do Cliente ==");
        System.out.print("Rua: ");
        String rua = scanner.next();
        System.out.print("Número: ");
        String numero = scanner.next();
        System.out.print("Cidade: ");
        String cidade = scanner.next();
        System.out.print("Estado: ");
        String estado = scanner.next();
        System.out.print("CEP: ");
        String cep = scanner.next();

        Endereco endereco = new Endereco(rua, numero, cidade, estado, cep);
        Cliente cliente = new Cliente(nome, telefone, endereco);
        clientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listarClientes(List<Cliente> clientes) {
        System.out.println("=== Listagem de Clientes ===");
        int contador = 0;
        for (Cliente cliente : clientes) {
            contador++;
            System.out.println("Cliente " + contador + "\n");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Endereço: " + cliente.getEndereco().getRua() + ", " + cliente.getEndereco().getNumero() + ", " + cliente.getEndereco().getCidade());
            System.out.println("===========================");
        }
    }
}
