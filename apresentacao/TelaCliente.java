package apresentacao;

import java.util.Scanner;

import entidades.Concrect.Cliente;
import negocio.ControladorCliente;

public class TelaCliente {

    static Scanner sc = new Scanner(System.in);
    static ControladorCliente controladorCliente = ControladorCliente.getInstacia();

    public void operacoesCliente() {
        while (true) {
            System.out.println("\n1-cadastrar\n2-atualizar\n3-exibir\n4-deletar\n5-exibir lista de cadastros");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    atualizar();
                    break;
                case 3:
                    exibir();
                    break;
                case 4:
                    deletar();
                    break;
                case 5:
                    exibirLista();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private static void cadastrar() {
        Cliente cliente = new Cliente();
        System.out.println("Informe um nome: ");
        cliente.nome(sc.nextLine());
        System.out.println("Informe um CPF: ");
        cliente.cpf(sc.nextLine());
        System.out.println("Informe um email: ");
        cliente.email(sc.nextLine());
        System.out.println("Informe um telefone: ");
        cliente.telefone(sc.nextLine());
        controladorCliente.cadastrar(cliente);

    }

    private static void atualizar() {
        System.out.println("Informe o CPF do cliente que quer atualizar: ");
        String cpf = sc.nextLine();
        Cliente cliente = controladorCliente.cadastro(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado");
        } else {
            System.out.println("Informe um novo nome: ");
            cliente.nome(sc.nextLine());
            System.out.println("Informe um novo CPF: ");
            cliente.cpf(sc.nextLine());
            System.out.println("Informe um novo email: ");
            cliente.email(sc.nextLine());
            System.out.println("Informe um novo telefone: ");
            cliente.telefone(sc.nextLine());
            controladorCliente.cadastrar(cliente);
        }

    }

    private static void exibir() {
        System.out.println("Digite o cpf do cliente: ");
        String cpf = sc.nextLine();
        System.out.println(controladorCliente.cadastro(cpf));

    }

    private static void deletar() {
        System.out.println("Digite o cpf do cliente: ");
        String cpf = sc.nextLine();
        controladorCliente.deletar(cpf);

    }

    private static void exibirLista() {
        controladorCliente.listaCadastros();

    }
}
