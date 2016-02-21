package controller;

import java.util.List;

/**
 * Interface para implementação do padrão Strategy
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public interface FormaSorteio {

    /**
     * Realiza o sorteio tomando como base um vetor de inteiro.
     * @param valores dentro os quais um será sorteado.
     * @return um dos valores selecionados.
     */
    public EnumResultados realizaSorteio(List<EnumResultados> valores);
}
