import java.util.Scanner;

public class Home {
    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Qual das operações desejar executar: \n1 - Cadastrar cliente \n2 - Sair");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    TelaCliente telaCliente = new TelaCliente();
                    telaCliente.operacoesCliente();
                    break;
                case 2:
                    System.exit(0);

                default:
                    System.err.println("Operação invalida");
                    break;
            }

        }

    }

}
