package entidades.Concrect;

public class ClienteOuro implements ICliente {
    private double descontoOuro = ClienteBronze;

    ClienteOuro(){
        this.descontoOuro = 0.05;
    }

    @Override
    public double desconto() {
        System.out.println("Cliente Ouro");
        return descontoOuro;
    }
    
}
