package br.edu.ifpe.FormularioDeCadastro.negocio;

import br.edu.ifpe.FormularioDeCadastro.entidades.Concrect.Funcionario;

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
        String cpfFormatado;
            if(cpf.length() != 11){
                String [] cpf_sep = cpf.split("[.-]");
                cpfFormatado = cpf_sep[0]+cpf_sep[1]+cpf_sep[2]+cpf_sep[3];
                this.cpf = cpfFormatado;
            }else{
                this.cpf = cpf;
            }
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
