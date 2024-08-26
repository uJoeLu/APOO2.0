package br.edu.ifpe.FormularioDeCadastro.apresentacao;

import java.util.List;
import java.util.Scanner;
import br.edu.ifpe.FormularioDeCadastro.entidades.Concrect.Cliente;
import br.edu.ifpe.FormularioDeCadastro.facade.Facade;
import br.edu.ifpe.FormularioDeCadastro.logs.LogMensagem;
import br.edu.ifpe.FormularioDeCadastro.negocio.ClienteBuilder;

public class TelaCliente {
    static Scanner sc = new Scanner(System.in);
    Facade controlador = new Facade();

    public void operacoesCliente() {
        while (true) {
            System.out.println(
                    "\n1 - Cadastrar\n2 - Atualizar\n3 - Exibir\n4 - Deletar\n5 - Exibir lista de cadastros\n6 - Menu inicial");
            String opcao = sc.nextLine();
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
                    System.out.println("Voltando para o menu inicial");
                    new LogMensagem().log("Fechando operacao cliente");
                    return;
                default:
                    System.err.println("Opção inválida, tente novamente");
                    break;
            }
        }
    }

    public void cadastrar() {

        System.out.println("*Informe um nome: ");
        String nome = sc.nextLine();
        System.out.println("*Informe um CPF: ");
        String cpf = sc.nextLine();
        if (controlador.buscarCliente(cpf) != null) {
            System.out.println("CPF já cadastrado");
            return;
        }
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

        controlador.cadastrarCliente(cliente_novo);
        if (controlador.buscarCliente(cliente_novo.getCpf()) != null) {
            System.out.println("Cliente cadastrado com sucesso");
        } else {
            System.out.println("Erro ao cadastrar cliente");
            return;
        }

    }

    public void atualizar() {
        System.out.println("Informe o CPF do cliente que quer atualizar: ");
        String cpf = sc.nextLine();
        Cliente cliente = controlador.buscarCliente(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado");
        } else {
            System.out.println("*Informe o nome: ");
            String nome = sc.nextLine();
            String novoCpf = cpf;
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
            controlador.deletarCliente(cpf);
            controlador.cadastrarCliente(cliente_novo);
            if (controlador.buscarCliente(novoCpf) == null) {
                System.out.println("Erro ao atualizar cliente");
            } else {
                System.out.println("Cliente atualizado com sucesso");
            }
        }
    }

    public void exibir() {
        System.out.println("Digite o cpf do cliente: ");
        String cpf = sc.nextLine();
        Cliente cliente = controlador.buscarCliente(cpf);
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void deletar() {
        System.out.println("Digite o cpf do cliente: ");
        String cpf = sc.nextLine();
        if (controlador.buscarCliente(cpf) == null) {
            System.out.println("Cliente não encontrado");
        } else {
            controlador.deletarCliente(cpf);
        }
    }

    public void exibirLista() {
        List<Cliente> clientes = controlador.exibirClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            clientes.forEach(cliente -> System.out.println(cliente));
        }
    }
}
