package negocio;

import java.util.List;

import logs.ILog;
import logs.LogMensagem;
import persistencia.DAO;

public class ControladorGenerico<T> implements IControlador<T> {
    private  final DAO<T> dao;
    private  final ILog loggerLog;

    public ControladorGenerico() {
        this.dao = new DAO<>();
        this.loggerLog = new LogMensagem();
    }


    @Override
    public void cadastrar(T objeto) {
        try {
        dao.inserir(objeto);
        loggerLog.log("Objeto " + objeto.getClass().getSimpleName() + " cadastrado com sucesso!");
        } catch (Exception e) {
            loggerLog.log("Erro ao cadastrar objeto " + objeto.getClass().getSimpleName());
            loggerLog.log(e.getMessage());
        }
    }

    @Override
    public T cadastro(String cadastro) {
        return dao.busca(cad -> cad.equals(cadastro));
    }

    @Override
    public void deletar(String del) {
        T obj = cadastro(del);
        try{
            dao.excluir(obj);
            loggerLog.log("Objeto " + obj.getClass().getSimpleName() + " deletado com sucesso");
        }catch(Exception e){
            loggerLog.log("Erro ao deletar :" + obj.getClass().getSimpleName());
            loggerLog.log(e.getMessage());
        }
    }

    @Override
    public List<T> listaCadastros() {
        List<T> cadastros = dao.ListaDeCadastro();
        return cadastros;

    }

}
