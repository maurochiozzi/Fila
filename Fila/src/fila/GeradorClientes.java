package fila;

/**
 *
 * @author Mauro
 */
public class GeradorClientes implements Runnable{
    private final Fila fila;
    private Long ultimoClienteEntrar;
    private volatile Boolean executar = true;    
    
    public GeradorClientes(Fila fila) {
        this.fila = fila;
        ultimoClienteEntrar = 0l;
    }
    
    public void encerrar(){
        executar = false;
    }
    
    @Override
    public void run(){
        System.err.println("Clientes entrando");
        
        while(executar){
            if(isToGerarCliente()){
                fila.addCliente(new Cliente());
                ultimoClienteEntrar = System.currentTimeMillis();
            }
        }
    }
    
    private Boolean isToGerarCliente(){
        return System.currentTimeMillis() - ultimoClienteEntrar > 100;
    }
           
}
