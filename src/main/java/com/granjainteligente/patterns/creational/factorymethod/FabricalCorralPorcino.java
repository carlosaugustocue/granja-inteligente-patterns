package com.granjainteligente.patterns.creational.factorymethod;

import com.granjainteligente.models.Animal;
import com.granjainteligente.models.Cerdo;

public class FabricalCorralPorcino extends AnimalFactory {

    // --- Constantes para evitar "Magic Numbers" ---
    private static final double PESO_INICIAL_CERDO_KG = 80.0;
    private static final int EDAD_INICIAL_CERDO_MESES = 6;
    private static final boolean ES_REPRODUCTOR_POR_DEFECTO = false;

    /**
     * Crea una instancia de cerdo optimizado para engorde.
     */

    @Override
    public Animal crearAnimal(String raza) {
        return new Cerdo(
                PESO_INICIAL_CERDO_KG,
                EDAD_INICIAL_CERDO_MESES,
                raza,
                ES_REPRODUCTOR_POR_DEFECTO
        );
    }
}
