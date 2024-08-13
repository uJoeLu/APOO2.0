package negocio;

import entidades.Concrect.Funcionario;

public class FuncionarioBuilder {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String cargo;
    private double salario;

    public FuncionarioBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public FuncionarioBuilder cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public FuncionarioBuilder email(String email) {
        this.email = email;
        return this;
    }

    public FuncionarioBuilder telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public FuncionarioBuilder cargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    public FuncionarioBuilder salario(double salario) {
        this.salario = salario;
        return this;
    }
    
    public Funcionario build(){
        return new Funcionario(nome, cpf, email, telefone, cargo, salario);
    }
}
