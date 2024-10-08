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
                    "\n1 - Cadastrar\n2 - Atualizar\n3 - Exibir\n4 - Deletar\n5 - Exibir lista de cadastros\n6 - Gratificar\n7 - Menu inicial");
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
                    gratificar();
                    break;
                case "7":
                    System.out.println("Voltando para o menu inicial");
                    new LogMensagem().log("Fechando operacao funcionario");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        }
    }

    public void cadastrar() {
        try {
            System.out.println("*Informe um nome: ");
            String nome = sc.nextLine();
            System.out.println("*Informe um CPF: ");
            String cpf = sc.nextLine();
            if (controlador.buscarFuncionario(cpf) != null) {
                System.out.println("CPF já cadastrado");
                return;
            }
            System.out.println("Informe um email: ");
            String email = sc.nextLine();
            System.out.println("Informe um telefone: ");
            String telefone = sc.nextLine();
            System.out.println("Informe um cargo: ");
            String cargo = sc.nextLine();
            System.out.println("Informe um salario: ");
            double salario = Double.parseDouble(sc.nextLine());

            Funcionario funcionario_novo = new FuncionarioBuilder()
                    .nome(nome)
                    .cpf(cpf)
                    .email(email)
                    .telefone(telefone)
                    .cargo(cargo)
                    .salario(salario)
                    .build();
            controlador.cadastrarFuncionario(funcionario_novo);
            if (controlador.buscarFuncionario(funcionario_novo.getCpf()) != null) {
                System.out.println("Funcionário cadastrado");
            } else {
                System.out.println("Funcionário não cadastrado!");
            }
        } catch (Exception e) {
            System.out.println(
                    "Erro ao cadastrar funcionario, favor inserir um valor, caso não tenha um salário informar '0'");
            return;
        }
    }

    public void atualizar() {
        try {
            System.out.println("Informe o CPF do funcionario que quer atualizar: ");
            String cpf = sc.nextLine();
            Funcionario funcionario = controlador.buscarFuncionario(cpf);
            if (funcionario == null) {
                System.out.println("Funcionario não encontrado");
            } else {
                System.out.println("*Informe o nome: ");
                String nome = sc.nextLine();
                String novoCpf = cpf;
                System.out.println("Informe o e-mail: ");
                String email = sc.nextLine();
                System.out.println("Informe o telefone: ");
                String telefone = sc.nextLine();
                System.out.println("Informe um cargo: ");
                String cargo = sc.nextLine();
                System.out.println("Informe um salario: ");
                double salario = Double.parseDouble(sc.nextLine());
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
                if (controlador.buscarFuncionario(novoCpf) == null) {
                    System.out.println("Funcionário não cadastrado");
                } else {
                    System.out.println("Funcionário atualizado com sucesso");
                }
            }
        } catch (Exception e) {
            System.out.println(
                    "Erro ao atualizar funcionário, favor inserir um valor, caso não tenha um salário informar '0'");
            return;
        }
    }

    public void exibir() {
        try {
            System.out.println("Digite o cpf do funcionario: ");
            String cpf = sc.nextLine();
            Funcionario funcionario = controlador.buscarFuncionario(cpf);
            if (funcionario != null) {
                System.out.println(funcionario);
            } else {
                System.out.println("Funcionario não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao exibir funcionario");
            new LogMensagem().log("Erro ao exibir funcionario");
        }
    }

    public void deletar() {
        try {
            System.out.println("Digite o cpf do funcionario: ");
            String cpf = sc.nextLine();
            if (controlador.buscarFuncionario(cpf) == null) {
                System.out.println("Funcionario não encontrado");
            } else {
                controlador.deletarFuncionario(cpf);
                System.out.println("Funcionario deletado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar funcionario");
            new LogMensagem().log("Erro ao deletar funcionario" + e);
            return;
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
        System.out.println("Digite o CPF do funcionário: ");
        String cpf = sc.nextLine();
        Funcionario funcionario = controlador.buscarFuncionario(cpf);
        if (funcionario != null) {
            if (funcionario.getSalario() == 0) {
                System.out.println("Funcionário sem salário. Edite o funcionário e tente novamente.");
                return;
            }
            try {
                IGratificacao salario = new GratificacaoBase(funcionario.getSalario());
                boolean flag = true;
                while (flag) {
                    System.out.println(
                            "Deseja aplicar qual gratificação:\n1 - Insalubridade\n2 - Periculosidade\n3 - Adicional noturno\n4 - Finalizar gratificação");
                    String opcao = sc.nextLine();
                    switch (opcao) {
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
                            System.out.println("Gratificação aplicada com sucesso.");
                            System.out.println("Funcionário gratificado:");
                            System.out.println("CPF: " + funcionario.getCpf());
                            System.out.println("Nome: " + funcionario.getNome());
                            System.out.println("Novo salário: " + funcionario.getSalario());

                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Funcionário não encontrado, tente novamente");
        }
    }
}
