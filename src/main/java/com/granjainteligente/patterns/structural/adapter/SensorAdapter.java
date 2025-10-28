package com.granjainteligente.patterns.structural.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * Adaptador que convierte la interfaz del SensorLegacy al formato moderno ISensor.
 * Permite que los sensores antiguos funcionen con el nuevo sistema sin modificarlos.
 *
 * Patrón: Adapter (Structural Pattern)
 * Propósito: Convertir la interfaz de una clase en otra que los clientes esperan.
 */
@Slf4j
public class SensorAdapter implements ISensor {

    private final SensorLegacy sensorLegacy;

    /**
     * Constructor que recibe el sensor legacy a adaptar.
     * @param sensorLegacy Instancia del sensor antiguo
     */
    public SensorAdapter(SensorLegacy sensorLegacy) {
        this.sensorLegacy = sensorLegacy;
        log.info("Adaptador creado para sensor legacy: {}", sensorLegacy.getSensorId());
    }

    @Override
    public double obtenerLectura() {
        // Adaptar el método legacy readSensorData() al formato moderno
        double[] data = sensorLegacy.readSensorData();
        double lectura = data[1]; // El valor está en la posición 1
        log.debug("Lectura adaptada del sensor {}: {}", obtenerIdentificador(), lectura);
        return lectura;
    }

    @Override
    public String obtenerTipo() {
        // Adaptar el método legacy getSensorInfo() para extraer solo el tipo
        String info = sensorLegacy.getSensorInfo();
        String[] parts = info.split("\\|");
        return parts.length > 1 ? parts[1] : "DESCONOCIDO";
    }

    @Override
    public String obtenerIdentificador() {
        // Adaptar el método legacy getSensorInfo() para extraer solo el ID
        String info = sensorLegacy.getSensorInfo();
        String[] parts = info.split("\\|");
        return parts.length > 0 ? parts[0] : "UNKNOWN";
    }

    @Override
    public boolean estaOperativo() {
        // Adaptar el método legacy checkStatus() al formato booleano moderno
        int status = sensorLegacy.checkStatus();
        return status == 1;
    }

    /**
     * Método adicional para acceder al sensor legacy si es necesario.
     * @return Instancia del sensor legacy adaptado
     */
    public SensorLegacy getSensorLegacy() {
        return sensorLegacy;
    }
}
