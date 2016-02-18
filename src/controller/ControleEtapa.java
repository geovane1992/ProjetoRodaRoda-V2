package controller;

import java.io.IOException;
import java.util.ArrayList;
import model.Etapa;
import model.ParametrosIniciais;

/**
 *
 * @author GAOliveira
 */
public class ControleEtapa implements Observador{
    
    int etapa;
    String letraSelecionada;
    String palavraSelecionada;
    
    public ControleEtapa(int etapa, Observado obs){
        this.etapa = etapa;
        obs.incluirObservador(this);
    }

    @Override
    public void updateLetra(String letra) {
        letraSelecionada = letra;
    }

    @Override
    public void updatePalavra(String palavra) {
        palavraSelecionada = palavra;
    }
    
    public static void iniciaEtapa(ParametrosIniciais paramtros, int etapaAtual) throws IOException{
    
    ArrayList<String> letrasEscolhidas = new ArrayList<>();
    Etapa etapa = new Etapa();
        etapa.setLstPalavras(LeitorArquivo.palavrasSorteadas());
        
        System.out.println("***** Etapa: " + etapaAtual + " --> DICA: " + etapa.getLstPalavras().get(0) + " ***** ");
        
        switch(paramtros.getQtdPalavras()){
            case 1: 
                for(int i = 0; i < etapa.getLstPalavras().get(0).length(); i++){
                    System.out.print("#");
                }
                System.out.print("\n\n");
            break;
                
            case 2:
                for(int x = 0; x < paramtros.getQtdPalavras(); x++){
                    for(int i = 0; i < etapa.getLstPalavras().get(x).length(); i++){
                        System.out.print("#");
                    }
                    System.out.print("\n");
                }
            break;
                
            case 3:
                for(int x = 0; x < paramtros.getQtdPalavras(); x++){
                    for(int i = 0; i < etapa.getLstPalavras().get(x).length(); i++){
                        System.out.print("#");
                    }
                    System.out.print("\n");
                }
            break;
        }
        
        
    }
    
}
