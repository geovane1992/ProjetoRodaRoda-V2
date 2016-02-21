package view;

import controller.ControlePartida;
import java.io.IOException;
import java.util.Scanner;
import model.Jogador;
import model.ParametrosIniciais;
import model.Roleta;



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
        
//        PalpiteLetra letra = new PalpiteLetra();
//        Observador jogador = new ControleJogador("Geovane ", letra);
//        letra.receberLetras("b");
//        Observador jogador1 = new ControleJogador("Geovane ", letra);
//        letra.receberLetras("a");
        
//        PalpitePalavra palavra = new PalpitePalavra();
//        Observador jogador2 = new ControleJogador("Geovane ", palavra);
//        palavra.receberPalavra("teste");
        
        
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
                         + " Quantidade de Etapas   : " + parametros.getQtdEtapas()   + "\n"
                         + " Quantidade de Jogadores: " + parametros.getQtdJogadores()+ "\n"
                         + " Quantidade de Palavras : " + parametros.getQtdPalavras() + "\n\n");
        
        ControlePartida.iniciaPartida(parametros);
        
//        Roleta roleta = new Roleta();
//        Jogador jogador = new Jogador();
//        jogador.setNome("Geovane");
//        for(int i = 0; i<3;i++){
//        System.out.println(roleta.roda(jogador));
//        }
        
    }
}
