package Decorador;

public abstract class GratificaoDecoracao implements IGratificacao {
    protected IGratificacao salario;

    public GratificaoDecoracao(IGratificacao salario){
        this.salario = salario;

    }

    @Override
    public double getSalario() {
        return salario.getSalario();
    }


    
}
