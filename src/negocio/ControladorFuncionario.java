package negocio;

import java.io.IOException;
import java.util.List;

import entidades.Concrect.Funcionario;
import logs.LogMensagem;
import persistencia.DAO;
import validator.AnaliseCPF;

public class ControladorFuncionario implements IControlador<Funcionario>{
    private static ControladorFuncionario instancia;
    private DAO<Funcionario> dao;

    public ControladorFuncionario(){
        dao = new DAO<Funcionario>();
    }
    public static ControladorFuncionario getInstancia() {
        if (instancia == null) {
            instancia = new ControladorFuncionario();
        }
        return instancia;
    }

        @Override
    public void cadastrar(Funcionario funcionario) throws IOException {
        AnaliseCPF analise = new AnaliseCPF();
        analise.validacao(funcionario.getCpf());
        dao.inserir(funcionario);
        new LogMensagem().log("Funcionario: " + funcionario.getNome() + " cadastrado com sucesso");

    }
    @Override
    public Funcionario cadastro(String cpf) {
        return dao.busca(funcionario -> funcionario.getCpf().equals(cpf));

    }
    @Override
    public void deletar(String cpf) throws IOException {
        Funcionario funcionario = cadastro(cpf);
        if (funcionario != null) {
            dao.excluir(funcionario);
            new LogMensagem().log("Funcionario: " + funcionario.getNome() + " deletado com sucesso");
        }

    }
    @Override
    public List<Funcionario> listaCadastros() throws IOException {
        List<Funcionario> funcionarios = dao.ListaDeCadastro();
            new LogMensagem().log("Apresentando a lista de cadastro");
            return funcionarios;
        
    }
    
}