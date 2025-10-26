package com.granjainteligente.patterns.behavioral.observer.clasesbase;


import com.granjainteligente.patterns.behavioral.observer.AlertasInfoDTO;

/** Interfaz observer
 *
 **/
public interface Observer {

    /**
     * El Sujeto llama a este método cuando su estado cambia.
     */
    void update(AlertasInfoDTO datos);
}
