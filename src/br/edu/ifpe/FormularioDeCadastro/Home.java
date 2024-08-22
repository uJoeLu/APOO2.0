package br.edu.ifpe.FormularioDeCadastro;

import br.edu.ifpe.FormularioDeCadastro.apresentacao.TelaCliente;
import br.edu.ifpe.FormularioDeCadastro.apresentacao.TelaFuncionario;

import br.edu.ifpe.FormularioDeCadastro.logs.LogMensagem;

import java.util.Scanner;

public class Home {
    public static void main(String[] args) {
        new LogMensagem().log("Iniciando o programa");
        System.out.println("*******************************************************");
        System.out.println("*                                                     *");
        System.out.println("*  Bem-vindo ao Sistema de Gerenciamento de Usuários  *");
        System.out.println("*                                                     *");
        System.out.println("*******************************************************");

        boolean flag = true;
        while (flag){
        
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
                System.out.println("\nQual Operação deseja Realizar?");
                System.out.println("1 - Cadastrar cliente \n2 - Cadastrar funcionário\n3 - sair");
                String op = sc.nextLine();
                TelaCliente telaCliente = new TelaCliente();
                TelaFuncionario telaFuncionario = new TelaFuncionario();

                switch (op) {

                    case "1":
                        telaCliente.operacoesCliente();
                        new LogMensagem().log("Acessando o sistema de cliente");
                        break;
                    case "2":
                        telaFuncionario.operacoesFuncionario();
                        new LogMensagem().log("Acessando o sistema de funcionario");
                        break;
                    case "3":
                        System.out.println("Saindo do sistema...");
                        new LogMensagem().log("Encerrando programa");
                        new LogMensagem().closer();
                        flag = false;
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            
        }

    }

}