package negocio;

import java.util.function.Predicate;

import entidades.Abstract.Pessoa;
import entidades.Concrect.ClienteBuilder;
import persistencia.DAO;

public class ControladorCliente implements IControlador<ClienteBuilder> {
    private static final ControladorCliente instacia = new ControladorCliente();
    private DAO<ClienteBuilder> clienteDAO = new DAO<>();

    public static ControladorCliente getInstacia(){
        return instacia;
    }

    private ControladorCliente() {
    }

    @Override
    public ClienteBuilder cadastro(String cpf) {
        Predicate<ClienteBuilder> buscaCpf = clientes -> clientes.getCpf().equals(cpf);
        return clienteDAO.busca(buscaCpf);
    }

    @Override
    public void cadastrar(ClienteBuilder cliente) {
        clienteDAO.cadastrar(cliente);
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
