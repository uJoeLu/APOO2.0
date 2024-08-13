package br.edu.ifpe.FormularioDeCadastro.Decorador;



public class DecoratorFactory implements IDecoratorFactory{

    @Override
    public IGratificacao Insalubridade(IGratificacao gratificacao) {
        return new Insalubridade(gratificacao);
    }

    @Override
    public IGratificacao Periculosidade(IGratificacao gratificacao) {
        return new Periculosidade(gratificacao);
    }

    @Override
    public IGratificacao AdicionalNoturno(IGratificacao gratificacao) {
        return new AdicionalNoturno(gratificacao);
    }




    
}
