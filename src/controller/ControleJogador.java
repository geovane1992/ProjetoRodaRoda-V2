
package controller;

import java.util.List;

/** Declaração da classe ControleJogador.
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class ControleJogador  implements Observador{
    
    String nome;
    
    /** Construtor da classe ControleJogador
     * @param nome recebe nome do jogador
     * @param obs recebe objeto observado
     */
    public ControleJogador(String nome, Observado obs){
        this.nome = nome;
        obs.incluirObservador(this);
    }

    /** Método responsável por imprimir qual letra o jogador escolheu
     * @param letra letra escolhida
     */
    @Override
    public void updateLetra(String letra) {
        System.out.println(this.nome + " escolheu a letra " + letra);
    }

    /** Método responsável por imprimir qual palavra o jogador escolheu
     * @param palavra  palavra escolhida
     */
    @Override
    public void updatePalavra(String palavra) {
        System.out.println(this.nome + " informou a palavra " + palavra);
    }
    
}
