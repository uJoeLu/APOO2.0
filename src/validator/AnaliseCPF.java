package validator;
import br.com.caelum.stella.validation.CPFValidator;

public class AnaliseCPF implements Verificador{
    CPFValidator cpfValidator = new CPFValidator();

    @Override
    public void validacao(String cpf) {
            cpfValidator.assertValid(cpf);
    }
    
}
