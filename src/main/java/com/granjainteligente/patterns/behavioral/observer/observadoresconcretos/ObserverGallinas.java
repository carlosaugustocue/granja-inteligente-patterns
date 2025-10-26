package com.granjainteligente.patterns.behavioral.observer.observadoresconcretos;

import com.granjainteligente.patterns.behavioral.observer.AlertasInfoDTO;
import com.granjainteligente.patterns.behavioral.observer.clasesbase.Observer;


/**
 * Esta clase representa un observador específico que solo está interesado
 * en recibir notificaciones sobre el estado de las gallinas.
 */
public class ObserverGallinas implements Observer {

    @Override
    public void update(AlertasInfoDTO datos) {
        // Si este método es llamado, es porque el SensorGallinas nos notificó.
        System.out.println(">>> ALERTA GALLINAS: ¡Atención!");
        System.out.printf(
                "¡Las gallinas necesitan reabastecerse de '%s' en el corral %s!\n",
                datos.recurso(),
                datos.idCorral()
        );
    }
}
