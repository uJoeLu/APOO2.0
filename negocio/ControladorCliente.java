package negocio;

import persistencia.DAO;
import entidades.Concrect.Cliente;

import java.util.List;

public class ControladorCliente {
    private static ControladorCliente instancia;
    private DAO<Cliente> dao;

    private ControladorCliente() {
        this.dao = new DAO<>();
    }

    public static ControladorCliente getInstancia() {
        if (instancia == null) {
            instancia = new ControladorCliente();
        }
        return instancia;
    }

    public void cadastrar(Cliente cliente) {
        dao.inserir(cliente);
    }

    public Cliente cadastro(String cpf) {
        return dao.busca(cliente -> cliente.getCpf().equals(cpf));
    }

    public void deletar(String cpf) {
        Cliente cliente = cadastro(cpf);
        if (cliente != null) {
            dao.excluir(cliente);
        }
    }

    public List<Cliente> listaCadastros() {
        return dao.ListaDeCadastro();
    }
}
