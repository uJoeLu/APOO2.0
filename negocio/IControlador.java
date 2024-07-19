package negocio;

public interface IControlador<T> {
    T exibir(String uk);
    void cadastrar(T objeto);
    void alterar(String uk);
    void deletar(String uk);

}
