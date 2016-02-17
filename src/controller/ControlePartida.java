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
    
        for(int jogadores = 0; jogadores < paramtros.getQtdJogadores(); jogadores++ ){
            Jogador jogador = new Jogador();
            jogador.setNome("Jogador" + jogadores); 
            lJogadores.add(jogador);
        }
        partida.setLstJogador(lJogadores);
        
        for(int etapas = 0; etapas < paramtros.getQtdEtapas(); etapas++){
            ControleEtapa.iniciaEtapa(paramtros);
        }
        
    }
    
}
