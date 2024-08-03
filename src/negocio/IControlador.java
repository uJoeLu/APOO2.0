package negocio;

import java.util.List;

public interface IControlador<T> {
    T cadastro(String uk);
    void cadastrar(T objeto);
    void alterar(String uk);
    void deletar(String uk);
    List<T>  listaCadastros();

}
