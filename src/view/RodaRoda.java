package view;

import controller.ControlePartida;
import java.io.IOException;
import java.util.Scanner;
import model.Jogador;
import model.ParametrosIniciais;
import model.Roleta;



/** Classe responsável por inicializar a aplicação Roda Roda
 *
 * @author Geovane
 * @author José Sérgio
 * @version 2.0
 *
 */
public class RodaRoda {

    /** Metodo Principal, responsável por chamar o menu inicial.
     * @param args  arqumento.
     * @throws java.io.IOException retorna erros da leitura do arquivo de palavras.
    */
    public static void main(String[] args) throws IOException{
        menu();        
    }
    
    /** Método responsável por capturar os parametros iniciais do jogo e construir o menu.
     * 
     * @throws java.io.IOException retorna erros da leitura do arquivo de palavras.
     */
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
                         + " Quantidade de Etapas   : " + parametros.getQtdEtapas()   + "\n"
                         + " Quantidade de Jogadores: " + parametros.getQtdJogadores()+ "\n"
                         + " Quantidade de Palavras : " + parametros.getQtdPalavras() + "\n\n");
        
        ControlePartida.iniciaPartida(parametros);
        
    }
}
