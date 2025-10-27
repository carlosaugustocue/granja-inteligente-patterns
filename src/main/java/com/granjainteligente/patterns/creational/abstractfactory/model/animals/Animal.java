package com.granjainteligente.patterns.creational.abstractfactory.model.animals;

/**
 * Interfaz base para todos los animales de la granja.
 * Define los métodos esenciales que deben implementar todas las especies de animales.
 *
 * Métodos:
 * - getTipo(): devuelve el tipo general del animal (ej. Vaca, Cerdo, Gallina).
 * - getRaza(): devuelve la raza específica del animal (ej. Holstein, Yorkshire).
 * - getDescripcion(): devuelve una descripción detallada del animal, sus características o rol en la granja.
 */
public interface Animal {
    String getTipo();
    String getRaza();
    String getDescripcion();
}