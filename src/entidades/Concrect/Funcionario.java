package entidades.Concrect;

import entidades.Abstract.Pessoa;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cpf, String email, String telefone, String cargo, double salario) {
        super(nome, cpf, email, telefone);
        this.cargo = cargo;
        this.salario = salario;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return getClass().getSimpleName() +
                ": nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", telefone='" + getCargo() + '\'' +
                ", telefone='" + getSalario() + '\'' +
                '}';
    }

    
    
}
