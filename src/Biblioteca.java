import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Biblioteca extends Livro {

    private Livro[] acervo;
    private int qtdLivro;
    private Scanner entradaUsuario;

    Biblioteca() {
        this.acervo = new Livro[100]; // Inicializa o array com a capacidade 100
        this.qtdLivro = 0; // A quantidade de lirvros incia com 0
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
        Livro livroNovo = new Livro();

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

    public boolean insereLivro(Livro livro) {
        if (qtdLivro < 100) {
            acervo[qtdLivro] = livro;
            qtdLivro++;
            return true;
        } else {
            return false;
        }
    }

    public Livro consultaLivroISBN(String isbn) {
        for (int i = 0; i < qtdLivro; i++) {
            if (acervo[i].getIsbn().equals(isbn)) {
                return acervo[i];
            }
        }
        return null; // Retorna null se o livro não for encontrado
    }

    public void atualizaLivroAutor(String iSBN, String novoAutor) {
        for (int i = 0; i < qtdLivro; i++) {
            if (acervo[i].getIsbn().equals(iSBN)) {
                acervo[i].setAutor(novoAutor); // Atualiza o autor do livro
                break; // Se o livro foi encontrado o loop para
            }
        }
    }

    public boolean removeLivro(String iSBN, String novoAutor) {
        for (int i = 0; i < qtdLivro; i++) {
            if (acervo[i].getIsbn().equals(iSBN)) {
                // Move os livros subsequentes para preencher o espaço
                for (int j = i; j < qtdLivro - 1; j++) {
                    acervo[j] = acervo[j + 1];
                }
                acervo[qtdLivro - 1] = null; // Define a última posição como nula
                qtdLivro--;
                return true;
            }
        }
        return false; // Livro não encontrado
    }

    public ArrayList<Livro> listaLivros() {
        ArrayList<Livro> lista = new ArrayList<>();
        for (int i = 0; i < qtdLivro; i++) {
            lista.add(acervo[i]);
        }
        return lista;
    }
}
