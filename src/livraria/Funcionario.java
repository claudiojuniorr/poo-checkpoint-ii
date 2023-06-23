package livraria;
import java.util.List;
public class Funcionario {
    private  String nome;
    private String telefone;
    private Endereco endereco;
    private String cargo;
    private Double salario;

    public Funcionario(String nome, String telefone, Endereco endereco, String cargo, Double salario) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cargo = cargo;
        this.salario = salario;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }
    public void realizarVenda(String tituloLivro, List<Livro> livros) {

        // Procura o livro com base no título
        Livro livroEncontrado = null;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
                livroEncontrado = livro;
                break;
            }
        }

        // Verifica se o livro foi encontrado
        if (livroEncontrado != null) {
            if (livroEncontrado.getEstoque() > 0) {
                livroEncontrado.setEstoque(livroEncontrado.getEstoque() - 1);
                System.out.println("Funcionário " + nome + " realizou a venda do livro " + livroEncontrado.getTitulo() + ". Estoque restante: " + livroEncontrado.getEstoque());
            } else {
                System.out.println("Não há mais unidades do livro " + livroEncontrado.getTitulo() + " em estoque.");
            }
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
}
