package controller;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes da classe leitorArquivo
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class LeitorArquivoTest {
    
    /**
     * Test of ler method, of class LeitorArquivo.
     * @throws java.lang.Exception
     */
    @Test
    public void testLer() throws Exception {
        ArrayList<String> expResult = new ArrayList();
        expResult.add("CIDADE");
        expResult.add("GOIANIRA");
        expResult.add("INHUMAS");
        expResult.add("CATURAI");
        ArrayList result = LeitorArquivo.ler();
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of palavrasSorteadas method, of class LeitorArquivo.
     * @throws java.lang.Exception
     */
    @Test
    public void testPalavrasSorteadas() throws Exception {
        ArrayList<String> expResult = new ArrayList();
        expResult.add("PROFISSÃO");
        expResult.add("MEDICO");
        expResult.add("ARQUITETO");
        expResult.add("MECANICO");
        ArrayList result = LeitorArquivo.palavrasSorteadas();
        assertEquals(expResult.size(), result.size());
    }   
}
