package negocio;

public class Insalubridade extends GratificaoDecoracao {

    public Insalubridade(IGratificacao salario) {
        super(salario);
    }

    @Override
    public double gratificacao() {
        return (super.gratificacao() * 0.40)+super.gratificacao();
    }
    
}
