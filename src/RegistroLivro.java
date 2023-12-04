import java.util.Calendar;
import java.util.Date;

public class RegistroLivro {
    private Cliente cliente;
    private Livro livro;
    private Calendar dataDevolucao = Calendar.getInstance();
    private Calendar dataEntrega = Calendar.getInstance();
    private int quantidadeLivros = 0;

    // Construtor para inicializar um registro com um livro e cliente
    public RegistroLivro(Cliente cliente, Livro livro) {
        this.livro = livro;
        this.cliente = cliente;
    }

    public void registrarRetiradaLivro() {
        if (quantidadeLivros < 3 && livro.getDisponivel()) {
            livro.setDisponivel(false); 
            quantidadeLivros++;
            dataEntrega.setTime(new Date());
            dataEntrega.add(Calendar.DAY_OF_MONTH, 15);
            System.out.println("Livro retirado com sucesso!");
            System.out.println("Data de entrega: " + dataEntrega.getTime());
        } else {
            System.out.println("Limite máximo de livros atingido para este cliente ou livro não disponível.");
        }
    }

    public void registrarDevolucaoLivro() {
        int atraso = calculaDiasAtraso();

        if (atraso > 0) {
            System.out.println("O livro está com " + atraso + " dias de atraso, a devolução está registrada.");
            livro.setDisponivel(true); // Atualiza a disponibilidade do livro
        } else {
            System.out.println("Devolução registrada com sucesso.");
            livro.setDisponivel(true); // Atualiza a disponibilidade do livro
        }

        // Limpa os dados após a devolução
        quantidadeLivros = 0;
    }

    private int calculaDiasAtraso() {
        if (dataEntrega.after(dataDevolucao)) {
            long diferenca = dataEntrega.getTimeInMillis() - dataDevolucao.getTimeInMillis();
            return (int) (diferenca / (1000 * 60 * 60 * 24));
        } else {
            return 0;
        }
    }
}
