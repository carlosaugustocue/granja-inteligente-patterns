package com.granjainteligente.patterns.creational.factorymethod;

import com.granjainteligente.models.Animal;
import com.granjainteligente.models.Gallina;

public class FabricaCorralHuevos extends AnimalFactory {

    // --- Constantes para evitar "Magic Numbers" y "Magic Strings" ---
    private static final double PESO_INICIAL_GALLINA_KG = 2.0;
    private static final int EDAD_INICIAL_GALLINA_MESES = 5;
    private static final boolean ES_PONEDORA_POR_DEFECTO = true;
    private static final String COLOR_PLUMAJE_POR_DEFECTO = "Marrón";

    @Override
    public Animal crearAnimal(String raza) {
        return new Gallina(
                PESO_INICIAL_GALLINA_KG,
                EDAD_INICIAL_GALLINA_MESES,
                raza,
                ES_PONEDORA_POR_DEFECTO,
                COLOR_PLUMAJE_POR_DEFECTO
        );
    }

}
