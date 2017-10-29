package fila;

import java.util.Random;

/**
 *
 * @author Mauro
 */
public class Consumidor {
    /**
     * Define o reflexo do consumidor: tempo que ele vai levar para reagir
     * quando a fila andar, em milisegundos.
     */
    private final Long reflexo;
    
    /**
     * Peso associado a quantidade de itens do consumidor, na ordem de 1 a 10.
     */
    private final int peso;
    
    /**
     * Armazena o horário que entrou na fila.
     */
    private final Long tempoEntrada;
    
    /**
     * Armazena o horário que o antedimento foi iniciado.
     */
    private Long tempoInicioAtendimento;
    
    /**
     * Armazena o horário que o atendimento foi finalizado.
     */
    private Long tempoTerminioAtendimento;
    
    /**
     * Constroi um consumido com as informações básicas dele.
     */
    public Consumidor(){
        Random gerador = new Random();
        
        reflexo = gerador.nextLong() % 1000 + 1;
        peso = gerador.nextInt() % 10 + 1;
        tempoEntrada = System.currentTimeMillis();
    }
    
    /**
     * Inicia o atendimento do consumidor.
     */
    public void iniciouAtendimento(){
        tempoInicioAtendimento = System.currentTimeMillis();
    }
    
    /**
     * Encerra o atendimento do consumidor.
     */
    public void encerrouAtendimento(){
        tempoTerminioAtendimento = System.currentTimeMillis();
    }
    
    /**
     * Retorna o tempo que o consumidor permaneceu na fila.
     * 
     * @return tempo de espera na fila
     */
    public Long getTempoEsperaFila(){
        return tempoInicioAtendimento - tempoEntrada;
    }
    
    /**
     * Retorna o tempo que o consumidor permaneceu no atendimento.
     * 
     * @return  tempo de atendimento
     */
    public Long getTempoEsperaAtendimento(){
        return tempoTerminioAtendimento - tempoInicioAtendimento;
    }
    
    /**
     * Retorna o valor do peso da operação do consumidor.
     * 
     * @return peso da operação
     */
    public int getPeso(){
        return peso;
    }

    @Override
    public String toString(){
        return "Reflexo=" + reflexo + ", Peso=" + peso + ", Tempo espera fila=" + getTempoEsperaFila() 
                + ", Tempo espera atendimento=" + getTempoEsperaAtendimento();
    }
}
