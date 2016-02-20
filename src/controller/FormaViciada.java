package controller;

public class FormaViciada implements FormaSorteio {

    /**
     * Realiza o sorteio de forma viciada. Sempre retorna PASSA_VEZ
     * @param valores
     * @return 
     */
    @Override
    public EnumResultados realizaSorteio(EnumResultados [] valores) {
        return EnumResultados.PASSA_VEZ;
    }

}
