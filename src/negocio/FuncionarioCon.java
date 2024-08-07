package negocio;

import entidades.Concrect.Funcionario;
import validator.AnaliseCPF;
import validator.IAnaliseCPF;

public class FuncionarioCon extends ControladorGenerico<Funcionario>{
    private static FuncionarioCon instancia;
    private IAnaliseCPF analise; 

    private FuncionarioCon() {
        this.analise = new AnaliseCPF();
    }

    public static FuncionarioCon getInstancia(){
        if(instancia == null){
            instancia = new FuncionarioCon();
            }
        return instancia;
        
    }

    @Override
    protected boolean Verificador(Funcionario funcionario) {
        try{
            analise.validacao(funcionario.getCpf());
            return true;
            } catch (Exception e) {
                return false;
            }
    }

    
}
