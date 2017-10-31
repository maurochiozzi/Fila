package fila;

/**
 *
 * @author Mauro
 */
public class Cliente {
    /**
     * Peso associado a quantidade de itens do consumidor, na ordem de 1 a 10.
     */
    private final int quantidadeItens;
    
    /**
     * Armazena o horário que entrou na fila.
     */
    private final Long tempoEntradaNaFila;
    
    /**
     * Armazena o horário que o antedimento foi iniciado.
     */
    private Long tempoSaidaDaFila;
        
    /**
     * Constroi um consumido com as informações básicas dele.
     */
    public Cliente(){
        quantidadeItens = 10;
        tempoEntradaNaFila = System.currentTimeMillis();
    }
    
    /**
     * Inicia o atendimento do consumidor.
     */
    public void tempoSaida(){
        tempoSaidaDaFila = System.currentTimeMillis();
    }
    
    /**
     * Retorna o tempo que o consumidor permaneceu na fila.
     * 
     * @return tempo de espera na fila
     */
    public Long getTempoEsperaFila(){
        return tempoSaidaDaFila - tempoEntradaNaFila;
    }
    
    /**
     * Retorna o valor do quantidadeItens da operação do consumidor.
     * 
     * @return quantidadeItens da operação
     */
    public int getPeso(){
        return quantidadeItens;
    }

    public Long getTempoSaidaDaFila() {
        return tempoSaidaDaFila;
    }

    @Override
    public String toString(){
        return "Peso=" + quantidadeItens + ", Tempo espera fila=" + getTempoEsperaFila();
    }
}
