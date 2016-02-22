package controller;

/** Classe responsável por realizar validações de string.
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class Validador {
    
    /** Método Valida se caracter é uma letra
     * @param caracter recebe caracter a ser validado.
     * @return se é letra ou não.
     */
    public static boolean validaSeELetra(String caracter){
        
        return caracter.contains("^[a-Z]");

    }
    
    /** Método Valida se caracter é um numero
     * @param caracter recebe caracter a ser validado.
     * @return se é numero ou não.
     */
    public static boolean validaSeENumero(String caracter){
        return caracter.matches("[0-9]+");

    }
    
}
