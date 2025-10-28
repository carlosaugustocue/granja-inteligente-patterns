package com.granjainteligente.patterns.behavioral.observer.sensoresconcretos;


import com.granjainteligente.patterns.behavioral.observer.AlertasInfoDTO;
import com.granjainteligente.patterns.behavioral.observer.clasesbase.Sensor;

public class SensorVacas extends Sensor {

    /**
     * Método de simulación para generar un nuevo evento de alerta para las vacas.
     */

    public void detectarNivelBajoVacas(String recurso, String idCorral) {
        AlertasInfoDTO datos = new AlertasInfoDTO("Vaca", recurso, idCorral);

        // Llama notifyObservers el cual fue heredado del padre
        System.out.println("SENSOR VACAS: Detectando bajo nivel. Notificando...");
        notifyObservers(datos);
    }
}
