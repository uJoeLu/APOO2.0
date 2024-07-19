package entidades.Concrect;

import entidades.Abstract.Pessoa;

public class Cliente extends Pessoa {
    
    private Pessoa clienteBuilder;

    public Cliente(){
        this.clienteBuilder = new Pessoa();
    }
    public static Cliente builder(){
        return new Cliente();
    }
    public Cliente nome(String nome){
        this.clienteBuilder.setNome(nome);
        return this;

    }
    public Cliente cpf(String cpf){
        this.clienteBuilder.setCpf(cpf);
        return this;
        }
    public Cliente email(String email){
        this.clienteBuilder.setEmail(email);
        return this;
    }
    public Cliente telefone(String telefone){
        this.clienteBuilder.setTelefone(telefone);
        return this;
    }

    
}
