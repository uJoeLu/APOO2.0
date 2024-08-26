package br.edu.ifpe.FormularioDeCadastro.Decorador;


public class Periculosidade extends GratificaoDecoracao {

    public Periculosidade(IGratificacao salario) {
        super(salario);
    }

    @Override
    public double getSalario() {
        return super.getSalario() * 1.30;
    }
    
}
