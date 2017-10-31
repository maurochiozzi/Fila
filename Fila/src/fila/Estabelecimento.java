package fila;

/**
 *
 * @author Mauro
 */
public class Estabelecimento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Long inicioExecucao;
        
        Fila fila = new Fila();
        Atendimento atendimento = new Atendimento(fila);
        GeradorClientes gerador = new GeradorClientes(fila);
        
        Thread tAtendimento = new Thread(atendimento);
        Thread tGerador = new Thread(gerador);
        
        inicioExecucao = System.currentTimeMillis();
        
        tAtendimento.start();
        tGerador.start();
        
        while(System.currentTimeMillis() - inicioExecucao < 1000){
            
        }
        
        System.err.println("Encerrou");
        atendimento.encerrar();
        gerador.encerrar();
    }
    
}
