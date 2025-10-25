package com.granjainteligente.patterns.structural.adapter;

/**
 * Interfaz moderna del sistema de sensores.
 * Define el contrato que todos los sensores del sistema deben cumplir.
 */
public interface ISensor {

    /**
     * Obtiene la lectura actual del sensor.
     * @return Valor de la lectura del sensor
     */
    double obtenerLectura();

    /**
     * Obtiene el tipo de sensor.
     * @return Tipo de sensor (temperatura, humedad, nivel, etc.)
     */
    String obtenerTipo();

    /**
     * Obtiene el identificador único del sensor.
     * @return ID del sensor
     */
    String obtenerIdentificador();

    /**
     * Verifica si el sensor está funcionando correctamente.
     * @return true si el sensor está operativo, false en caso contrario
     */
    boolean estaOperativo();
}
