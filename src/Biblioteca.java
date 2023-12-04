import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Biblioteca {
    protected ArrayList<Livro> acervo;
    protected ArrayList<Cliente> clientes;

    protected Biblioteca() {
        this.acervo = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    protected boolean insereLivro(String titulo, String autor, String categoria, String isbn, int anoPublicacao) {
        Genero generoLivro = obterGeneroDoUsuario();
        Livro novoLivro = new Livro(isbn, titulo, autor, categoria, new Date(anoPublicacao - 1900, 0, 1), generoLivro, true);
        acervo.add(novoLivro);
        return true;
    }

    private Genero obterGeneroDoUsuario() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Escolha o gênero do livro:");
            System.out.println("1. ROMANCE");
            System.out.println("2. DARKROMANCE");
            System.out.println("3. POESIA");
            System.out.println("4. LGBTQIA");
            System.out.println("5. FICCAO");
            System.out.println("6. NAOFICCAO");
            System.out.println("7. SUSPENSE");
            System.out.println("8. ENEMIESTOLOVERS");
            System.out.println("9. OUTROS");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    return Genero.ROMANCE;
                case 2:
                    return Genero.DARKROMANCE;
                case 3:
                    return Genero.POESIA;
                case 4:
                    return Genero.LGBTQIA;
                case 5:
                    return Genero.FICCAO;
                case 6:
                    return Genero.NAOFICCAO;
                case 7:
                    return Genero.SUSPENSE;
                case 8:
                    return Genero.ENEMIESTOLOVERS;
                case 9:
                    return Genero.OUTROS;
                default:
                    System.out.println("Opção inválida. Usando OUTROS por padrão.");
                    return Genero.OUTROS;
            }
        } catch (Exception e) {
            System.out.println("Erro ao obter gênero do usuário. Usando gênero padrão.");
            return Genero.GENERO_PADRAO;
        }
    }

    protected void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    protected Cliente obterClientePorMatricula(String matricula) {
        for (Cliente cliente : clientes) {
            if (cliente.getMatricula().equals(matricula)) {
                return cliente;
            }
        }
        return null;
    }

    protected Livro obterLivroPorCodigo(String isbn) {
        for (Livro livro : acervo) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    public void listarLivros() {
        if (acervo.isEmpty()) {
            System.out.println("\nNão há livros cadastrados.");
        } else {
            System.out.println("\nLista de Livros:");
            for (Livro livro : acervo) {
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

    public ArrayList<Livro> getListaLivros() {
        return acervo;
    }
}