package controller;

import java.util.List;

/** Declaração da classe FormaViciada
 * @author Geovane e José Sérgio
 * @version 2.0
 */
public class FormaViciada implements FormaSorteio {

    /**
     * Realiza o sorteio de forma viciada. Sempre retorna PASSA_VEZ
     * @param valores
     * @return o valor PASSA_VEZ
     */
    @Override
    public EnumResultados realizaSorteio(List<EnumResultados> valores) {
        return EnumResultados.PASSA_VEZ;
    }

}
