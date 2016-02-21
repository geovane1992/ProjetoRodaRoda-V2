package controller;
import model.Partida;
import java.io.IOException;
import java.util.ArrayList;
import model.Jogador;
import model.ParametrosIniciais;

/** Declaração da classe ControlePartida
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class ControlePartida {

    /** Método resposável por iniciar a partida chamando as etapas.
     * @param paramtros recebe objeto com os parametros iniciais do jogo.
     * @throws java.io.IOException informa possíveis erros da leitura do arquivo de palavras
     */
    public static void iniciaPartida(ParametrosIniciais paramtros) throws IOException{
    Partida partida = new Partida();
    ArrayList<Jogador> lJogadores = new ArrayList<>();
    int etapa;
    
        for(int jogadores = 0; jogadores < paramtros.getQtdJogadores(); jogadores++ ){
            Jogador jogador = new Jogador();
            jogador.setNome("Jogador" + jogadores); 
            lJogadores.add(jogador);
        }
        partida.setLstJogador(lJogadores);
        
        for(etapa = 1; etapa <= paramtros.getQtdEtapas(); etapa++){
            ControleEtapa.iniciaEtapa(paramtros, etapa);
            
        }
        
    }
    
}
