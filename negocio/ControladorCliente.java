package negocio;

import entidades.Concrect.Cliente;
import persistencia.DAO;

public class ControladorCliente implements IControlador<Cliente> {
    private static final ControladorCliente instacia = new ControladorCliente();
    private DAO<Cliente> clienteDAO = new DAO<Cliente>();

    public static ControladorCliente getInstacia(){
        return instacia;
    }

    private ControladorCliente() {
        }


    @Override
    public Cliente exibir(Cliente objeto) {
        return clienteDAO.exibirCadastro(objeto);
    }

    @Override
    public void cadastrar(Cliente objeto) {
        clienteDAO.cadastrar(objeto);
    }

    @Override
    public void alterar(Cliente objeto) {
        clienteDAO.alterarDados(objeto);
    }

    @Override
    public void deletar(Cliente objeto) {
        clienteDAO.excluir(objeto);
    }
    
}
