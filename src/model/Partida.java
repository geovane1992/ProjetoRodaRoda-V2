package model;


import model.Jogador;
import model.Etapa;


public class Partida {

    private Etapa etapa;
    private Jogador jogador;
    private Jogador[] lstJogador;
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

    public Jogador[] getLstJogador() {
        return lstJogador;
    }

    public void setLstJogador(Jogador[] lstJogador) {
        this.lstJogador = lstJogador;
    }

    public Etapa[] getLstEtapa() {
        return lstEtapa;
    }

    public void setLstEtapa(Etapa[] lstEtapa) {
        this.lstEtapa = lstEtapa;
    }

}
