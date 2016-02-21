package controller;

/**
 * Interface para implementação do padrão Observer
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public interface Observado {
    
    public void incluirObservador(Observador obs);
    public void removerObservador(Observador obs);
    public void notificarObservadores();
    
}
