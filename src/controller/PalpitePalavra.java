package controller;

import java.util.ArrayList;
import java.util.List;

/** Declaração da classe PalpitePalavra
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class PalpitePalavra implements Observado {

    private List<Observador> observadores;
    private List<String> listaPalavras;
    
    public PalpitePalavra(){
        this.observadores = new ArrayList<>();
        this.listaPalavras = new ArrayList<>();
    }
    
    public void receberPalavra(String palavra){
        this.listaPalavras.add(palavra);
        this.notificarObservadores();
    }

    @Override
    public void incluirObservador(Observador obs) {
        this.observadores.add(obs);
    }

    @Override
    public void removerObservador(Observador obs) {
        int id = this.observadores.indexOf(obs);
        if(id >= 0){
            this.observadores.remove(obs);
        }
    }

    @Override
    public void notificarObservadores() {
        for(Observador observador : observadores){
            observador.updatePalavra(this.listaPalavras.get(this.listaPalavras.size()-1));
        }
    }


}
