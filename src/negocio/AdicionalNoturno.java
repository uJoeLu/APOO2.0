package negocio;

public class AdicionalNoturno extends GratificaoDecoracao {

    public AdicionalNoturno(IGratificacao salario) {
        super(salario);
    }

    @Override
    public double gratificacao() {
        return (super.gratificacao()*0.20)+super.gratificacao();
    }
    

    
}
