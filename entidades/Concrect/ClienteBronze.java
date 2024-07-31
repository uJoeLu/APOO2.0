package entidades.Concrect;

public class ClienteBronze implements ICliente {
    private double descontoBronze;

    ClienteBronze(){
        this.descontoBronze = 0.05;
    }

    @Override
    public double desconto() {
        return descontoBronze;

    }
    
    
}
