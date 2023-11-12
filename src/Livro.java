import java.util.Date;

public class Livro{
    private String isbn;
    private String nome;
    private String autores;
    private String editora;
    private Date anoPublicacao;
    
    public Livro(String isbn, String nome, String autores, String editora, Date anoPublicacao) {
        this.isbn = isbn;
        this.nome = nome;
        this.autores = autores;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getNome() {
        return nome;
    }

    public String getAutores() {
        return autores;
    }

    public String getEditora() {
        return editora;
    }

    public Date getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAutor(String novoAutor) {
    }
    
}