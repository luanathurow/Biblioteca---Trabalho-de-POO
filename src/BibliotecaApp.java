import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private Biblioteca biblioteca;
    private Scanner entradaUsuario;
    private CadastroCliente cliente;

    public BibliotecaApp() {
        biblioteca = new Biblioteca();
        entradaUsuario = new Scanner(System.in);
        cliente = new CadastroCliente(); 
    }

    public void executa() {
        int op;
        do {
            try{
            System.out.println("\n\n\n------ MENU ------");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Retirar Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Listar Livros");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            op = entradaUsuario.nextInt();
            entradaUsuario.nextLine();

            switch (op) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    cliente.cadastraCliente();
                    break; 
                case 3:
                //registra a retirada de livros de um cliente. Um cliente pode retirar no máximo 3 livros e o livro deve estar disponível na biblioteca. Essa funcionalidade calcula uma data de entrega.                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    listarLivros(); 
                    break; 
                case 0:
                    System.out.println("Fim");
                    break;
                default:
                    System.out.println("Opcao inválida. Tente novamente.");
                    break;
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            entradaUsuario.nextLine(); 
            op = -1;
        }
        } while (op != 0);
    }

    private void cadastrarLivro() {
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

        boolean testeLivroNovo = biblioteca.insereLivro(tituloLivro, autorLivro, categoriaLivro, isbnLivro, anoPublicacaoLivro);

        if (testeLivroNovo) {
            System.out.println("Livro cadastrado em nossa biblioteca com sucesso!");
        } else {
            System.out.println("Erro. Não foi possível realizar o cadastro.");
        }
    }

    private void listarLivros() {
    ArrayList<Livro> lista = biblioteca.listarLivros();
    if (lista.isEmpty()) {
        System.out.println("\n");
        System.out.println("Não há livros cadastrados.");
    } else {
        System.out.println("\n");
        System.out.println("Lista de Livros:");
        System.out.println("\n");

        for (Livro livro : lista) {
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Editora: " + livro.getEditora());
            System.out.println("Gênero: " + livro.getGenero());
            System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
            System.out.println("\n");

            System.out.println("---------------");
        }
    }
}


}
