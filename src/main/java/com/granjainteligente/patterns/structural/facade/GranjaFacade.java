package com.granjainteligente.patterns.structural.facade;

import com.granjainteligente.models.Animal;
import com.granjainteligente.patterns.structural.facade.subsistemas.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Fachada que proporciona una interfaz simplificada para interactuar
 * con todos los subsistemas complejos de la granja.
 *
 * Patrón: Facade (Structural Pattern)
 * Propósito: Proporcionar una interfaz unificada para un conjunto de interfaces
 * en un subsistema. Define una interfaz de nivel superior que hace que el
 * subsistema sea más fácil de usar.
 */
@Slf4j
@Getter
public class GranjaFacade {

    // Subsistemas complejos
    private final SistemaAlimentacion sistemaAlimentacion;
    private final SistemaRiego sistemaRiego;
    private final SistemaMonitoreo sistemaMonitoreo;
    private final SistemaAlertas sistemaAlertas;

    // Registro de animales en la granja
    private final List<Animal> animalesRegistrados;

    public GranjaFacade() {
        log.info("===========================================");
        log.info("   INICIALIZANDO GRANJA INTELIGENTE");
        log.info("===========================================");

        this.sistemaAlimentacion = new SistemaAlimentacion();
        this.sistemaRiego = new SistemaRiego();
        this.sistemaMonitoreo = new SistemaMonitoreo();
        this.sistemaAlertas = new SistemaAlertas();
        this.animalesRegistrados = new ArrayList<>();

        log.info("✓ Todos los subsistemas inicializados correctamente");
    }

    // ==================== MÉTODOS SIMPLIFICADOS ====================

    /**
     * Alimenta a un animal específico de forma automática.
     * Coordina el sistema de alimentación, monitoreo y alertas.
     */
    public boolean alimentarAnimal(Animal animal, double cantidad) {
        log.info("\n--- Alimentando animal {} ---", animal.getId());

        // Verificar que el animal esté registrado
        if (!animalesRegistrados.contains(animal)) {
            log.warn("Animal no registrado en la granja");
            sistemaAlertas.enviarNotificacion("Intento de alimentar animal no registrado");
            return false;
        }

        // Intentar dispensar alimento
        boolean exito = sistemaAlimentacion.dispensarAlimento(animal, cantidad);

        if (exito) {
            sistemaAlertas.enviarNotificacion(
                    String.format("Animal %s alimentado con %.2f kg", animal.getId(), cantidad)
            );
            // Monitorear después de alimentar
            sistemaMonitoreo.monitorearAnimal(animal);
        } else {
            sistemaAlertas.enviarAlertaEmergencia(
                    "Falta de alimento para animal " + animal.getId()
            );
        }

        return exito;
    }

    /**
     * Alimenta a todos los animales de un corral específico.
     */
    public void alimentarCorral(String tipoCorral) {
        log.info("\n--- Alimentando corral: {} ---", tipoCorral);

        int alimentados = 0;
        int fallidos = 0;

        for (Animal animal : animalesRegistrados) {
            if (animal.getTipo().name().equals(tipoCorral)) {
                double cantidad = calcularCantidadAlimento(animal);
                boolean exito = sistemaAlimentacion.dispensarAlimento(animal, cantidad);

                if (exito) {
                    alimentados++;
                } else {
                    fallidos++;
                }
            }
        }

        String mensaje = String.format("Corral %s: %d animales alimentados, %d fallidos",
                tipoCorral, alimentados, fallidos);
        sistemaAlertas.enviarNotificacion(mensaje);

        if (fallidos > 0) {
            sistemaAlertas.enviarAlertaEmergencia("Alimento insuficiente para corral " + tipoCorral);
        }
    }

    /**
     * Activa el riego en una zona específica.
     */
    public boolean activarRiego(String zona) {
        log.info("\n--- Activando riego en {} ---", zona);

        boolean exito = sistemaRiego.activarRiego(zona);

        if (exito) {
            sistemaAlertas.enviarNotificacion("Riego activado en " + zona);
        } else {
            sistemaMonitoreo.generarAlerta(
                    SistemaMonitoreo.TipoAlerta.AGUA,
                    "No se pudo activar riego en " + zona,
                    SistemaMonitoreo.NivelAlerta.ALTA
            );
        }

        return exito;
    }

    /**
     * Desactiva el riego en una zona específica.
     */
    public boolean desactivarRiego(String zona) {
        log.info("\n--- Desactivando riego en {} ---", zona);

        boolean exito = sistemaRiego.desactivarRiego(zona);

        if (exito) {
            sistemaAlertas.enviarNotificacion("Riego desactivado en " + zona);
        }

        return exito;
    }

    /**
     * Registra un nuevo animal en la granja.
     * Activa monitoreo automático.
     */
    public void registrarAnimal(Animal animal) {
        animalesRegistrados.add(animal);
        log.info("Animal registrado: {} [{}]", animal.getId(), animal.getTipo());

        // Monitoreo inicial
        sistemaMonitoreo.monitorearAnimal(animal);

        sistemaAlertas.enviarNotificacion(
                String.format("Nuevo animal registrado: %s (%s)",
                        animal.getTipo(), animal.getId())
        );
    }

    /**
     * Realiza un chequeo completo de todos los animales.
     */
    public void realizarChequeoCompleto() {
        log.info("\n=== INICIANDO CHEQUEO COMPLETO DE LA GRANJA ===");

        sistemaAlertas.enviarNotificacion("Iniciando chequeo completo de la granja");

        for (Animal animal : animalesRegistrados) {
            sistemaMonitoreo.monitorearAnimal(animal);
        }

        int alertasPendientes = sistemaMonitoreo.obtenerAlertasPendientes().size();

        if (alertasPendientes > 0) {
            sistemaAlertas.enviarNotificacion(
                    String.format("Chequeo completado: %d alertas generadas", alertasPendientes)
            );
        } else {
            sistemaAlertas.enviarNotificacion("Chequeo completado: Todo en orden");
        }

        log.info("=== CHEQUEO COMPLETO FINALIZADO ===\n");
    }

    /**
     * Reabastecer recursos de la granja (alimento y agua).
     */
    public void reabastecerRecursos() {
        log.info("\n=== REABASTECIENDO RECURSOS ===");

        sistemaAlimentacion.reabastecerAlimento("FORRAJE", 2000.0);
        sistemaAlimentacion.reabastecerAlimento("CONCENTRADO", 1500.0);
        sistemaAlimentacion.reabastecerAlimento("MAIZ", 1000.0);

        sistemaRiego.rellenarTanque();

        sistemaAlertas.enviarNotificacion("Recursos reabastecidos exitosamente");
        log.info("=== REABASTECIMIENTO COMPLETADO ===\n");
    }

    /**
     * Obtiene un reporte completo del estado de la granja.
     */
    public String obtenerReporteCompleto() {
        StringBuilder reporte = new StringBuilder();

        reporte.append("\n╔════════════════════════════════════════════════╗\n");
        reporte.append("║     REPORTE COMPLETO DE LA GRANJA              ║\n");
        reporte.append("╚════════════════════════════════════════════════╝\n\n");

        // Animales registrados
        reporte.append("--- ANIMALES REGISTRADOS ---\n");
        reporte.append(String.format("Total: %d animales\n", animalesRegistrados.size()));
        for (Animal animal : animalesRegistrados) {
            reporte.append(String.format("  • %s\n", animal.obtenerInformacion()));
        }

        // Inventario de alimentos
        reporte.append("\n--- INVENTARIO DE ALIMENTOS ---\n");
        Map<String, Double> inventario = sistemaAlimentacion.obtenerInventario();
        inventario.forEach((tipo, cantidad) ->
                reporte.append(String.format("  • %s: %.2f kg\n", tipo, cantidad))
        );

        // Estado del riego
        reporte.append("\n--- SISTEMA DE RIEGO ---\n");
        reporte.append(sistemaRiego.obtenerEstadoZonas());
        reporte.append("\n");

        // Alertas
        reporte.append("\n--- ALERTAS ---\n");
        int pendientes = sistemaMonitoreo.obtenerAlertasPendientes().size();
        int total = sistemaMonitoreo.getAlertas().size();
        reporte.append(String.format("Total: %d | Pendientes: %d\n", total, pendientes));

        if (pendientes > 0) {
            reporte.append("\nAlertas pendientes:\n");
            sistemaMonitoreo.obtenerAlertasPendientes().forEach(alerta ->
                    reporte.append(String.format("  ⚠️  [%s] %s\n", alerta.getNivel(), alerta.getMensaje()))
            );
        }

        reporte.append("\n════════════════════════════════════════════════\n");

        return reporte.toString();
    }

    /**
     * Operación de emergencia: detiene todo y notifica.
     */
    public void emergencia(String motivo) {
        log.error("\n🚨 EMERGENCIA ACTIVADA: {}", motivo);

        // Desactivar todos los sistemas de riego
        sistemaRiego.getEstadoZonas().keySet().forEach(zona -> {
            if (sistemaRiego.getEstadoZonas().get(zona)) {
                sistemaRiego.desactivarRiego(zona);
            }
        });

        // Enviar alerta de emergencia
        sistemaAlertas.enviarAlertaEmergencia(motivo);

        log.error("Todos los sistemas detenidos. Requiere intervención manual.");
    }

    // ==================== MÉTODOS AUXILIARES ====================

    private double calcularCantidadAlimento(Animal animal) {
        // Cálculo simplificado: 2.5% del peso corporal
        return animal.getPeso() * 0.025;
    }

    public int getCantidadAnimales() {
        return animalesRegistrados.size();
    }
}
