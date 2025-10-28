package com.granjainteligente.patterns.creational.builder.director;

import com.granjainteligente.patterns.creational.builder.interfaces.AnimalBuilder;
import com.granjainteligente.patterns.creational.builder.model.Animal;

/**
 * Clase Director que define el orden de construcción del producto.
 * No conoce los detalles internos del Builder, solo coordina el proceso.
 */
public class AnimalDirector {

    /**
     * Construye un animal siguiendo un orden lógico de pasos.
     *
     * @param builder instancia concreta de {@link AnimalBuilder}
     * @param tipo tipo de animal
     * @param raza raza o especie
     * @param edad edad en años
     * @param peso peso en kilogramos
     * @param descripcion breve descripción del animal
     * @return objeto {@link Animal} completamente construido
     */
    public Animal construirAnimal(AnimalBuilder builder, String tipo, String raza,
                                  int edad, double peso, String descripcion) {
        return builder
                .setTipo(tipo)
                .setRaza(raza)
                .setEdad(edad)
                .setPeso(peso)
                .setDescripcion(descripcion)
                .build();
    }
}