import java.util.Calendar;
import java.util.Date;


public class RegistroLivro<Livro> {

    Cliente cliente;
    Livro livro;
    private Calendar dataDevolucao = Calendar.getInstance();
    private Calendar dataEntrega = Calendar.getInstance();
    int quantidadeLivros = 0;
    boolean disponivel = true;

    public void registroDevolucao(Livro livro, Cliente cliente) {
        int atraso = calculaDiasAtraso();

        if (atraso > 0) {
            System.out.println("O livro está com " + atraso + " dias de atraso, a devolução está registrada.");
            livro.setDisponivel(true); // Atualiza a disponibilidade do livro

        } else {
            System.out.println("Devolução registrada com sucesso.");
            livro.setDisponivel(true); // Atualiza a disponibilidade do livro

        }

    }
    //Método privado para calcular o número de dias de atraso na devolução

    private int calculaDiasAtraso() {
        if (dataEntrega.after(dataDevolucao)) {

            dataEntrega.setTime(dataEntrega.getTime());
            dataDevolucao.setTime(dataDevolucao.getTime());

            long diferenca = dataEntrega.getTimeInMillis() - dataDevolucao.getTimeInMillis();
            int diasAtraso = (int) (diferenca / (1000 * 60 * 60 * 24));
            return diasAtraso;
        } else {
            return 0;
        }
    }

    public Date calculaEntrega(){
       int prazoEntrega = 20;
        Calendar entrega = Calendar.getInstance();
        entrega.setTime(dataEntrega.getTime());
        entrega.add(Calendar.DAY_OF_MONTH, prazoEntrega);

        return entrega.getTime();



    }

    public boolean limiteLivros(int quantidadeLivros){
        return limiteLivros(5);
    }


}
