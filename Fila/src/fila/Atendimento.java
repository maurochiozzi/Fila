package fila;

/**
 *
 * @author Mauro
 */
public abstract class Atendimento {
    
    public static Long TEMPO_ATENDIMENTO_ITEM = 5000l;
    
    public void realizarAtendimento(Consumidor consumidor){
        Long tempoAtendimento;
        
        tempoAtendimento = TEMPO_ATENDIMENTO_ITEM * consumidor.getPeso();
        
        consumidor.iniciouAtendimento();
        
        try {
                Thread.sleep(tempoAtendimento);
        } catch (InterruptedException e) {}
        
        consumidor.encerrouAtendimento();
        
    }
}
