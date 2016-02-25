package controller;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class FormaViciadaTest {
    
    /**
     * Test of realizaSorteio method, of class FormaViciada.
     */
    @Test
    public void testRealizaSorteio() {
        
        FormaViciada instance = new FormaViciada();
        EnumResultados expResult = EnumResultados.PASSA_VEZ;
        EnumResultados result = instance.realizaSorteio(new ArrayList<EnumResultados>());
        assertEquals(expResult, result);
        
    }    
}
