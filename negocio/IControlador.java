package negocio;

public interface IControlador<T> {
    T cadastro(String uk);
    void cadastrar(T objeto);
    void alterar(String uk);
    void deletar(String uk);
    void  listaCadastros();

}
