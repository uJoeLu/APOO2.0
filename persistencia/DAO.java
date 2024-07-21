package persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAO<T> implements IDAO<T>{
    private List<T> listaCadastros = new ArrayList<T>();

    
    @Override
    public void cadastrar(T objeto) {
        listaCadastros.add(objeto);
    }

    @Override
    public List<T> ListaDeCadastro() {
        return listaCadastros.stream()
        .collect(Collectors.toList());
    }

    @Override
    public void  excluir(T objeto) {
        listaCadastros.removeIf(obj -> obj.equals(objeto));
    }

    @Override
    public void alterarDados(T objeto) {
        int indice = listaCadastros.indexOf(objeto);
        listaCadastros.set(indice, objeto);
    }

    @Override
    public T exibirCadastro(T objeto) {
        return listaCadastros.stream().filter(obj -> obj.equals(objeto)).findFirst().orElse(null);
    }

    @Override
    public T busca(Predicate<T> filtro) {
        return listaCadastros.stream().filter(filtro).findFirst().orElse(null);
    }
  
    
}
