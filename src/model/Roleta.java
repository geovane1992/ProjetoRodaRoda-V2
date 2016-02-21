package model;

import controller.EnumResultados;
import controller.FormaAleatoria;
import controller.FormaSorteio;
import controller.FormaViciada;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Declaração da classe Roleta
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class Roleta {

    private List<EnumResultados> valores;// Setar os valores aqui
    private Map<Jogador, Integer> contadorJogadas; //para contar as jogadas de cada jogador
    private FormaSorteio formaSorteio;
    
    /** Construtor da classe Roleta, armazena a quantidade de jogadas de cada jogador e cria uma
     * lista de valores da roleta.
     */
    public Roleta()
    {
        contadorJogadas = new LinkedHashMap<>();  
        //adiciona os valores ao mapa de resultados.
        valores = new ArrayList<>();
        valores.add(EnumResultados.PASSA_VEZ);
        valores.add(EnumResultados.PASSA_VEZ);
        valores.add(EnumResultados.PERDE_TUDO);
        valores.add(EnumResultados.PERDE_TUDO);
        valores.add(EnumResultados.PONTOS_100);
        valores.add(EnumResultados.PONTOS_100);
        valores.add(EnumResultados.PONTOS_100);
        valores.add(EnumResultados.PONTOS_100);
        valores.add(EnumResultados.PONTOS_200);
        valores.add(EnumResultados.PONTOS_200);
        valores.add(EnumResultados.PONTOS_200);
        valores.add(EnumResultados.PONTOS_200);
        valores.add(EnumResultados.PONTOS_400);
        valores.add(EnumResultados.PONTOS_400);
        valores.add(EnumResultados.PONTOS_400);
        valores.add(EnumResultados.PONTOS_400);
        valores.add(EnumResultados.PONTOS_500);
        valores.add(EnumResultados.PONTOS_500);
        valores.add(EnumResultados.PONTOS_1000);
        valores.add(EnumResultados.PONTOS_1000);       
        
    }
    
    /** Método responsável por definir qual será a forma se sorteio da roleta.
     * @param jogador parametro responsável por receber o jogador que irá rodar a roleta.
     * @return forma de sorteio da roleta, aleatorio ou viaciado
     */
    public EnumResultados roda(Jogador jogador)
    {
        int i = contabilizaJogas(jogador);
        
        if(i == 2){
            formaSorteio = new FormaViciada();
        }else{
            formaSorteio = new FormaAleatoria();
        }
               
        return formaSorteio.realizaSorteio(valores);
    }
    
    
    /**Adiciona uma jogada ao mapa de jogadas e retorna qual o numero da jogada.
     * @param jogador A rolar a roleta
     * @return quantidade de jogadas do jogador, inclusive esta.
     */
    private Integer contabilizaJogas(Jogador jogador)
    {
        int i = 0 ;
        
        if(contadorJogadas.containsKey(jogador))        {
            i = contadorJogadas.get(jogador);
        }
                
        contadorJogadas.put(jogador, i + 1);
        return contadorJogadas.get(jogador);
    }
    
    
}
