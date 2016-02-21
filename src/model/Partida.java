package model;


import java.util.ArrayList;

/** Declaração da classe Partida
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class Partida {

    private Etapa etapa;
    private Jogador jogador;
    private ArrayList<Jogador> lstJogador;
    private Etapa[] lstEtapa;

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public ArrayList<Jogador> getLstJogador() {
        return lstJogador;
    }

    public void setLstJogador(ArrayList<Jogador> lstJogador) {
        this.lstJogador = lstJogador;
    }

    

    public Etapa[] getLstEtapa() {
        return lstEtapa;
    }

    public void setLstEtapa(Etapa[] lstEtapa) {
        this.lstEtapa = lstEtapa;
    }

}
