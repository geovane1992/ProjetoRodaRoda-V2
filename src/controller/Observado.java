package controller;

public interface Observado {
    
    public void incluirObservador(Observador obs);
    public void removerObservador(Observador obs);
    public void notificarObservadores();
    
}
