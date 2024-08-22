package br.edu.ifpe.FormularioDeCadastro.negocio;

import java.util.List;

import br.edu.ifpe.FormularioDeCadastro.logs.ILog;
import br.edu.ifpe.FormularioDeCadastro.logs.LogMensagem;
import br.edu.ifpe.FormularioDeCadastro.persistencia.DAO;
import br.edu.ifpe.FormularioDeCadastro.persistencia.IDAO;

public abstract class ControladorGenerico<T> implements IControlador<T> {
    private final IDAO<T> dao;
    private final ILog loggerLog;

    protected ControladorGenerico() {
        this.dao = new DAO<>();
        this.loggerLog = new LogMensagem();
    }

    @Override
    public void cadastrar(T objeto) {
        if (this.Verificador(objeto)) {
            dao.inserir(objeto);
            loggerLog.log("Objeto " + objeto.getClass().getSimpleName() + " cadastrado com sucesso!");
        } else {
            loggerLog.log("Objeto " + objeto.getClass().getSimpleName() + " nao pode ser cadastrar");
        }
    }

    @Override
    public T cadastro(String cpf) {
        int hash;
        if (cpf.length() == 14) {
            String[] cpf_sep = cpf.split("[.-]");
            String cpfFormatado = cpf_sep[0] + cpf_sep[1] + cpf_sep[2] + cpf_sep[3];
            hash = cpfFormatado.hashCode();
        } else {
            hash = cpf.hashCode();
        }

        return dao.busca(cad -> cad.hashCode() == hash);

    }

    @Override
    public void deletar(String del) {
        T obj = cadastro(del);
        try {
            dao.excluir(obj);
            loggerLog.log("Objeto " + obj.getClass().getSimpleName() + " deletado com sucesso");
        } catch (Exception e) {
            loggerLog.log("Erro ao deletar :" + obj.getClass().getSimpleName());
            loggerLog.log(e.getMessage());
        }
    }

    @Override
    public List<T> listaCadastros() {
        List<T> cadastros = dao.ListaDeCadastro();
        return cadastros;

    }

    protected abstract boolean Verificador(T obj);
}
