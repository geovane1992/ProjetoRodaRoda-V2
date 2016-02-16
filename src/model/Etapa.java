package model;


public class Etapa {

    private String Palavra;
    private Roleta roleta;
    private Rodada[] rodada;

    public String getPalavra() {
        return Palavra;
    }

    public void setPalavra(String Palavra) {
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

}
