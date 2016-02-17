package model;

import java.util.ArrayList;


public class Etapa {

    private int etapa;
    private String[] Palavra;
    private Roleta roleta;
    private Rodada[] rodada;
    private ArrayList<String> lstPalavras;

    public int getEtapa() {
        return etapa;
    }

    public void setEtapa(int etapa) {
        this.etapa = etapa;
    }

    public String[] getPalavra() {
        return Palavra;
    }

    public void setPalavra(String[] Palavra) {
        this.Palavra = Palavra;
    }


    public Roleta getRoleta() {
        return roleta;
    }

    public void setRoleta(Roleta roleta) {
        this.roleta = roleta;
    }

    public Rodada[] getRodada() {
        return rodada;
    }

    public void setRodada(Rodada[] rodada) {
        this.rodada = rodada;
    }

    public ArrayList<String> getLstPalavras() {
        return lstPalavras;
    }

    public void setLstPalavras(ArrayList<String> lstPalavras) {
        this.lstPalavras = lstPalavras;
    }
    
    

}
