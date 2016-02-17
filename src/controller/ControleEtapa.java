package controller;

import java.io.IOException;
import java.util.ArrayList;
import model.Etapa;
import model.ParametrosIniciais;

/**
 *
 * @author GAOliveira
 */
public class ControleEtapa {
    
    public static void iniciaEtapa(ParametrosIniciais paramtros) throws IOException{
    
    ArrayList<String> letrasEscolhidas = new ArrayList<>();
    Etapa etapa = new Etapa();
        etapa.setLstPalavras(LeitorArquivo.palavrasSorteadas());
        
        System.out.println("***** DICA: " + etapa.getLstPalavras().get(0) + " ***** \n\n");
        
        switch(paramtros.getQtdPalavras()){
            case 1:
                
            break;
                
            case 2:
            break;
                
            case 3:
            break;
        }
        
        
    }
    
}
