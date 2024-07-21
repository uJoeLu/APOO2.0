package persistencia;

import java.util.List;
import java.util.function.Predicate;

public interface IDAO<T> {
    public T exibirCadastro(T objeto);

    public void cadastrar(T objeto);

    public List<T> ListaDeCadastro();

    public void excluir(T objeto);

    public void alterarDados(T alterarcadastro);

    public T busca(Predicate<T> filtro);
    
}
