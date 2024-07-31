package servico;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import entidades.Concrect.Cliente;

public class DadosObrigatorio implements ClienteServico{
    private final ClienteServico clienteServico;
    CPFValidator validator = new CPFValidator();

    public DadosObrigatorio(ClienteServico clienteServico){
        this.clienteServico = clienteServico;
        
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        try {
            validator.assertValid(cliente.getCpf());
            clienteServico.cadastrarCliente(cliente);
        } 
        catch (InvalidStateException e) {
            throw new Error("CPF inválido" + e);
        }
    }
    
}
