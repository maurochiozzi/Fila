/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fila;

/**
 *
 * @author Mauro
 */
public class Consumidor {
    /**
     * Define o reflexo do consumidor: tempo que ele vai levar para reagir
     * quando a fila andar.
     */
    private final int reflexo;
    
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
     * 
     * @param reflexo
     * @param peso 
     */
    public Consumidor(int reflexo, int peso){
        this.reflexo = reflexo;
        this.peso = peso;
        this.tempoEntrada = System.currentTimeMillis();
    }
    
    /**
     * Inicia o atendimento do consumidor.
     */
    public void iniciouAtendimento(){
        this.tempoInicioAtendimento = System.currentTimeMillis();
    }
    
    /**
     * Encerra o atendimento do consumidor.
     */
    public void encerrouAtendimento(){
        this.tempoTerminioAtendimento = System.currentTimeMillis();
    }
    
    /**
     * Retorna o tempo que o consumidor permaneceu na fila.
     * 
     * @return tempo de espera na fila
     */
    public Long getTempoEsperaFila(){
        return this.tempoInicioAtendimento - this.tempoEntrada;
    }
    
    /**
     * Retorna o tempo que o consumidor permaneceu no atendimento.
     * 
     * @return  tempo de atendimento
     */
    public Long getTempoEsperaAtendimento(){
        return this.tempoTerminioAtendimento - this.tempoInicioAtendimento;
    }

    @Override
    public String toString(){
        return "Reflexo=" + this.reflexo + ", Peso=" + peso + ", Tempo espera fila=" + getTempoEsperaFila() 
                + ", Tempo espera atendimento=" + getTempoEsperaAtendimento();
    }
}
