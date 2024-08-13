package br.edu.ifpe.FormularioDeCadastro.validator;
import br.com.caelum.stella.validation.CPFValidator;
import br.edu.ifpe.FormularioDeCadastro.logs.LogMensagem;

public class AnaliseCPF implements IAnaliseCPF{
    CPFValidator cpfValidator = new CPFValidator();
    public AnaliseCPF(){}

    @Override
    public boolean validacao(String cpf) {
        try{
            cpfValidator.assertValid(cpf);
            return true;
        }catch(Exception e){
            new LogMensagem().log("Erro na validação do cpf");
            return false;
        }
    }
    
}
