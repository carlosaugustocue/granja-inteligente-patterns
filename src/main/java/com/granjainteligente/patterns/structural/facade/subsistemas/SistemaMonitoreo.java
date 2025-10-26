package com.granjainteligente.patterns.structural.facade.subsistemas;

import com.granjainteligente.models.Animal;
import com.granjainteligente.models.EstadoSalud;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Subsistema complejo que monitorea el estado de los animales y genera alertas.
 */
@Slf4j
@Getter
public class SistemaMonitoreo {

    private final List<Alerta> alertas;
    private boolean monitoreoActivo;

    public SistemaMonitoreo() {
        this.alertas = new ArrayList<>();
        this.monitoreoActivo = true;
        log.info("Sistema de monitoreo inicializado y activo");
    }

    public void monitorearAnimal(Animal animal) {
        if (!monitoreoActivo) {
            log.warn("Sistema de monitoreo desactivado");
            return;
        }

        log.debug("Monitoreando animal: {}", animal.getId());

        // Verificar estado de salud
        if (animal.getEstadoSalud() != EstadoSalud.SANO) {
            generarAlerta(
                    TipoAlerta.SALUD,
                    String.format("Animal %s presenta estado: %s",
                            animal.getId(), animal.getEstadoSalud()),
                    NivelAlerta.ALTA
            );
        }

        // Verificar peso anormal
        if (animal.getPeso() < 10) {
            generarAlerta(
                    TipoAlerta.PESO,
                    String.format("Animal %s tiene peso muy bajo: %.2f kg",
                            animal.getId(), animal.getPeso()),
                    NivelAlerta.MEDIA
            );
        }

        // Verificar edad
        if (animal.getEdad() > 120) { // Más de 10 años
            generarAlerta(
                    TipoAlerta.EDAD,
                    String.format("Animal %s ha alcanzado edad avanzada: %d meses",
                            animal.getId(), animal.getEdad()),
                    NivelAlerta.BAJA
            );
        }
    }

    public void generarAlerta(TipoAlerta tipo, String mensaje, NivelAlerta nivel) {
        Alerta alerta = new Alerta(tipo, mensaje, nivel, LocalDateTime.now());
        alertas.add(alerta);

        String emoji = switch (nivel) {
            case ALTA -> "🔴";
            case MEDIA -> "🟡";
            case BAJA -> "🟢";
        };

        log.warn("{} ALERTA {}: {} - {}", emoji, nivel, tipo, mensaje);
    }

    public List<Alerta> obtenerAlertasPendientes() {
        return alertas.stream()
                .filter(a -> !a.resuelta)
                .toList();
    }

    public void resolverAlerta(int index) {
        if (index >= 0 && index < alertas.size()) {
            alertas.get(index).resolver();
            log.info("Alerta #{} resuelta", index);
        }
    }

    public void limpiarAlertas() {
        int cantidadResueltas = (int) alertas.stream().filter(a -> a.resuelta).count();
        alertas.removeIf(a -> a.resuelta);
        log.info("{} alertas resueltas eliminadas del sistema", cantidadResueltas);
    }

    public String obtenerReporteAlertas() {
        StringBuilder sb = new StringBuilder("=== REPORTE DE ALERTAS ===\n");
        sb.append(String.format("Total: %d | Pendientes: %d\n\n",
                alertas.size(), obtenerAlertasPendientes().size()));

        if (alertas.isEmpty()) {
            sb.append("No hay alertas registradas.\n");
        } else {
            for (int i = 0; i < alertas.size(); i++) {
                Alerta alerta = alertas.get(i);
                sb.append(String.format("[%d] %s - %s: %s\n    Fecha: %s | Estado: %s\n",
                        i,
                        alerta.nivel,
                        alerta.tipo,
                        alerta.mensaje,
                        alerta.timestamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                        alerta.resuelta ? "RESUELTA" : "PENDIENTE"
                ));
            }
        }
        return sb.toString();
    }

    public void activarMonitoreo() {
        this.monitoreoActivo = true;
        log.info("Sistema de monitoreo ACTIVADO");
    }

    public void desactivarMonitoreo() {
        this.monitoreoActivo = false;
        log.info("Sistema de monitoreo DESACTIVADO");
    }

    // Clases internas
    public enum TipoAlerta {
        SALUD, PESO, EDAD, TEMPERATURA, HUMEDAD, ALIMENTO, AGUA
    }

    public enum NivelAlerta {
        BAJA, MEDIA, ALTA
    }

    @Getter
    public static class Alerta {
        private final TipoAlerta tipo;
        private final String mensaje;
        private final NivelAlerta nivel;
        private final LocalDateTime timestamp;
        private boolean resuelta;

        public Alerta(TipoAlerta tipo, String mensaje, NivelAlerta nivel, LocalDateTime timestamp) {
            this.tipo = tipo;
            this.mensaje = mensaje;
            this.nivel = nivel;
            this.timestamp = timestamp;
            this.resuelta = false;
        }

        public void resolver() {
            this.resuelta = true;
        }
    }
}
