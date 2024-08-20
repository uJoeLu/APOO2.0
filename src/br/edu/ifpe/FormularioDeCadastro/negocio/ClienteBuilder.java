package br.edu.ifpe.FormularioDeCadastro.negocio;
import br.edu.ifpe.FormularioDeCadastro.entidades.Concrect.Cliente;

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
        String cpfFormatado;
            if(cpf.length() > 11){
                String [] cpf_sep = cpf.split("[.-]");
                cpfFormatado = cpf_sep[0]+cpf_sep[1]+cpf_sep[2]+cpf_sep[3];
                this.cpf = cpfFormatado;
            }else{
                this.cpf = cpf;
            }
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

    public Cliente build() {
        return new Cliente(nome, cpf, email, telefone);
    }
}
