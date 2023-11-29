import java.util.Date;

public class Livro {
    protected String isbn;
    protected String titulo;
    protected String autor;
    protected String editora;
    protected Date anoPublicacao;
    protected Biblioteca biblioteca;
    protected Genero genero;
    protected boolean disponivel;

    public Livro(String isbn, String titulo, String autor, String editora,Date anoPublicacao, Genero genero) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public Date getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponibilidade) {
        this.disponivel = disponibilidade;
    }

    public void setAutor(String novoAutor) {
        this.autor = novoAutor;
    }
}