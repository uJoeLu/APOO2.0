package apresentacao;

import java.util.Scanner;

import negocio.ControladorCliente;

public class TelaCliente {
    
    static Scanner sc = new Scanner(System.in);
    ControladorCliente controladorCliente = ControladorCliente.getInstacia();
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1-cadastrar\n2-atualizar\n3-exibir\n4-deletar\n5-exibir lista de cadastros");
            int opcao = sc.nextInt();
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

    private void cadastrar() {

    }

    private void atualizar() {

    }

    private void exibir() {
        System.out.println("Digite o cpf do cliente: ");
        String cpf = sc.nextLine();
        System.out.println(controladorCliente.exibir(cpf));


    }

    private void deletar() {

    }

    private void exibirLista() {

    }
}
