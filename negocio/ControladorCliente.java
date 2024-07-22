package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import entidades.Concrect.Cliente;
import persistencia.DAO;

public class ControladorCliente implements IControlador<Cliente> {
    private static final ControladorCliente instacia = new ControladorCliente();
    private DAO<Cliente> clienteDAO;

    public static ControladorCliente getInstacia(){
        return instacia;
    }

    private ControladorCliente() {
        this.clienteDAO = new DAO<>(new ArrayList<>());
    }

    @Override
    public Cliente cadastro(String cpf) {
        Predicate<Cliente> buscaCpf = cliente -> cliente.getCpf().trim().equals(cpf.trim());
        return clienteDAO.busca(buscaCpf);
    }

    @Override
    public void cadastrar(Cliente cliente) {
        clienteDAO.ListaDeCadastro().add(cliente);
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
    public List<Cliente> listaCadastros() {
        return clienteDAO.ListaDeCadastro();
        
    }
    
}
