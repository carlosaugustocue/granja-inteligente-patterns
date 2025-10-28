package com.granjainteligente.patterns.creational.builder.interfaces;

import com.granjainteligente.patterns.creational.builder.model.Animal;

/**
 * Interfaz base que define los pasos para construir un {@link Animal}.
 * Cada Builder concreto implementará estos pasos con su propia lógica interna.
 */
public interface AnimalBuilder {

    AnimalBuilder setTipo(String tipo);
    AnimalBuilder setRaza(String raza);
    AnimalBuilder setEdad(int edad);
    AnimalBuilder setPeso(double peso);
    AnimalBuilder setDescripcion(String descripcion);

    /**
     * Devuelve el producto completamente construido.
     * @return instancia de {@link Animal}
     */
    Animal build();
}