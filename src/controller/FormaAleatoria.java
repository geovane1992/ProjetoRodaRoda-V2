package controller;

import java.util.Random;

public class FormaAleatoria implements FormaSorteio {

    private int seed = 7;
    private int limite = 20;
    
    
    /**
     * Executa o sorteio de forma atelatoria e retorna um resultado.
     * @param valores
     * @return 
     */
    @Override
    public EnumResultados realizaSorteio(EnumResultados [] valores) {
        
        if(valores.length < 20 || valores.length > 20)
        {
            throw new IllegalArgumentException("A string de valores deve conter 20 elementos");
        }
        
        Random gerador = new Random(seed);
        
        return valores[gerador.nextInt(limite)];        
    }

}
