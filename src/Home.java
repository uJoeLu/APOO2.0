import java.io.IOException;

import apresentacao.TelaCliente;
import apresentacao.TelaFuncionario;
import logs.LogMensagem;

import java.util.Scanner;

public class Home {
    public static void main(String[] args) throws IOException {
        System.out.println("*******************************************************");
        System.out.println("*                                                     *");
        System.out.println("*  Bem-vindo ao Sistema de Gerenciamento de Usuários  *");
        System.out.println("*                                                     *");
        System.out.println("*******************************************************");
        
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        TelaCliente telaCliente = new TelaCliente();
        TelaFuncionario telaFuncionario = new TelaFuncionario();

        System.out.println("\nQual Operação deseja Realizar?");
        System.out.println("1 - Cadastrar cliente ou 2 - Cadastrar funcionário");
        String op = sc.next();
        switch (op) {

            case "1":
                telaCliente.operacoesCliente();
                break;
            case "2":
                telaFuncionario.operacoesFuncionario();
                break;
            case "3":
                System.out.println("Saindo do sistema...");
                new LogMensagem().log("Encerrando programa");
                new LogMensagem().closer();
            default:
                System.out.println("Opção inválida");
        }
    }


    
}
