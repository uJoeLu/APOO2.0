package apresentacao;

import logs.LogMensagem;
import negocio.ControladorFuncionario;
import negocio.FuncionarioBuilder;

import java.util.List;
import java.util.Scanner;
import entidades.Concrect.Funcionario;
import java.io.IOException;

public class TelaFuncionario {
    static Scanner sc = new Scanner(System.in);
    static ControladorFuncionario controladorFuncionario = ControladorFuncionario.getInstancia();

    public void operacoesFuncionario() throws IOException {
        while (true) {
            System.out.println(
                    "\n1 - Cadastrar\n2 - Atualizar\n3 - Exibir\n4 - Deletar\n5 - Exibir lista de cadastros\n6 - Sair");
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
        System.out.println("Informe um cargo: ");
        String cargo = sc.nextLine();
        System.out.println("Informe um salario: ");
        double salario = sc.nextDouble();
        

        Funcionario funcionario_novo = new FuncionarioBuilder()
                .nome(nome)
                .cpf(cpf)
                .email(email)
                .telefone(telefone)
                .cargo(cargo)
                .salario(salario)
                .build();
        if (funcionario_novo.equals(controladorFuncionario.cadastro(cpf))) {
            System.out.println("CPF já cadastrado");
        } else {
            controladorFuncionario.cadastrar(funcionario_novo);
        }
    }

    public void atualizar() throws IOException {
        System.out.println("Informe o CPF do funcionario que quer atualizar: ");
        String cpf = sc.nextLine();
        Funcionario funcionario = controladorFuncionario.cadastro(cpf);
        if (funcionario == null) {
            System.out.println("Funcionario não encontrado");
        } else {
            System.out.println("Informe o nome: ");
            String nome = sc.nextLine();
            System.out.println("Informe o CPF: ");
            String novoCpf = sc.nextLine();
            System.out.println("Informe o e-mail: ");
            String email = sc.nextLine();
            System.out.println("Informe o telefone: ");
            String telefone = sc.nextLine();
            System.out.println("Informe um cargo: ");
            String cargo = sc.nextLine();
            System.out.println("Informe um salario: ");
            double salario = sc.nextDouble();
            Funcionario funcionario_novo = new FuncionarioBuilder()
                    .nome(nome)
                    .cpf(novoCpf)
                    .email(email)
                    .telefone(telefone)
                    .cargo(cargo)
                    .salario(salario)
                    .build();
            controladorFuncionario.deletar(cpf);
            controladorFuncionario.cadastrar(funcionario_novo);
        }
    }

    public void exibir() {
        System.out.println("Digite o cpf do funcionario: ");
        String cpf = sc.nextLine();
        Funcionario funcionario = controladorFuncionario.cadastro(cpf);
        if (funcionario != null) {
            System.out.println(funcionario);
        } else {
            System.out.println("Funcionario não encontrado.");
        }
    }

    public void deletar() throws IOException {
        System.out.println("Digite o cpf do funcionario: ");
        String cpf = sc.nextLine();
        if (controladorFuncionario.cadastro(cpf).equals(null)) {
            System.out.println("Funcionario não encontrado");
        } else {
            controladorFuncionario.deletar(cpf);
        }
    }

    public void exibirLista() throws IOException {
        List<Funcionario> funcionarios = controladorFuncionario.listaCadastros();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado.");
        } else {
            funcionarios.forEach(funcionario -> System.out.println(funcionario));
        }
    }
    
}
