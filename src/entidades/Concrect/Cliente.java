package entidades.Concrect;

import entidades.Abstract.Pessoa;

public class Cliente extends Pessoa {
    public Cliente(String nome, String cpf, String email, String telefone) {
        super(nome, cpf, email, telefone);
    }

    public Cliente() {
        super();
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
                '}';
    }
}
