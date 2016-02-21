package controller;

/**
 * Interface para implementação do padrão Observer
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public interface Observador {

    public void updateLetra(String letra);
    public void updatePalavra(String palavra);
}
