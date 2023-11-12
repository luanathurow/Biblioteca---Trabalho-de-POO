import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private Biblioteca biblioteca;
    private Scanner entradaUsuario;

    public BibliotecaApp() {
        biblioteca = new Biblioteca(100);
        entradaUsuario = new Scanner(System.in);
    }

    /*public void executa() {
        int op;
        do {
            System.out.println("\n\n\n------ MENU ------");
            System.out.println("1. Pré-cadastrar livro");
            System.out.println("2. Cadastrar livro");
            System.out.println("3. Consultar livro");
            System.out.println("4. Atualizar autor do livro");
            System.out.println("5. Remover livro");
            System.out.println("6. Listar livros");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            op = entradaUsuario.nextInt();
            entradaUsuario.nextLine();

            switch (op) {
                case 1:
                    preCadastrarLivro();
                    break;
                case 2:
                    cadastrarLivro();
                    break;
                case 3:
                    consultarLivro();
                    break;
                case 4:
                    atualizarAutorLivro();
                    break;
                case 5:
                    removerLivro();
                    break;
                case 6:
                    listarLivros();
                    break;
                case 0:
                    System.out.println("Fim");
                    break;
                default:
                    System.out.println("Opcao inválida. Tente novamente.");
                    break;
            }
        } while (op != 0);// opcao 0 quebra o while
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
        //Livro livroNovo = new Livro(tituloLivro, autorLivro, categoriaLivro, isbnLivro, anoPublicacaoLivro);

        //boolean testeLivroNovo = biblioteca.insereLivro(livroNovo);
        // verificando se retorna null entra no if e apresenta os dados do livro
        if (testeLivroNovo) {
            System.out.println("Livro cadastrado em nossa biblioteca com sucesso!");
            System.out.println("________ Resumo do cadastro __________");
            System.out.println("Título: " + livroNovo.getTitulo());
            System.out.println("Autor: " + livroNovo.getAutor());
            System.out.println("Categoria: " + livroNovo.getCategoria());
            System.out.println("ISBN: " + livroNovo.getISBN());
            System.out.println("Ano de Publicacao: " + livroNovo.getAnoPublicacao());
        } else {
            System.out.println("Erro. Não foi possivel realizar o cadastro.");
        }
    }

    public void consultarLivro() {
        System.out.println("Digite o código ISBN para consultar o livro: ");
        String ISBNConsultar = entradaUsuario.nextLine();

        Livro livroEncontrado = biblioteca.consultaLivroISBN(ISBNConsultar);

        if (livroEncontrado != null) {
            System.out.println("Livro encontrado na nossa biblioteca:");
            System.out.println("Título: " + livroEncontrado.getTitulo());
            System.out.println("Autor: " + livroEncontrado.getAutor());
            System.out.println("Categoria: " + livroEncontrado.getCategoria());
            System.out.println("ISBN: " + livroEncontrado.getISBN());
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

    public void listarLivros() {
        ArrayList<Livro> listaDeLivros = biblioteca.listaLivros();

        if (listaDeLivros.isEmpty()) {
            System.out.println("Não há livros na biblioteca.");
        } else {
            System.out.println("Lista de livros na biblioteca:");
            for (Livro livro : listaDeLivros) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Categoria: " + livro.getCategoria());
                System.out.println("ISBN: " + livro.getISBN());
                System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
                System.out.println("--------------------------");
            }
        }
    }*/

}
