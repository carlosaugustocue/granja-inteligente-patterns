package com.granjainteligente.patterns.creational.singleton;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Representa un dispensador de alimento individual en la granja.
 * Gestiona el nivel de alimento, recargas y dispensación.
 */

@Slf4j
@Getter
@Setter
public class Dispensador {

    private final String id;
    private final double capacidad;
    private double nivelActual;
    private boolean activo;

    public Dispensador(String id, double capacidad) {
        this.id = id;
        this.capacidad = capacidad;
        this.nivelActual = capacidad;
        this.activo = true;
    }

    /**
     * Método sincronizado que dispensa una cantidad de alimento.
     *
     * La palabra clave 'synchronized' garantiza que solo un hilo
     * puede ejecutar este método al mismo tiempo sobre la misma instancia.
     * Esto evita inconsistencias si múltiples procesos intentan
     * modificar el nivel de alimento simultáneamente.
     *
     * @param cantidad Cantidad de alimento a dispensar (en kg)
     */
    public synchronized void dispensar(double cantidad) {
        if (!activo) {
            log.warn("✗ Dispensador {} está inactivo. No se puede dispensar alimento.", id);
            return;
        }

        if (nivelActual >= cantidad) {
            nivelActual -= cantidad;
            log.info("📦 Dispensador {} → {:.2f} kg dispensados. Restan {:.2f} kg",
                    id, cantidad, nivelActual);
        } else {
            log.warn("⚠️ Nivel insuficiente en dispensador {} (disponible: {:.2f} kg)",
                    id, nivelActual);
        }
    }

    /**
     * Recarga completamente el dispensador hasta su capacidad máxima.
     *
     * También está sincronizado para evitar que se recargue al mismo tiempo
     * que otro proceso intenta dispensar alimento.
     */
    public synchronized void recargar() {
        nivelActual = capacidad;
        log.info("🔄 Dispensador {} recargado a capacidad total ({:.2f} kg)", id, capacidad);
    }

    /**
     * Devuelve el porcentaje actual de ocupación del dispensador.
     *
     * @return Porcentaje (0 - 100)
     */
    public double getPorcentajeOcupacion() {
        return (nivelActual / capacidad) * 100.0;
    }


}
