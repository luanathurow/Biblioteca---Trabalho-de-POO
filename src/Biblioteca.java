import java.util.ArrayList;

public class Biblioteca {

    private Livro[] acervo;
    private int capacidadeMaxima;
    private int qtdLivro;

    Biblioteca(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.acervo = new Livro[capacidadeMaxima]; // Inicializa o array com a capacidade máxima
        this.qtdLivro = 0; // A quantidade de lirvros incia com 0
    }

    public boolean insereLivro(Livro livro) {
        if (qtdLivro < capacidadeMaxima) {
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
