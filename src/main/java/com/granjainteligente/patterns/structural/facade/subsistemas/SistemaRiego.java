package com.granjainteligente.patterns.structural.facade.subsistemas;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Subsistema complejo que gestiona el riego de las diferentes zonas.
 */
@Slf4j
@Getter
public class SistemaRiego {

    private final Map<String, Boolean> estadoZonas;
    private double nivelTanque; // en litros
    private final double capacidadTanque = 50000.0; // 50,000 litros

    public SistemaRiego() {
        this.estadoZonas = new HashMap<>();
        this.nivelTanque = capacidadTanque * 0.75; // 75% lleno inicialmente
        inicializarZonas();
    }

    private void inicializarZonas() {
        estadoZonas.put("ZONA_VACAS", false);
        estadoZonas.put("ZONA_CERDOS", false);
        estadoZonas.put("ZONA_GALLINAS", false);
        estadoZonas.put("ZONA_CULTIVOS", false);
        log.info("Sistema de riego inicializado. Tanque: {} L", nivelTanque);
    }

    public boolean activarRiego(String zona) {
        if (!estadoZonas.containsKey(zona)) {
            log.error("Zona desconocida: {}", zona);
            return false;
        }

        if (estadoZonas.get(zona)) {
            log.warn("El riego en {} ya está activo", zona);
            return false;
        }

        if (nivelTanque < 1000) {
            log.error("Nivel de agua insuficiente para activar riego en {}", zona);
            return false;
        }

        estadoZonas.put(zona, true);
        log.info("✓ Riego activado en {}", zona);
        return true;
    }

    public boolean desactivarRiego(String zona) {
        if (!estadoZonas.containsKey(zona)) {
            log.error("Zona desconocida: {}", zona);
            return false;
        }

        if (!estadoZonas.get(zona)) {
            log.warn("El riego en {} ya está inactivo", zona);
            return false;
        }

        estadoZonas.put(zona, false);
        // Simular consumo de agua
        nivelTanque -= 500;
        log.info("✓ Riego desactivado en {}. Agua restante: {} L", zona, nivelTanque);
        return true;
    }

    public void rellenarTanque() {
        nivelTanque = capacidadTanque;
        log.info("Tanque de agua rellenado a capacidad máxima: {} L", capacidadTanque);
    }

    public String obtenerEstadoZonas() {
        StringBuilder sb = new StringBuilder("Estado del sistema de riego:\n");
        estadoZonas.forEach((zona, activo) ->
                sb.append(String.format("  - %s: %s\n", zona, activo ? "ACTIVO" : "INACTIVO"))
        );
        sb.append(String.format("  - Nivel tanque: %.2f L / %.2f L (%.1f%%)",
                nivelTanque, capacidadTanque, (nivelTanque / capacidadTanque) * 100));
        return sb.toString();
    }
}
