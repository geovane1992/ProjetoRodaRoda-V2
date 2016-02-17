package view;

import controller.ControlePartida;
import java.io.IOException;
import java.util.Scanner;
import model.ParametrosIniciais;



/**
 * Classe responsável por inicializar a aplicação Roda Roda
 *
 * @author Geovane
 * @author José Sérgio
 * @version 2.0
 *
 */
public class RodaRoda {

    public static void main(String[] args) throws IOException{
        menu();
    }
    
    public static void menu() throws IOException{
        Scanner lerParametros = new Scanner(System.in);
        ParametrosIniciais parametros = new ParametrosIniciais();

               
                
        System.out.println("######## Jogo Roda a Roda ########\n\n"
                         + "****** Parâmetros Iniciais ****** \n\n");
        
        System.out.println("Informe a quantidade de Jogadores...");
        parametros.setQtdJogadores(lerParametros.nextInt());
        
        System.out.println("Informe a quantidade de Palavras...");
        parametros.setQtdPalavras(lerParametros.nextInt());
        
        System.out.println("Informe a quantidade de Etapas...");
        parametros.setQtdEtapas(lerParametros.nextInt());
        
        System.out.println("\n");
        System.out.println("----> Parâmetros <----\n"
                         + "Etapas                  : " + parametros.getQtdEtapas()   + "\n"
                         + " Quantidade de Jogadores: " + parametros.getQtdJogadores()+ "\n"
                         + " Quantidade de Palavras : " + parametros.getQtdPalavras() + "\n\n");
        
        ControlePartida.iniciaPartida(parametros);
        
    }
}
