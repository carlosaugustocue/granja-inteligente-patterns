package com.granjainteligente.patterns.behavioral.observer.observadoresconcretos;

import com.granjainteligente.patterns.behavioral.observer.AlertasInfoDTO;
import com.granjainteligente.patterns.behavioral.observer.clasesbase.Observer;


/**
 * Esta clase representa un observador específico que solo está interesado
 * en recibir notificaciones sobre el estado de las vacas.
 */
public class ObserverVacas implements Observer {

    @Override
    public void update(AlertasInfoDTO datos) {
        // Si este método es llamado, es porque el SensorVacas nos notificó.
        System.out.println(">>> ALERTA VACAS: ¡Atención!");
        System.out.printf(
                "¡Las vacas necesitan reabastecerse de '%s' en el corral %s!\n",
                datos.recurso(),
                datos.idCorral()
        );
    }

}
