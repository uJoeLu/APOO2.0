package validator;
import br.com.caelum.stella.validation.CPFValidator;

public class AnaliseCPF implements Verificador{
    CPFValidator cpfValidator = new CPFValidator();

    @Override
    public boolean validacao(String cpf) {
        try{
            cpfValidator.assertValid(cpf);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
}
