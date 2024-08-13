package Decorador;


public interface IDecoratorFactory {

    IGratificacao Insalubridade(IGratificacao IGratificacao);
    IGratificacao Periculosidade(IGratificacao IGratificacao);
    IGratificacao AdicionalNoturno(IGratificacao funcionario);

}
