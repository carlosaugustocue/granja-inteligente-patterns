package com.granjainteligente.patterns.structural.adapter;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase que representa un sensor antiguo con interfaz incompatible.
 * Esta clase simula hardware legacy que no puede ser modificado.
 */
@Slf4j
@Getter
public class SensorLegacy {

    private String sensorId;
    private String sensorType;
    private double currentValue;
    private int status; // 0 = apagado, 1 = operativo, 2 = error

    public SensorLegacy(String sensorId, String sensorType) {
        this.sensorId = sensorId;
        this.sensorType = sensorType;
        this.currentValue = 0.0;
        this.status = 1; // Por defecto operativo
        log.info("Sensor legacy inicializado: {} [{}]", sensorId, sensorType);
    }

    /**
     * Método legacy para leer datos (formato antiguo).
     * @return Array con [status, value]
     */
    public double[] readSensorData() {
        // Simular lectura de sensor legacy
        currentValue = Math.random() * 100;
        log.debug("Lectura legacy del sensor {}: {}", sensorId, currentValue);
        return new double[]{status, currentValue};
    }

    /**
     * Método legacy para obtener información del sensor.
     * @return String con formato antiguo "ID|TYPE|STATUS"
     */
    public String getSensorInfo() {
        return sensorId + "|" + sensorType + "|" + status;
    }

    /**
     * Método legacy para verificar estado.
     * @return 1 si está operativo, 0 en caso contrario
     */
    public int checkStatus() {
        return status;
    }

    /**
     * Simula un cambio en el estado del sensor.
     */
    public void setStatus(int newStatus) {
        this.status = newStatus;
        log.info("Estado del sensor {} cambiado a: {}", sensorId, newStatus);
    }
}
