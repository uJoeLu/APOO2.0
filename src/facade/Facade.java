package facade;

import java.util.List;

import negocio.ClienteCon;
import negocio.FabricaControler;
import negocio.FuncionarioCon;

public class Facade{

    private ClienteCon cliente;
    private FuncionarioCon funcionario;

    public  Facade(){
        this.cliente = FabricaControler.controladorCliente();
        this.funcionario = FabricaControler.controladorFuncionario();
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarCliente'");
    }

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarFuncionario'");
    }

    @Override
    public Cliente buscarCliente(String cpf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarCliente'");
    }

    @Override
    public Funcionario buscarFuncionario(String matricula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarFuncionario'");
    }

    @Override
    public void deletarCliente(String cpf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarCliente'");
    }

    @Override
    public void deletarFuncionario(String matricula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarFuncionario'");
    }

    @Override
    public List<Cliente> exibirClientes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exibirClientes'");
    }

    @Override
    public List<Funcionario> exibirFuncionarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exibirFuncionarios'");
    }

    
}
