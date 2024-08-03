package entidades.Concrect;

import entidades.Abstract.Pessoa;

public class Cliente extends Pessoa {
    public Cliente(String nome, String cpf, String email, String telefone) {
        super(nome, cpf, email, telefone);
    }

    public Cliente() {
        super();
    }
}
