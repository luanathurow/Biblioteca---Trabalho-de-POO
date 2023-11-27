import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private Biblioteca biblioteca;
    private Scanner entradaUsuario;

    public BibliotecaApp() {
        biblioteca = new Biblioteca();
        entradaUsuario = new Scanner(System.in);
    }

    public void executa() {
        int op;
        do {
            System.out.println("\n\n\n------ MENU ------");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Consultar livro");
            System.out.println("3. Atualizar autor do livro");
            System.out.println("4. Remover livro");
            System.out.println("5. Listar livros");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            op = entradaUsuario.nextInt();
            entradaUsuario.nextLine();

            switch (op) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    consultarLivro();
                    break;
                case 3:
                    atualizarAutorLivro();
                    break;
                case 4:
                    removerLivro();
                    break;
                /*case 5:
                    listarLivros();
                    break;*/
                case 0:
                    System.out.println("Fim");
                    break;
                default:
                    System.out.println("Opcao inválida. Tente novamente.");
                    break;
            }
        } while (op != 0);// opcao 0 quebra o while
    }

    private void cadastrarLivro() {
    }

    public void consultarLivro() {
        System.out.println("Digite o código ISBN para consultar o livro: ");
        String ISBNConsultar = entradaUsuario.nextLine();

        Livro livroEncontrado = biblioteca.consultaLivroISBN(ISBNConsultar);

        if (livroEncontrado != null) {
            System.out.println("Livro encontrado na nossa biblioteca:");
            System.out.println("Título: " + livroEncontrado.getTitulo());
            System.out.println("Autor: " + livroEncontrado.getAutor());
            System.out.println("Editora: " + livroEncontrado.getEditora());
            System.out.println("Genero: " + livroEncontrado.getGenero());
            System.out.println("Ano de Publicação: " + livroEncontrado.getAnoPublicacao());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
    
    public void atualizarAutorLivro() {
        System.out.println("Digite o código ISBN do livro para alterar o Autor: ");
        String ISBNAlterar = entradaUsuario.nextLine();
        System.out.println("Digite o nome do Autor: ");
        String autorAlterar = entradaUsuario.nextLine();

        biblioteca.atualizaLivroAutor(ISBNAlterar, autorAlterar);
        System.out.println("Autor alterado com sucesso!");
    }

    public void removerLivro() {
        System.out.println("Digite o código ISBN para remover o livro: ");
        String ISBNRemover = entradaUsuario.nextLine();
        System.out.println("Digite o nome do Autor para remover o livro: ");
        String autorRemover = entradaUsuario.nextLine();

        boolean livroRemovido = biblioteca.removeLivro(ISBNRemover, autorRemover);
        // se retornar null imprime o primeiro if
        if (livroRemovido) {
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Erro. Livro não removido ou não encontrado.");
        }
    }

}
