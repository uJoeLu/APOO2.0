package br.edu.ifpe.FormularioDeCadastro.Decorador;

public class Insalubridade extends GratificaoDecoracao {

    public Insalubridade(IGratificacao salario) {
        super(salario);
    }

    @Override
    public double getSalario() {
        double salarioBase = super.getSalario();
        if (salarioBase == 0) {
            throw new IllegalStateException("Funcionário sem salário. Edite o funcionário e tente novamente.");
        }
        return super.getSalario() * 1.40;
    }

}
