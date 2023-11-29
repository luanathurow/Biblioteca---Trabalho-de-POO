import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroCliente {

    private List<Cliente> clientes = new ArrayList<>();
    private Scanner entradaUsuario = new Scanner(System.in);

    public void cadastraCliente() {
        System.out.println("Nome: ");
        String nome = entradaUsuario.next();

        System.out.println("Matrícula: ");
        String matricula = entradaUsuario.next();

        System.out.println("Telefone: ");
        String telefone = entradaUsuario.next();

        System.out.println("Usuário: ");
        String tipoUsuario = entradaUsuario.next();



        Cliente novoCliente = new Cliente(nome, matricula, telefone);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }
}
