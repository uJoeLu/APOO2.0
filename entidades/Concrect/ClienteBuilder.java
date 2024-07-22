package entidades.Concrect;

import entidades.Abstract.Pessoa;

public class ClienteBuilder {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public ClienteBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public ClienteBuilder email(String email) {
        this.email = email;
        return this;
    }

    public ClienteBuilder telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public Pessoa build() {
        return new Pessoa(nome, cpf, email, telefone);
    }
}
