package controller;

import java.util.ArrayList;
import java.util.List;

/** Declaração da classe PalpiteLetra
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class PalpiteLetra implements Observado {

    private List<Observador> observadores;
    private List<String> letrasSelecionada;
    
    public PalpiteLetra(){
        this.observadores = new ArrayList<>();
        this.letrasSelecionada = new ArrayList<>();
    }
    
    public void receberLetras(String letra){
        this.letrasSelecionada.add(letra);
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
            observador.updateLetra(this.letrasSelecionada.get(this.letrasSelecionada.size()-1));
        }
    }

}
