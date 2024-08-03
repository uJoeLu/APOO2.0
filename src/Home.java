import java.io.IOException;

import apresentacao.TelaCliente;

public class Home {
    public static void main(String[] args) throws IOException {
        imprimirMensagemDeBoasVindas();
        TelaCliente telaCliente = new TelaCliente();
        telaCliente.operacoesCliente();
    }

    private static void imprimirMensagemDeBoasVindas() {
        System.out.println("*******************************************************");
        System.out.println("*                                                     *");
        System.out.println("*  Bem-vindo ao Sistema de Gerenciamento de Usuários  *");
        System.out.println("*                                                     *");
        System.out.println("*******************************************************");
        System.out.println("\nQual Operação deseja Realizar?");
    }

}
