package livraria;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int estoque;
    private Double valor;

    public Livro(String titulo, String autor, int anoPublicacao, int estoque, Double valor) {
        if (titulo == null || autor == null || valor == null) {
            throw new IllegalArgumentException("O título, valor e o autor do livro são obrigatórios.");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.estoque = estoque;
        this.valor = valor;
    }

    public void imprimirDetalhes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de Publicação: " + anoPublicacao);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo.");
        }
        this.estoque = estoque;
    }
}
