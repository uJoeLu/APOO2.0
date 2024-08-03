package validator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class AnaliseCPF implements Verificador{
    private final Verificador validador;
    CPFValidator validator = new CPFValidator();

    public AnaliseCPF(Verificador validador){
        this.validador = validador;
        
    }

    @Override
    public void validacao(String cpf) {
        try {
            validator.assertValid(cpf);
            validador.validacao(cpf);
        } 
        catch (InvalidStateException e) {
            throw new Error("CPF inválido" + e);
        }
    }
    
}
