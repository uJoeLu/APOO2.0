package negocio;

import entidades.Concrect.Funcionario;

public class FuncionarioCon {
    private static FuncionarioCon instancia;
    private ControladorGenerico<Funcionario> controlador;

    private FuncionarioCon(){
        controlador = new ControladorGenerico<Funcionario>();
    }

    public static FuncionarioCon getInstancia(){
        if(instancia == null){
            instancia = new FuncionarioCon();
            }
        return instancia;
    }
    
    
}
