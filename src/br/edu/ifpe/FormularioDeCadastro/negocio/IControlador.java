package br.edu.ifpe.FormularioDeCadastro.negocio;

import java.util.List;

public interface IControlador<T> {
    T cadastro(String uk);
    void cadastrar(T objeto) ;
    void deletar(String uk) ;
    List<T>  listaCadastros() ;

}
