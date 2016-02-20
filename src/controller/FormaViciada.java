package controller;

import java.util.List;

public class FormaViciada implements FormaSorteio {

    /**
     * Realiza o sorteio de forma viciada. Sempre retorna PASSA_VEZ
     * @param valores
     * @return 
     */
    @Override
    public EnumResultados realizaSorteio(List<EnumResultados> valores) {
        return EnumResultados.PASSA_VEZ;
    }

}
