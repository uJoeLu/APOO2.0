package negocio;

import entidades.Concrect.Cliente;
import validator.AnaliseCPF;
import validator.IAnaliseCPF;

public class ClienteCon extends ControladorGenerico<Cliente> {
    private static ClienteCon instancia;
    private IAnaliseCPF analise;

    private ClienteCon() {
        this.analise = new AnaliseCPF();
    }
    
    public static ClienteCon getInstancia() {
        if (instancia == null) {
            instancia = new ClienteCon();
            }
            return instancia;
            }
    @Override
    protected boolean Verificador(Cliente cliente) {
        try{
            analise.validacao(cliente.getCpf());
            return true;
            } catch (Exception e) {
                return false;
            }
    }
    
}
