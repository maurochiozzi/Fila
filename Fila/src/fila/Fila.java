package fila;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauro
 */
public class Fila {
    private final List<Cliente> clientes;
    
    public Fila(){
        clientes = new ArrayList<>();
    }
    
    public Cliente getNext(){
        Cliente proximoCliente = clientes.get(0);
        proximoCliente.tempoSaida();
        clientes.remove(0);
        return proximoCliente;
    }
    
    public void addCliente(Cliente cliente){
        System.err.println("Novo cliente na fila!");
        clientes.add(cliente);
    }
    
    public Boolean hasClientes(){
        return !clientes.isEmpty();
    }
}
