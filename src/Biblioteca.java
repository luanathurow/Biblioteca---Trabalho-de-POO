import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Livro> acervo;
    private ArrayList<Cliente> clientes;
    private ArrayList<Livro> livros;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
        clientes = new ArrayList<>();
        livros = new ArrayList<>();
    }

    public boolean insereLivro(String titulo, String autor, String categoria, String isbn, int anoPublicacao) {
        Genero generoLivro = obterGeneroDoUsuario();
        Livro novoLivro = new Livro(isbn, titulo, autor, categoria, new Date(anoPublicacao - 1900, 0, 1), generoLivro);
        acervo.add(novoLivro);
        return true;
    }

    private Genero obterGeneroDoUsuario() {
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

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

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
    }

    public Cliente obterClientePorMatricula(String matricula) {
        for (Cliente cliente : clientes) {
            if (cliente.getMatricula().equals(matricula)) {
                return cliente;
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }

    public Livro obterLivroPorCodigo(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn() == isbn) {
                return livro;
            }
        }
        return null; // Retorna null se o livro não for encontrado
    }


    public ArrayList<Livro> listarLivros() {
        return acervo;
    } 
    
}
