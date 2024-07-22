import java.util.Scanner;
import entidades.Abstract.Pessoa;
import entidades.Concrect.ClienteBuilder;
import negocio.ControladorCliente;

public class TelaCliente {

    static Scanner sc = new Scanner(System.in);
    static ControladorCliente controladorCliente = ControladorCliente.getInstacia();

    public void operacoesCliente() {
        while (true) {
            System.out.println("\n1-cadastrar\n2-atualizar\n3-exibir\n4-deletar\n5-exibir lista de cadastros");
            int opcao = sc.nextInt();
            sc.nextLine();
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

    public void cadastrar() {
        System.out.println("Informe um nome: ");
        String nome = sc.nextLine();
        System.out.println("Informe um CPF: ");
        String cpf = sc.nextLine();
        System.out.println("Informe um email: ");
        String email = sc.nextLine();
        System.out.println("Informe um telefone: ");
        String telefone = sc.nextLine();

        Pessoa cliente_novo = new ClienteBuilder()
            .nome(nome)
            .cpf(cpf)
            .email(email)
            .telefone(telefone)
            .build();
        controladorCliente.cadastrar(cliente_novo);
    }

    public void atualizar() {
        System.out.println("Informe o CPF do cliente que quer atualizar: ");
        String cpf = sc.nextLine();
        Pessoa cliente = controladorCliente.cadastro(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado");
        } else {
            System.out.println("Informe o nome: ");
            String nome = sc.nextLine();
            System.out.println("Informe o CPF: ");
            String novoCpf = sc.nextLine();
            System.out.println("Informe o e-mail: ");
            String email = sc.nextLine();
            System.out.println("Informe o telefone: ");
            String telefone = sc.nextLine();
            Pessoa cliente_novo = new ClienteBuilder()
                .nome(nome)
                .cpf(novoCpf)
                .email(email)
                .telefone(telefone)
                .build();
            controladorCliente.cadastrar(cliente_novo);
        }
    }

    public void exibir() {
        System.out.println("Digite o cpf do cliente: ");
        String cpf = sc.nextLine();
        System.out.println(controladorCliente.cadastro(cpf));
    }

    public void deletar() {
        System.out.println("Digite o cpf do cliente: ");
        String cpf = sc.nextLine();
        controladorCliente.deletar(cpf);
    }

    public void exibirLista() {
        controladorCliente.listaCadastros();
    }
}
