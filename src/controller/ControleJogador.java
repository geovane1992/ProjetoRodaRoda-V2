
package controller;

import java.util.List;

/** Declaração da classe ControleJogador.
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class ControleJogador  implements Observador{
    
    String nome;
    
    public ControleJogador(String nome, Observado obs){
        this.nome = nome;
        obs.incluirObservador(this);
    }

    @Override
    public void updateLetra(String letra) {
        System.out.println(this.nome + " escolheu a letra " + letra);
    }

    @Override
    public void updatePalavra(String palavra) {
        System.out.println(this.nome + " informou a palavra " + palavra);
    }
    
}
