package br.edu.ifpe.FormularioDeCadastro.Decorador;

public class AdicionalNoturno extends GratificaoDecoracao {

    public AdicionalNoturno(IGratificacao salario) {
        super(salario);
    }

    @Override
    public double getSalario() {
        return getSalario() * 1.20;
    }
    

    
}
