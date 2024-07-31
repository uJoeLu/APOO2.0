package entidades.Concrect;

public class ClientePrata implements ICliente{
    private double desconto = 15/100;
    

    @Override
    public double desconto() {
        return desconto;
    }
    
}
