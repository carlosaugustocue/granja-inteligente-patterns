package com.granjainteligente.patterns.structural.facade.subsistemas;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Subsistema que gestiona el envío de notificaciones y alertas.
 */
@Slf4j
public class SistemaAlertas {

    private final List<String> notificaciones;
    private boolean notificacionesActivas;

    public SistemaAlertas() {
        this.notificaciones = new ArrayList<>();
        this.notificacionesActivas = true;
        log.info("Sistema de alertas inicializado");
    }

    public void enviarNotificacion(String mensaje) {
        if (!notificacionesActivas) {
            log.debug("Notificaciones desactivadas. Mensaje no enviado: {}", mensaje);
            return;
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String notificacion = String.format("[%s] %s", timestamp, mensaje);
        notificaciones.add(notificacion);

        log.info("📧 Notificación enviada: {}", mensaje);
    }

    public void enviarAlertaEmergencia(String mensaje) {
        String notificacionEmergencia = String.format("🚨 EMERGENCIA: %s", mensaje);
        enviarNotificacion(notificacionEmergencia);
        // Simular envío por múltiples canales
        log.error("ALERTA DE EMERGENCIA ENVIADA POR TODOS LOS CANALES");
    }

    public void activarNotificaciones() {
        this.notificacionesActivas = true;
        log.info("Notificaciones ACTIVADAS");
    }

    public void desactivarNotificaciones() {
        this.notificacionesActivas = false;
        log.info("Notificaciones DESACTIVADAS");
    }

    public List<String> obtenerHistorialNotificaciones() {
        return new ArrayList<>(notificaciones);
    }

    public void limpiarHistorial() {
        notificaciones.clear();
        log.info("Historial de notificaciones limpiado");
    }
}
