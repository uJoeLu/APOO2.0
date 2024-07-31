package servico;

import entidades.Concrect.Cliente;
import negocio.ControladorCliente;

public class ServicoBaseCliente implements ClienteServico{
    protected ClienteServico clienteServico;
    protected ControladorCliente controlador;


    @Override
    public void cadastrarCliente(Cliente cliente) {
        controlador.cadastrar(cliente);
    }

    
}
