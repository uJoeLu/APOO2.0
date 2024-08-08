package negocio;

import entidades.Concrect.Funcionario;

public class GratificacaoBase implements IGratificacao {
    private Funcionario salario;

    @Override
    public double gratificacao() {
        return salario.getSalario();
    }
    
}
