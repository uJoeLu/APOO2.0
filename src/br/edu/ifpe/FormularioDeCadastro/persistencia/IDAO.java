package br.edu.ifpe.FormularioDeCadastro.persistencia;
import java.util.List;
import java.util.function.Predicate;

public interface IDAO<T> {
    public T exibirCadastro(T objeto);

    public void inserir(T objeto);

    public List<T> ListaDeCadastro();

    public void excluir(T objeto);

    public void alterarDados(T alterarcadastro);

    public T busca(Predicate<T> filtro);
    
}
