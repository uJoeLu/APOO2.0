package negocio;

import entidades.Concrect.Cliente;
import persistencia.DAO;
import validator.AnaliseCPF;

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
        AnaliseCPF analise = new AnaliseCPF();
        analise.validacao(cliente.getCpf());
        dao.inserir(cliente);
 
    }

    public Cliente cadastro(String cpf) {
        return dao.busca(cliente -> cliente.getCpf().equals(cpf));
    }

    public void deletar(String cpf) {
        Cliente cliente = cadastro(cpf);
        if (cliente != null) {
            dao.excluir(cliente);
        }else{
            throw new Error("CPF informa não encontrado");
        }

    }

   public List<Cliente> listaCadastros() {
    List<Cliente> clientes = dao.ListaDeCadastro();
    if (clientes == null || clientes.isEmpty()) {
        throw new Error("Nenhum cliente cadastrado");
    } else {
        return clientes;
    }
}
}
