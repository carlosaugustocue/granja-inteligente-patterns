package com.granjainteligente.patterns.structural.adapter;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import java.util.UUID;

/**
 * Implementación moderna de un sensor que ya implementa la interfaz ISensor.
 * Se incluye para demostrar la convivencia entre sensores nuevos y adaptados.
 */
@Slf4j
@Getter
public class SensorModerno implements ISensor {

    private final String identificador;
    private final String tipo;
    private double lectura;
    private boolean operativo;

    public SensorModerno(String tipo) {
        this.identificador = UUID.randomUUID().toString();
        this.tipo = tipo;
        this.lectura = 0.0;
        this.operativo = true;
        log.info("Sensor moderno inicializado: {} [{}]", identificador, tipo);
    }

    @Override
    public double obtenerLectura() {
        if (!operativo) {
            log.warn("Sensor {} no operativo, retornando lectura anterior", identificador);
            return lectura;
        }

        // Simular lectura del sensor
        lectura = Math.random() * 100;
        log.debug("Lectura del sensor {}: {}", identificador, lectura);
        return lectura;
    }

    @Override
    public String obtenerTipo() {
        return tipo;
    }

    @Override
    public String obtenerIdentificador() {
        return identificador;
    }

    @Override
    public boolean estaOperativo() {
        return operativo;
    }

    /**
     * Permite cambiar el estado operativo del sensor.
     * @param operativo nuevo estado
     */
    public void setOperativo(boolean operativo) {
        this.operativo = operativo;
        log.info("Estado del sensor {} cambiado a: {}", identificador,
                operativo ? "OPERATIVO" : "FUERA DE SERVICIO");
    }
}
