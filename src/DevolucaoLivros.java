import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DevolucaoLivros<Livro extends Disponibilidade> {
    Cliente cliente;
    Livro livro;
    private Date dataDevolucao;
    private Date dataEntrega;


 //Construtor da classe DevolucaoLivros

    public DevolucaoLivros( Livro livro, Cliente cliente, String dataDevolucao, Date dataEntrega) throws ParseException {
        this.livro = livro;
        this.cliente = cliente;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.dataDevolucao = sdf.parse(dataDevolucao);
        this.dataEntrega = new Date();  
    }

//Método para registrar a devolução do livro
public void registroDevolucao(Livro livro, Cliente cliente) {   
        int atraso = calculaDiasAtraso();

        if (atraso > 0) {
              System.out.println("O livro está com " + atraso + " dias de atraso, a devolução está registrada.");
              livro.setDisponivel(true); // Atualiza a disponibilidade do livro
        
        }
        else{ 
            System.out.println("Devolução registrada com sucesso.");
            livro.setDisponivel(true); // Atualiza a disponibilidade do livro
          
        }

    }
    //Método privado para calcular o número de dias de atraso na devolução

    private int calculaDiasAtraso() {
        if (dataEntrega.after(dataDevolucao)) {
            long diferenca = dataEntrega.getTime() - dataDevolucao.getTime();
            int diasAtraso = (int) (diferenca / (1000 * 60 * 60 * 24));
            return diasAtraso;
        } else {
            return 0;}
    }}


    

