package negocio;

public class Periculosidade extends GratificaoDecoracao {

    public Periculosidade(IGratificacao salario) {
        super(salario);
    }

    @Override
    public double gratificacao() {
        return (super.gratificacao() * 0.30)+super.gratificacao();
    }
    
}
