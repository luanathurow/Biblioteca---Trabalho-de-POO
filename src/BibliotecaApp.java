import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BibliotecaApp extends Biblioteca {
    private Biblioteca biblioteca = new Biblioteca();
    private CadastroCliente cliente = new CadastroCliente();
    private Scanner entradaUsuario = new Scanner(System.in);

    public void executa() {
        int op = 0;

        do {
            try {
                mostrarMenu();

                if (entradaUsuario.hasNextInt()) {
                    op = entradaUsuario.nextInt();
                    entradaUsuario.nextLine();

                    processarOpcao(op);
                } else {
                    System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                    entradaUsuario.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                entradaUsuario.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Erro na entrada. Reinicie o programa.");
                break;
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                break;
            }
        } while (op != 0);

        entradaUsuario.close();
    }

    private void mostrarMenu() {
        System.out.println("\n\n\n------ MENU ------");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Cadastrar Cliente");
        System.out.println("3. Retirar Livro");
        System.out.println("4. Devolver Livro");
        System.out.println("5. Listar Livros");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarLivro();
                break;
            case 2:
                Cliente novoCliente = cliente.cadastraCliente();
                biblioteca.adicionarCliente(novoCliente);
                break;
            case 3:
                retirarLivro();
                break;
            case 4:
                devolverLivro();
                break;
            case 5:
                biblioteca.listarLivros();
                break;
            case 0:
                System.out.println("Fim =)");
                break;
            default:
                System.out.println("Opcao inválida. Tente novamente.");
                break;
        }
    }

    private void cadastrarLivro() {
        try {
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
            entradaUsuario.nextLine(); // Consumir a quebra de linha pendente

            boolean testeLivroNovo = biblioteca.insereLivro(tituloLivro, autorLivro, categoriaLivro, isbnLivro,
                    anoPublicacaoLivro);

            if (testeLivroNovo) {
                System.out.println("Livro cadastrado em nossa biblioteca com sucesso!");
            } else {
                System.out.println("Erro. Não foi possível realizar o cadastro.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada inválida. Certifique-se de que o ano seja um número inteiro.");
            entradaUsuario.nextLine();
        } catch (Exception e) {
            System.out.println("Erro inesperado ao cadastrar livro: " + e.getMessage());
            entradaUsuario.nextLine();
        }
    }

    private void retirarLivro() {
        System.out.println("Digite a matrícula do cliente:");
        String matriculaCliente = entradaUsuario.nextLine();

        Cliente cliente = biblioteca.obterClientePorMatricula(matriculaCliente);

        if (cliente != null) {
            System.out.println("Digite o código do livro que você deseja retirar:");
            String codigoLivro = entradaUsuario.nextLine();

            Livro livro = biblioteca.obterLivroPorCodigo(codigoLivro);

            if (livro != null) {
                RegistroLivro registro = new RegistroLivro(cliente, livro);
                registro.registrarRetiradaLivro();
            } else {
                System.out.println("Livro não encontrado.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void devolverLivro() {
        try {
            System.out.println("Digite a matrícula do cliente:");
            String matriculaCliente = entradaUsuario.nextLine();

            Cliente cliente = biblioteca.obterClientePorMatricula(matriculaCliente);

            if (cliente != null) {
                System.out.println("Digite o código do livro que você deseja devolver:");
                String codigoLivro = entradaUsuario.nextLine();

                Livro livro = biblioteca.obterLivroPorCodigo(codigoLivro);

                if (livro != null) {
                    RegistroLivro registro = new RegistroLivro(cliente, livro);
                    registro.registrarDevolucaoLivro();
                } else {
                    System.out.println("Livro não encontrado.");
                }
            } else {
                System.out.println("Cliente não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao processar devolução: " + e.getMessage());
            entradaUsuario.nextLine(); // Consume the pending newline
        }
    }
}