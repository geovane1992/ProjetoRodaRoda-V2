package controller;

import static controller.EnumResultados.PONTOS_1000;
import static controller.EnumResultados.PONTOS_500;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class FormaAleatoriaTest {
    
    /**
     * Test of realizaSorteio method, of class FormaAleatoria.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testRealizaSorteio() { 
        List<EnumResultados> valores =  null;
        FormaAleatoria instance = new FormaAleatoria();
        EnumResultados expResult = null;
        EnumResultados result = instance.realizaSorteio(valores);
        assertEquals(expResult, result);
    }    
}
