package br.edu.ifpe.FormularioDeCadastro.Decorador;

public class GratificacaoBase implements IGratificacao {
    private double salarioBase;

    public GratificacaoBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public double getSalario() {
        return salarioBase;
    }

}
