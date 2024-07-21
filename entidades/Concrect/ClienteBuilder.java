package entidades.Concrect;

import entidades.Abstract.Pessoa;

public class ClienteBuilder extends Pessoa {
    
    private Pessoa pessoa;
  
    public ClienteBuilder(){
        pessoa = new Pessoa(null, null, null,null);

    } 

    public ClienteBuilder nome(String nome){
        this.pessoa.setNome(nome);
        return this;

    }
    public ClienteBuilder cpf(String cpf){
        this.pessoa.setCpf(cpf);
        return this;
        }
    public ClienteBuilder email(String email){
        this.pessoa.setEmail(email);
        return this;
    }
    public ClienteBuilder telefone(String telefone){
        this.pessoa.setTelefone(telefone);
        return this;
    }
    public ClienteBuilder build() {
        return (ClienteBuilder) pessoa;
    }

    
}
