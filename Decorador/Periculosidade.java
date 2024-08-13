package Decorador;

public class Periculosidade extends GratificaoDecoracao {

    public Periculosidade(IGratificacao salario) {
        super(salario);
    }

    @Override
    public double getSalario() {
        return (super.getSalario() * 0.30)+super.getSalario();
    }
    
}
