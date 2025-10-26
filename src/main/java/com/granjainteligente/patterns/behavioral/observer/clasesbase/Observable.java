package com.granjainteligente.patterns.behavioral.observer.clasesbase;

import com.granjainteligente.patterns.behavioral.observer.AlertasInfoDTO;

// Interfaz Subject
public interface Observable {
    /**
     * Agrega un nuevo observador a la lista.
     */
    void addObserver(Observer o);

    /**
     * Elimina un observador de la lista.
     */
    void removeObserver(Observer o);

    /**
     * Notifica a todos los observadores suscritos sobre un nuevo evento.
     */
    void notifyObservers(AlertasInfoDTO datos);
}
