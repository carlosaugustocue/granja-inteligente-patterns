package com.granjainteligente.patterns.creational.builder.interfaces;

import com.granjainteligente.patterns.creational.builder.model.Animal;

/**
 * Interfaz base que define los pasos fluent para construir un {@link Animal}.
 * NOTA: no contiene setTipo(), el tipo lo define el builder concreto.
 */
public interface AnimalBuilder {
    AnimalBuilder setRaza(String raza);
    AnimalBuilder setEdad(int edad);
    AnimalBuilder setPeso(double peso);
    AnimalBuilder setDescripcion(String descripcion);
    Animal build();
}