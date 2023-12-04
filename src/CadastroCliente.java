import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroCliente {

    private List<Cliente> clientes = new ArrayList<>();
    private Scanner entradaUsuario = new Scanner(System.in);

    public Cliente cadastraCliente() {
        System.out.println("Nome: ");
        String nome = entradaUsuario.nextLine();

        System.out.println("Matrícula: ");
        String matricula = entradaUsuario.nextLine();

        System.out.println("Telefone: ");
        String telefone = entradaUsuario.nextLine();

        Cliente novoCliente = new Cliente(nome, matricula, telefone);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
        return novoCliente;
    }
}
