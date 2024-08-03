package apresentacao;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import entidades.Concrect.Cliente;
import logs.LogMensagem;
import negocio.ClienteBuilder;
import negocio.ControladorCliente;

public class TelaCliente {
    static Scanner sc = new Scanner(System.in);
    static ControladorCliente controladorCliente = ControladorCliente.getInstancia();

    public void operacoesCliente() throws IOException{
        while (true) {
            System.out.println("\n1 - Cadastrar\n2 - Atualizar\n3 - Exibir\n4 - Deletar\n5 - Exibir lista de cadastros\n6 - Sair");
            String opcao = sc.next();
            sc.nextLine(); 
            switch (opcao) {
                case "1":
                    cadastrar();
                    break;
                case "2":
                    atualizar();
                    break;
                case "3":
                    exibir();
                    break;
                case "4":
                    deletar();
                    break;
                case "5":
                    exibirLista();
                    break;
                case "6":
                    System.out.println("Saindo do sistema...");
                    new LogMensagem().log("Programa encerrado");
                    new LogMensagem().closer();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public void cadastrar() throws IOException {
        System.out.println("Informe um nome: ");
        String nome = sc.nextLine();
        System.out.println("Informe um CPF: ");
        String cpf = sc.nextLine();
        System.out.println("Informe um email: ");
        String email = sc.nextLine();
        System.out.println("Informe um telefone: ");
        String telefone = sc.nextLine();

        Cliente cliente_novo = new ClienteBuilder()
                .nome(nome)
                .cpf(cpf)
                .email(email)
                .telefone(telefone)
                .build();
        controladorCliente.cadastrar(cliente_novo);
    }

    public void atualizar() throws IOException {
        System.out.println("Informe o CPF do cliente que quer atualizar: ");
        String cpf = sc.nextLine();
        Cliente cliente = controladorCliente.cadastro(cpf);
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
            Cliente cliente_novo = new ClienteBuilder()
                    .nome(nome)
                    .cpf(novoCpf)
                    .email(email)
                    .telefone(telefone)
                    .build();
            controladorCliente.deletar(cpf);
            controladorCliente.cadastrar(cliente_novo);
        }
    }

    public void exibir() {
        System.out.println("Digite o cpf do cliente: ");
        String cpf = sc.nextLine();
        Cliente cliente = controladorCliente.cadastro(cpf);
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void deletar() throws IOException {
        System.out.println("Digite o cpf do cliente: ");
        String cpf = sc.nextLine();
        controladorCliente.deletar(cpf);
    }

    public void exibirLista() throws IOException{
        List<Cliente> clientes = controladorCliente.listaCadastros();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}
