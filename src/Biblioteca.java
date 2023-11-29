import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Livro> acervo;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
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

    public Livro consultaLivroISBN(String isbn) {
        for (Livro livro : acervo) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null; // Retorna null se o livro não for encontrado
    }

    public void atualizaLivroAutor(String isbn, String novoAutor) {
        for (Livro livro : acervo) {
            if (livro.getIsbn().equals(isbn)) {
                livro.setAutor(novoAutor); // Atualiza o autor do livro
                break; // Se o livro foi encontrado o loop para
            }
        }
    }

    public boolean removerLivro(String isbn) {
        for (Livro livro : acervo) {
            if (livro.getIsbn().equals(isbn)) {
                acervo.remove(livro);
                return true;
            }
        }
        return false; // Livro não encontrado
    }

    public ArrayList<Livro> listaLivros() {
        return new ArrayList<>(acervo);
    }
}
