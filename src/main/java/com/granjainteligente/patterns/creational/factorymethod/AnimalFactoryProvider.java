package com.granjainteligente.patterns.creational.factorymethod;


import com.granjainteligente.models.TipoAnimal;

import java.util.EnumMap;
import java.util.Map;

/**
 * Proveedor central de fábricas concretas.
 * Cumple OCP: permite registrar nuevos tipos sin modificar código existente.
 */
public class AnimalFactoryProvider {

    private static final Map<TipoAnimal, AnimalFactory> FACTORIES = new EnumMap<>(TipoAnimal.class);

    static {
        FACTORIES.put(TipoAnimal.VACA, new CorralVacas());
        FACTORIES.put(TipoAnimal.CERDO, new CorralCerdo());
        FACTORIES.put(TipoAnimal.GALLINA, new CorralGallinas());
    }

    private AnimalFactoryProvider() {
        // Evita instanciación (utilidad estática)
    }

    public static AnimalFactory getFactory(TipoAnimal tipo) {
        AnimalFactory factory = FACTORIES.get(tipo);
        if (factory == null) {
            throw new IllegalArgumentException("No existe una fábrica registrada para el tipo: " + tipo);
        }
        return factory;
    }

}
