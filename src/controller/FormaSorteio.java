package controller;

import java.util.List;

/**
 * Interface para implementação do padrão Strategy
 * @author Vinicius
 */
public interface FormaSorteio {

    /**
     * Realiza o sorteio tomando como base um vetor de inteiro.
     * @param valores dentro os quais um será sorteado.
     * @return um dos valores selecionados.
     */
    public EnumResultados realizaSorteio(List<EnumResultados> valores);
}
