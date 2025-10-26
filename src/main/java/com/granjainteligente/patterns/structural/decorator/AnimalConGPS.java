package com.granjainteligente.patterns.structural.decorator;

import com.granjainteligente.models.Animal;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Decorador que añade funcionalidad de rastreo GPS a un animal.
 * Permite registrar y consultar la ubicación del animal.
 */
@Slf4j
@Getter
public class AnimalConGPS extends AnimalDecorator {

    private Coordenadas ubicacionActual;
    private final List<RegistroUbicacion> historialUbicaciones;
    private boolean gpsActivo;

    public AnimalConGPS(Animal animalDecorado) {
        super(animalDecorado);
        this.historialUbicaciones = new ArrayList<>();
        this.gpsActivo = true;
        // Ubicación inicial por defecto (centro de la granja)
        this.ubicacionActual = new Coordenadas(0.0, 0.0);
        registrarUbicacion();
        log.info("Decorador GPS aplicado al animal: {}", animalDecorado.getId());
    }

    /**
     * Actualiza la ubicación actual del animal.
     * @param latitud Latitud de la nueva ubicación
     * @param longitud Longitud de la nueva ubicación
     */
    public void actualizarUbicacion(double latitud, double longitud) {
        if (!gpsActivo) {
            log.warn("GPS inactivo para el animal {}. No se puede actualizar ubicación.", getId());
            return;
        }

        this.ubicacionActual = new Coordenadas(latitud, longitud);
        registrarUbicacion();
        log.info("Ubicación actualizada para animal {}: ({}, {})",
                getId(), latitud, longitud);
    }

    /**
     * Registra la ubicación actual en el historial.
     */
    private void registrarUbicacion() {
        RegistroUbicacion registro = new RegistroUbicacion(
                ubicacionActual.latitud,
                ubicacionActual.longitud,
                LocalDateTime.now()
        );
        historialUbicaciones.add(registro);
    }

    /**
     * Calcula la distancia desde una ubicación específica.
     * @param latitud Latitud de referencia
     * @param longitud Longitud de referencia
     * @return Distancia en metros (aproximada)
     */
    public double calcularDistancia(double latitud, double longitud) {
        // Fórmula simplificada de Haversine
        double R = 6371000; // Radio de la Tierra en metros
        double dLat = Math.toRadians(latitud - ubicacionActual.latitud);
        double dLon = Math.toRadians(longitud - ubicacionActual.longitud);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(ubicacionActual.latitud)) *
                        Math.cos(Math.toRadians(latitud)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    /**
     * Verifica si el animal está dentro de un área específica.
     * @param centroLat Latitud del centro del área
     * @param centroLon Longitud del centro del área
     * @param radioMetros Radio del área en metros
     * @return true si está dentro del área, false en caso contrario
     */
    public boolean estaDentroDeArea(double centroLat, double centroLon, double radioMetros) {
        double distancia = calcularDistancia(centroLat, centroLon);
        return distancia <= radioMetros;
    }

    /**
     * Activa o desactiva el GPS.
     * @param activo true para activar, false para desactivar
     */
    public void setGpsActivo(boolean activo) {
        this.gpsActivo = activo;
        log.info("GPS del animal {} {}", getId(), activo ? "ACTIVADO" : "DESACTIVADO");
    }

    /**
     * Obtiene el historial de ubicaciones.
     * @return String con el historial
     */
    public String obtenerHistorialUbicaciones() {
        if (historialUbicaciones.isEmpty()) {
            return "Sin ubicaciones registradas";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Historial de ubicaciones (últimas 10):\n");
        int inicio = Math.max(0, historialUbicaciones.size() - 10);
        List<RegistroUbicacion> ultimas = historialUbicaciones.subList(inicio, historialUbicaciones.size());

        for (RegistroUbicacion registro : ultimas) {
            sb.append(String.format("  - (%.6f, %.6f) - %s\n",
                    registro.latitud,
                    registro.longitud,
                    registro.timestamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))));
        }
        return sb.toString();
    }

    @Override
    public String obtenerInformacion() {
        String infoBase = super.obtenerInformacion();
        String estadoGps = gpsActivo ? "ACTIVO" : "INACTIVO";
        return infoBase + String.format(" [GPS: %s - Ubicación: (%.6f, %.6f)]",
                estadoGps, ubicacionActual.latitud, ubicacionActual.longitud);
    }

    /**
     * Clase interna para representar coordenadas GPS.
     */
    @Getter
    public static class Coordenadas {
        private final double latitud;
        private final double longitud;

        public Coordenadas(double latitud, double longitud) {
            this.latitud = latitud;
            this.longitud = longitud;
        }
    }

    /**
     * Clase interna para representar un registro de ubicación.
     */
    @Getter
    public static class RegistroUbicacion {
        private final double latitud;
        private final double longitud;
        private final LocalDateTime timestamp;

        public RegistroUbicacion(double latitud, double longitud, LocalDateTime timestamp) {
            this.latitud = latitud;
            this.longitud = longitud;
            this.timestamp = timestamp;
        }
    }
}
