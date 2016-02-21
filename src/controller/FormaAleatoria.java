package controller;

import java.util.List;
import java.util.Random;

/** Declaração da classe FormaAleatoria
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class FormaAleatoria implements FormaSorteio {

    private final int seed = 7;
    private final int limite = 20;
    
    
    /**
     * Executa o sorteio de forma atelatoria e retorna um resultado.
     * @param valores
     * @return 
     */
    @Override
    public EnumResultados realizaSorteio(List<EnumResultados> valores) {
        
        if(valores.size() < 20 || valores.size() > 20)
        {
            throw new IllegalArgumentException("A string de valores deve conter 20 elementos");
        }
        
        Random gerador = new Random();
        
        return valores.get(gerador.nextInt(limite));        
    }

}
