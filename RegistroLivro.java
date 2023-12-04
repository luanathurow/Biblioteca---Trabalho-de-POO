import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistroLivro {
    private Cliente cliente;
    private Livro livro;
    private Calendar dataDevolucao = Calendar.getInstance();
    private Calendar dataEntrega = Calendar.getInstance();
    private int quantidadeLivros = 0;

    public RegistroLivro(Cliente cliente, Livro livro) {
        this.livro = livro;
        this.cliente = cliente;
    }

    public RegistroLivro() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public int getQuantidadeLivros() {
        return quantidadeLivros;
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
            livro.setDisponivel(true); 
        } else {
            System.out.println("Devolução registrada com sucesso.");
            livro.setDisponivel(true); 
        }
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

    public void relatorioEmArquivo(List<RegistroLivro> registros, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            if (registros == null || registros.isEmpty()) {
                writer.write("Nenhum registro de livro encontrado.");
                return;
            }
    
            Livro livroMaisRetirado = livroMaisRetirado(registros);
            if (livroMaisRetirado != null) {
                writer.write("\nLivro Mais Retirado:\n");
                writer.write(livroMaisRetirado.toString() + "\n");
            } else {
                writer.write("\nNenhum livro mais retirado encontrado.\n");
            }
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public List<Livro> livrosDisponiveis(List<RegistroLivro> registros) {
        List<Livro> livrosDisponiveis = new ArrayList<>();

        for (RegistroLivro registro : registros) {
            if (registro.getQuantidadeLivros() < 3 && registro.getLivro().getDisponivel()) {
                livrosDisponiveis.add(registro.getLivro());
            }
        }

        return livrosDisponiveis;
    }

    public Cliente clienteMaisRetirou(List<RegistroLivro> registros) {
        Map<Cliente, Integer> contadorClientes = new HashMap<>();

        for (RegistroLivro registro : registros) {
            Cliente cliente = registro.getCliente();
            contadorClientes.put(cliente, contadorClientes.getOrDefault(cliente, 0) + registro.getQuantidadeLivros());
        }

        return Collections.max(contadorClientes.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public Cliente clienteMaisAtrasou(List<RegistroLivro> registros) {
        Map<Cliente, Integer> contadorAtrasos = new HashMap<>();

        for (RegistroLivro registro : registros) {
            Cliente cliente = registro.getCliente();
            int atraso = registro.calculaDiasAtraso();
            contadorAtrasos.put(cliente, contadorAtrasos.getOrDefault(cliente, 0) + atraso);
        }

        return Collections.max(contadorAtrasos.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public Livro livroMaisRetirado(List<RegistroLivro> registros) {
        if (registros == null || registros.isEmpty()) {
            System.out.println("Lista de registros vazia ou nula.");
            return null;
        }
    
        Map<Livro, Integer> contadorLivros = new HashMap<>();
    
        for (RegistroLivro registro : registros) {
            if (registro != null && registro.getLivro() != null) {
                Livro livro = registro.getLivro();
                contadorLivros.put(livro, contadorLivros.getOrDefault(livro, 0) + registro.getQuantidadeLivros());
            }
        }
    
        if (contadorLivros.isEmpty()) {
            System.out.println("Nenhum livro encontrado nos registros.");
            return null;
        }
        return Collections.max(contadorLivros.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    
}

