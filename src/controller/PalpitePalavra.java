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
    
    /** Construtor da classe PalpitePalavra
     */
    public PalpitePalavra(){
        this.observadores = new ArrayList<>();
        this.listaPalavras = new ArrayList<>();
    }
    
    /**Méodo responsável por receber palavra digitada e adicionar a uma lista de palavras
     * e chamar o notificador.
     * @param palavra recebe palavra digitada.
     */
    public void receberPalavra(String palavra){
        this.listaPalavras.add(palavra);
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
            observador.updatePalavra(this.listaPalavras.get(this.listaPalavras.size()-1));
        }
    }


}
