package com.granjainteligente.patterns.behavioral.observer.sensoresconcretos;


import com.granjainteligente.patterns.behavioral.observer.AlertasInfoDTO;
import com.granjainteligente.patterns.behavioral.observer.clasesbase.Sensor;

public class SensorCerdos extends Sensor {

    /**
     * Método de simulación para generar un nuevo evento de alerta para los cerdos.
     */

    public void detectarNivelBajoCerdos(String recurso, String idCorral) {
        AlertasInfoDTO datos = new AlertasInfoDTO("Cerdo", recurso, idCorral);

        // Llama notifyObservers el cual fue heredado del padre
        System.out.println("SENSOR CERDOS: Detectando bajo nivel. Notificando...");
        notifyObservers(datos);
    }

}
