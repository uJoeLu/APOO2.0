package negocio;

import java.util.function.Predicate;

import entidades.Concrect.Cliente;
import persistencia.DAO;

public class ControladorCliente implements IControlador<Cliente> {
    private static final ControladorCliente instacia = new ControladorCliente();
    private DAO<Cliente> clienteDAO = new DAO<>();

    public static ControladorCliente getInstacia(){
        return instacia;
    }

    private ControladorCliente() {
        }

    @Override
    public Cliente cadastro(String cpf) {
        Predicate<Cliente> buscaCpf = clientes -> clientes.getCpf().equals(cpf);
        return clienteDAO.busca(buscaCpf);
    }

    @Override
    public void cadastrar(Cliente objeto) {
        clienteDAO.cadastrar(objeto);
    }

    @Override
    public void alterar(String cpf) {
        clienteDAO.alterarDados(cadastro(cpf));

    }

    @Override
    public void deletar(String cpf) {
        clienteDAO.excluir(cadastro(cpf));
    }

    @Override
    public void listaCadastros() {
        clienteDAO.ListaDeCadastro();
        
    }
    
    
}
