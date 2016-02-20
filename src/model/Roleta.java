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

public class Roleta {

    private List<EnumResultados> valores;// Setar os valores aqui
    private Map<Jogador, Integer> contadorJogadas; //para contar as jogadas de cada jogador
    private FormaSorteio formaSorteio;
    
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
    
    
    /**
     * Adiciona uma jogada ao mapa de jogadas e retorna qual o numero da jogada.
     * @param jogador A rolar a roleta
     * @return quantidade de jogadas do jogador, inclusive esta.
     */
    private Integer contabilizaJogas(Jogador jogador)
    {
        contadorJogadas.put(jogador, 1);
        return contadorJogadas.get(jogador);
    }
    
    
}
