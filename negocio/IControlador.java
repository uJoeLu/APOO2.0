package negocio;

public interface IControlador<T> {
    public T exibir(T objeto);
    public void cadastrar(T objeto);
    public void alterar(T objeto);
    public void deletar(T objeto);

}
