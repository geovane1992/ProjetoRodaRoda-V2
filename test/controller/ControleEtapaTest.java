package controller;

import java.util.ArrayList;
import java.util.List;
import model.ParametrosIniciais;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes da classe ControleEtapa
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class ControleEtapaTest {
    
    /**
     * Test of jogadorEscolhePalavras method, of class ControleEtapa.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testJogadorEscolhePalavras() {
        String jogad = "";
        int qtdPalavras = 0;
        ArrayList<String> expResult = null;
        List<String> result = ControleEtapa.jogadorEscolhePalavras(jogad,qtdPalavras);
        assertEquals(expResult, result);
    }

    /**
     * Test of mostraPalavrasAacertar method, of class ControleEtapa.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMostraPalavrasAacertar() {
        int qtdPalavras = 0;
        
        ArrayList<String> listaPalavrasEtapa = new ArrayList();
        listaPalavrasEtapa.add("");
        
        boolean result = ControleEtapa.mostraPalavrasAacertar(qtdPalavras, listaPalavrasEtapa);
        assertEquals(listaPalavrasEtapa, result);
    }

    /**
     * Test of iniciaEtapa method, of class ControleEtapa.
     * @throws java.lang.Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIniciaEtapa() throws Exception {
        ParametrosIniciais paramtros = null;
        int etapaAtual = 0;
        ControleEtapa.iniciaEtapa(paramtros, etapaAtual);
    }    
}
