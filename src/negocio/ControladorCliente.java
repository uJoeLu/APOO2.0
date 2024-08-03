package negocio;

import entidades.Concrect.Cliente;
import logs.LogMensagem;
import persistencia.DAO;
import validator.AnaliseCPF;

import java.io.IOException;
import java.util.List;

public class ControladorCliente {
    private static ControladorCliente instancia;
    private DAO<Cliente> dao;

    private ControladorCliente(){
        this.dao = new DAO<>();
    }

    public static ControladorCliente getInstancia(){
        if (instancia == null) {
            instancia = new ControladorCliente();
        }
        return instancia;
    }

    public void cadastrar(Cliente cliente) throws IOException {
        AnaliseCPF analise = new AnaliseCPF();
        analise.validacao(cliente.getCpf());
        dao.inserir(cliente);
        new LogMensagem().log("Cliente: "+cliente.getNome() + " cadastrado com sucesso");              
 
    }

    public Cliente cadastro(String cpf) {
        return dao.busca(cliente -> cliente.getCpf().equals(cpf));
        
    }

    public void deletar(String cpf) throws IOException {
        Cliente cliente = cadastro(cpf);
        if (cliente != null) {
            dao.excluir(cliente);
            new LogMensagem().log("Cliente: "+cliente.getNome() + " deletado com sucesso");
        }else{
            new LogMensagem().log("Cliente não encontrado");
            throw new Error("CPF informa não encontrado");
        }

    }

   public List<Cliente> listaCadastros() throws IOException {
    List<Cliente> clientes = dao.ListaDeCadastro();
    if (clientes == null || clientes.isEmpty()) {
        new LogMensagem().log("Nenhum cliente encontrado");
        throw new Error("Nenhum cliente cadastrado");
    } else {
        new LogMensagem().log("Apresentando a lista de cadastro");
        return clientes;
    }
}
}
