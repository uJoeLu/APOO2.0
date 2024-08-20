package br.edu.ifpe.FormularioDeCadastro.apresentacao;

import br.edu.ifpe.FormularioDeCadastro.logs.LogMensagem;
import br.edu.ifpe.FormularioDeCadastro.negocio.FuncionarioBuilder;

import java.util.List;
import java.util.Scanner;

import br.edu.ifpe.FormularioDeCadastro.Decorador.DecoratorFactory;
import br.edu.ifpe.FormularioDeCadastro.Decorador.GratificacaoBase;
import br.edu.ifpe.FormularioDeCadastro.Decorador.IDecoratorFactory;
import br.edu.ifpe.FormularioDeCadastro.Decorador.IGratificacao;
import br.edu.ifpe.FormularioDeCadastro.entidades.Concrect.Funcionario;
import br.edu.ifpe.FormularioDeCadastro.facade.Facade;

public class TelaFuncionario {
    static Scanner sc = new Scanner(System.in);
    Facade controlador = new Facade();
    IDecoratorFactory factory = new DecoratorFactory();

    public void operacoesFuncionario() {
        while (true) {
            System.out.println(
                    "\n1 - Cadastrar\n2 - Atualizar\n3 - Exibir\n4 - Deletar\n5 - Exibir lista de cadastros\n6 - gratificar\n7 - Sair");
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
                    gratificar();
                    break;
                case "7":
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

    public void cadastrar() {
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
        if (controlador.buscarFuncionario(cpf) != null) {
            System.out.println("CPF já cadastrado");
        } else {
            controlador.cadastrarFuncionario(funcionario_novo);
        }
        if(controlador.buscarFuncionario(cpf) == null){
            System.out.println("Funcionário não cadastrado");
        }
    }

    public void atualizar() {
        System.out.println("Informe o CPF do funcionario que quer atualizar: ");
        String cpf = sc.nextLine();
        Funcionario funcionario = controlador.buscarFuncionario(cpf);
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
            controlador.deletarFuncionario(cpf);
            controlador.cadastrarFuncionario(funcionario_novo);
        }
    }

    public void exibir() {
        System.out.println("Digite o cpf do funcionario: ");
        String cpf = sc.nextLine();
        Funcionario funcionario = controlador.buscarFuncionario(cpf);
        if (funcionario != null) {
            System.out.println(funcionario);
        } else {
            System.out.println("Funcionario não encontrado.");
        }
    }

    public void deletar() {
        System.out.println("Digite o cpf do funcionario: ");
        String cpf = sc.nextLine();
        if (controlador.buscarCliente(cpf).equals(null)) {
            System.out.println("Funcionario não encontrado");
        } else {
            controlador.deletarFuncionario(cpf);
        }
    }

    public void exibirLista() {
        List<Funcionario> funcionarios = controlador.exibirFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado.");
        } else {
            funcionarios.forEach(funcionario -> System.out.println(funcionario));
        }
    }

    public void gratificar() {
        System.out.println("Digite o cpf do funcionario: ");
        String cpf = sc.nextLine();
        Funcionario funcionario = controlador.buscarFuncionario(cpf);
        if (funcionario != null) {
            IGratificacao salario = new GratificacaoBase(funcionario.getSalario());
            if(salario != null){
                boolean flag = true;
                while(flag){
                    System.out.println("Deseja aplicar qual gratificao:\n1 - Insalubridade\n2 - Periculosidade\3 - Adicional noturno\n4 - Finaliza gratificacao)");
                    String opcao = sc.next();
                    switch(opcao){
                        case "1":
                        salario = factory.Insalubridade(salario);
                        break;
                        case "2":
                        salario = factory.Periculosidade(salario);
                        break;
                        case "3":
                        salario = factory.AdicionalNoturno(salario);
                        break;
                        case "4":
                        funcionario.setSalario(salario.getSalario());
                        flag = false;
                        break;
                        default:
                        System.out.println("Opção invalida");

                    }
                }
            }
        }
        
    }
}
