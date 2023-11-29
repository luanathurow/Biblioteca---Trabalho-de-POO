import java.util.Date;
import java.util.Scanner;

public class Livro {
    protected String isbn;
    protected String titulo;
    protected String autor;
    protected String editora;
    protected Date anoPublicacao;
    private Scanner entradaUsuario;
    protected Biblioteca biblioteca;
    protected Genero genero;
    protected boolean disponivel;

    /*public Livro(String isbn, String titulo, String autor, String editora, Date anoPublicacao, Genero genero) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        entradaUsuario = new Scanner(System.in);
        //biblioteca = new Biblioteca(100);
    }*/

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

    public void setAutor(String novoAutor) {
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean setDisponivel() {
        return this.disponivel = true;
    }
}