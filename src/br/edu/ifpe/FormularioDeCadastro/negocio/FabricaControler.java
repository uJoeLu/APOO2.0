package br.edu.ifpe.FormularioDeCadastro.negocio;


public class FabricaControler {

    public static FuncionarioCon controladorFuncionario() {
        return FuncionarioCon.getInstancia();
    }
    public static ClienteCon controladorCliente(){
        return ClienteCon.getInstancia();
    }

    };
    

