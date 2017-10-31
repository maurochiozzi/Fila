package fila;

/**
 *
 * @author Mauro
 */
public class Atendimento implements Runnable{
    
    public static Long TEMPO_ATENDIMENTO_ITEM = 20l;
    
    private final Fila fila;
    
    private Long ultimaChamada = 0l;
    
    private int quantidadeItens = 0;
    
    private volatile Boolean executar = true;
    
    private Cliente cliente;
    
    public Atendimento(Fila fila) {
        this.fila = fila;
    }
    
    public void encerrar(){
        executar = false;
        System.out.println("Encerrou caixa");
    }
    
    @Override
    public void run(){
        System.out.println("Caixa abriu");
        
        while(executar) {
            if(fila.hasClientes() && isChamarProximo()){
                Cliente cliente = fila.getNext();
                
                quantidadeItens = cliente.getPeso();
                ultimaChamada = System.currentTimeMillis();
                
                System.out.println("Cliente no atendimento!" + "Espera: " + cliente.getTempoEsperaFila());
            }
        }
    }
    
    private Boolean isChamarProximo(){
        //System.out.println(quantidadeItens * TEMPO_ATENDIMENTO_ITEM);
        return (System.currentTimeMillis() - ultimaChamada >= quantidadeItens * TEMPO_ATENDIMENTO_ITEM);
    }
}
