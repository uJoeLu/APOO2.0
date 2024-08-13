package br.edu.ifpe.FormularioDeCadastro.facade;

import java.util.List;

import br.edu.ifpe.FormularioDeCadastro.entidades.Concrect.Cliente;
import br.edu.ifpe.FormularioDeCadastro.entidades.Concrect.Funcionario;
import br.edu.ifpe.FormularioDeCadastro.negocio.ClienteCon;
import br.edu.ifpe.FormularioDeCadastro.negocio.FabricaControler;
import br.edu.ifpe.FormularioDeCadastro.negocio.FuncionarioCon;

public class Facade{

    private ClienteCon cliente;
    private FuncionarioCon funcionario;

    public  Facade(){
        this.cliente = FabricaControler.controladorCliente();
        this.funcionario = FabricaControler.controladorFuncionario();
    }

    public void cadastrarCliente(Cliente cliente) {
        this.cliente.cadastrar(cliente);
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        this.funcionario.cadastrar(funcionario);
    }

    
    public Cliente buscarCliente(String cpf) {
        return this.cliente.cadastro(cpf);
    }

    
    public Funcionario buscarFuncionario(String cpf) {
        return this.funcionario.cadastro(cpf);
    }

    
    public void deletarCliente(String cpf) {
        this.cliente.deletar(cpf);
    }

    
    public void deletarFuncionario(String cpf) {
        this.funcionario.deletar(cpf);
    }

    
    public List<Cliente> exibirClientes() {
        return this.cliente.listaCadastros();
    }

    
    public List<Funcionario> exibirFuncionarios() {
        return this.funcionario.listaCadastros();
    }

    
}
