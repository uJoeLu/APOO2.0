package br.edu.ifpe.FormularioDeCadastro.negocio;


import br.edu.ifpe.FormularioDeCadastro.entidades.Concrect.Funcionario;
import br.edu.ifpe.FormularioDeCadastro.validator.AnaliseCPF;
import br.edu.ifpe.FormularioDeCadastro.validator.IAnaliseCPF;

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
            return analise.validacao(funcionario.getCpf());
    }

    
}
