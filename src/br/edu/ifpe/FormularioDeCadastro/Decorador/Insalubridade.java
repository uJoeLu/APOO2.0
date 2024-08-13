package br.edu.ifpe.FormularioDeCadastro.Decorador;


public class Insalubridade extends GratificaoDecoracao {

    public Insalubridade(IGratificacao salario) {
        super(salario);
    }

    @Override
    public double getSalario() {
        return (super.getSalario() * 0.40)+super.getSalario();
    }
    
}
