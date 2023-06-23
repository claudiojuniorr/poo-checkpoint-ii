package livraria;

public class Romance extends Livro{
    private String genero;

    public Romance(String titulo, String autor, int anoPublicacao, int estoque, String genero, Double valor) {
        super(titulo, autor, anoPublicacao, estoque, valor);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void imprimirDetalhes() {
        super.imprimirDetalhes();
        System.out.println("Gênero: " + genero);
    }
}
