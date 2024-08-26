package br.edu.ifpe.FormularioDeCadastro.Decorador;

public class AdicionalNoturno extends GratificaoDecoracao {

    public AdicionalNoturno(IGratificacao salario) {
        super(salario);
    }

    @Override
    public double getSalario() {
        double salarioBase = super.getSalario();
        if (salarioBase == 0) {
            throw new IllegalStateException("Funcionário sem salário. Edite o funcionário e tente novamente.");
        }
        return salarioBase * 1.20;
    }
    

    
}
