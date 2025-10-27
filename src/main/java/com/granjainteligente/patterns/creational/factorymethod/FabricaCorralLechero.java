package com.granjainteligente.patterns.creational.factorymethod;

import com.granjainteligente.models.Animal;
import com.granjainteligente.models.Vaca;

public class FabricaCorralLechero extends AnimalFactory{

    // --- Constantes para evitar "Magic Numbers" ---
    private static final double PESO_INICIAL_VACA_KG = 450.0;
    private static final int EDAD_INICIAL_VACA_MESES = 24;
    private static final boolean ES_LECHERA_POR_DEFECTO = true;

    @Override
    public Animal crearAnimal(String raza) {

        return new Vaca(
                PESO_INICIAL_VACA_KG,
                EDAD_INICIAL_VACA_MESES,
                raza,
                ES_LECHERA_POR_DEFECTO
        );
    }

}
