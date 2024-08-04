package negocio;

import java.io.IOException;
import java.util.List;

public interface IControlador<T> {
    T cadastro(String uk);
    void cadastrar(T objeto) throws IOException;
    void deletar(String uk) throws IOException;
    List<T>  listaCadastros() throws IOException;

}
