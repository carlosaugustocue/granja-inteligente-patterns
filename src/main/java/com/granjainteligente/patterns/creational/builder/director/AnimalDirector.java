package com.granjainteligente.patterns.creational.builder.director;

import com.granjainteligente.patterns.creational.builder.interfaces.AnimalBuilder;
import com.granjainteligente.patterns.creational.builder.model.Animal;

/**
 * Director que orquesta la construcción de un {@link Animal}.
 * No requiere el tipo: lo fija el builder concreto.
 */
public class AnimalDirector {

    public Animal construirAnimal(AnimalBuilder builder, String raza,
                                  int edad, double peso, String descripcion) {
        return builder
                .setRaza(raza)
                .setEdad(edad)
                .setPeso(peso)
                .setDescripcion(descripcion)
                .build();
    }
}