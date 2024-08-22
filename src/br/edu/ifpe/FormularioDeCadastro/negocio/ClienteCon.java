package br.edu.ifpe.FormularioDeCadastro.negocio;

import br.edu.ifpe.FormularioDeCadastro.entidades.Concrect.Cliente;
import br.edu.ifpe.FormularioDeCadastro.validator.AnaliseCPF;
import br.edu.ifpe.FormularioDeCadastro.validator.IAnaliseCPF;

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
        return analise.validacao(cliente.getCpf()) & !cliente.getNome().isEmpty();
    }
    
}
