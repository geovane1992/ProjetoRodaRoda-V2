package controller;
import model.Partida;
import java.io.IOException;
import java.util.ArrayList;
import model.Jogador;
import model.ParametrosIniciais;

/**
 *
 * @author GAOliveira
 */
public class ControlePartida {

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
