import java.util.Date;
import java.util.Scanner;

public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private String editora;
    private Date anoPublicacao;
    private Scanner entradaUsuario;
    private Biblioteca biblioteca;
    private Genero genero;

    public Livro(String isbn, String titulo, String autor, String editora, Date anoPublicacao, Genero genero) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        entradaUsuario = new Scanner(System.in);
        biblioteca = new Biblioteca(100);
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

    public void setAutor(String novoAutor) {
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void preCadastrarLivro() {
        System.out.println("Digite o título do livro que deseja pré-cadastrar: ");
        String tituloLivro = entradaUsuario.nextLine();

        System.out.println("Digite o autor do livro: ");
        String autorLivro = entradaUsuario.nextLine();

        // Criando um objeto do pré cadastro do livro
        //Livro livroPreliminar = new Livro(tituloLivro, autorLivro, "", "", 0);

        System.out.println("________ Resumo do pre-cadastro __________");


    }

    public void cadastrarLivro() {
        System.out.println("Digite o título do livro que deseja inserir: ");
        String tituloLivro = entradaUsuario.nextLine();

        System.out.println("Digite o autor do livro: ");
        String autorLivro = entradaUsuario.nextLine();

        System.out.println("Digite a categoria do livro: ");
        String categoriaLivro = entradaUsuario.nextLine();

        System.out.println("Digite o ISBN do livro: ");
        String isbnLivro = entradaUsuario.nextLine();

        System.out.println("Digite o ano de publicação do livro: ");
        int anoPublicacaoLivro = entradaUsuario.nextInt();
        entradaUsuario.nextLine();

        // Criando o objeto Livro
        Livro livroNovo = new Livro(tituloLivro, autorLivro, categoriaLivro, isbnLivro, anoPublicacaoLivro);

        boolean testeLivroNovo = biblioteca.insereLivro(livroNovo);
        // verificando se retorna null entra no if e apresenta os dados do livro
        if (testeLivroNovo) {
            System.out.println("Livro cadastrado em nossa biblioteca com sucesso!");
            System.out.println("________ Resumo do cadastro __________");
            System.out.println("Título: " + livroNovo.getTitulo());
            System.out.println("Autor: " + livroNovo.getAutor());
            System.out.println("Categoria: " + livroNovo.getGenero());
            System.out.println("ISBN: " + livroNovo.getIsbn());
            System.out.println("Ano de Publicacao: " + livroNovo.getAnoPublicacao());
        } else {
            System.out.println("Erro. Não foi possivel realizar o cadastro.");
        }
    }
}