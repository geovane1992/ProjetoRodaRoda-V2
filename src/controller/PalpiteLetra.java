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
    
    /** Construtor da classe PalpiteLetra
     */
    public PalpiteLetra(){
        this.observadores = new ArrayList<>();
        this.letrasSelecionada = new ArrayList<>();
    }
    
    /**Méodo responsável por receber letra digitada e adicionar a uma lista de letras
     * e chamar o notificador.
     * @param letra recebe letra digitada
     */
    public void receberLetras(String letra){
        this.letrasSelecionada.add(letra);
        this.notificarObservadores();
    }

    /** Método responável por incluir observador a lista de observadores.
     * @param obs recebe objeto observador
     */
    @Override
    public void incluirObservador(Observador obs) {
        this.observadores.add(obs);
    }

    /** Método responável por remover observador da lista de observadores.
     * @param obs recebe objeto observador
     */
    @Override
    public void removerObservador(Observador obs) {
        int id = this.observadores.indexOf(obs);
        if(id >= 0){
            this.observadores.remove(obs);
        }
    }

    /** Método responável por notificar observadores com as modificações do observado.
     */
    @Override
    public void notificarObservadores() {
        for(Observador observador : observadores){
            observador.updateLetra(this.letrasSelecionada.get(this.letrasSelecionada.size()-1));
        }
    }

}
