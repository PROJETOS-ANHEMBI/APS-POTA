package aps;

import java.util.Random;

public class APS {
    
    public static int[] vetor;
    public static Random random;
    
    public static void main(String[] args) {
        
        // Instancia o obj random
        random = new Random();
        
        // GerarVetor(10);
        
    }
    
    // Gera novos vetores com Length dinamico, passado por parametro
    public static void GerarVetor(int maxLength){
        // Instancia o vetor com o Length recebido
        vetor = new int[maxLength];
        // Adiciona valores aleatórios ao vetor
        for(int i = 0; i < maxLength; i++){
            vetor[i] = random.nextInt(100);
        }
    }
    
}
