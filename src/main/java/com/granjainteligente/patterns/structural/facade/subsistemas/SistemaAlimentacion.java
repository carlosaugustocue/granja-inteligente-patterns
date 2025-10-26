package com.granjainteligente.patterns.structural.facade.subsistemas;

import com.granjainteligente.models.Animal;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Subsistema complejo que gestiona la alimentación de los animales.
 */
@Slf4j
public class SistemaAlimentacion {

    private final Map<String, Double> inventarioAlimento;
    private double capacidadMaxima;

    public SistemaAlimentacion() {
        this.inventarioAlimento = new HashMap<>();
        this.capacidadMaxima = 10000.0; // 10 toneladas
        inicializarInventario();
    }

    private void inicializarInventario() {
        inventarioAlimento.put("FORRAJE", 5000.0);
        inventarioAlimento.put("CONCENTRADO", 3000.0);
        inventarioAlimento.put("MAIZ", 2000.0);
        log.info("Sistema de alimentación inicializado con inventario completo");
    }

    public boolean dispensarAlimento(Animal animal, double cantidad) {
        String tipoAlimento = obtenerTipoAlimentoPorAnimal(animal);

        if (!verificarDisponibilidad(tipoAlimento, cantidad)) {
            log.warn("Alimento insuficiente. Tipo: {}, Requerido: {} kg", tipoAlimento, cantidad);
            return false;
        }

        double disponible = inventarioAlimento.get(tipoAlimento);
        inventarioAlimento.put(tipoAlimento, disponible - cantidad);

        animal.alimentar(cantidad);
        log.info("Alimento dispensado: {} kg de {} para animal {}",
                cantidad, tipoAlimento, animal.getId());
        return true;
    }

    public boolean verificarDisponibilidad(String tipoAlimento, double cantidad) {
        return inventarioAlimento.getOrDefault(tipoAlimento, 0.0) >= cantidad;
    }

    public void reabastecerAlimento(String tipo, double cantidad) {
        double actual = inventarioAlimento.getOrDefault(tipo, 0.0);
        double nuevo = Math.min(actual + cantidad, capacidadMaxima);
        inventarioAlimento.put(tipo, nuevo);
        log.info("Reabastecimiento: {} kg de {} agregados. Total: {} kg",
                cantidad, tipo, nuevo);
    }

    public Map<String, Double> obtenerInventario() {
        return new HashMap<>(inventarioAlimento);
    }

    private String obtenerTipoAlimentoPorAnimal(Animal animal) {
        return switch (animal.getTipo()) {
            case VACA -> "FORRAJE";
            case CERDO -> "CONCENTRADO";
            case GALLINA -> "MAIZ";
            default -> "CONCENTRADO";
        };
    }
}
