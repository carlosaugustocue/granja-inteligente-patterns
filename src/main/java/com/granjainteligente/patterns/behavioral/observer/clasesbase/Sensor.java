package com.granjainteligente.patterns.behavioral.observer.clasesbase;

import com.granjainteligente.patterns.behavioral.observer.AlertasInfoDTO;

import java.util.HashSet;
import java.util.Set;


/** Implementación del sensor (Subject) **/
public class Sensor implements Observable {

    // HashSet para mantener a todos los observadores suscritos y que no halla suscriptores duplicados
    Set<Observer> observerSet = new HashSet<>();


    // Override del método addObserver el cual agregara a los observadores a observerSet
    @Override
    public void addObserver(Observer o) {
        observerSet.add(o);
    }

    // Override del método removeObserver el cual eliminara a los observadores de observerSet
    @Override
    public void removeObserver(Observer o) {
        observerSet.remove(o);
    }

    // Override del método notifyObservers el cual notificara a todos los observadores de un cambio
    @Override
    public void notifyObservers(AlertasInfoDTO datos) {
        for (Observer o : observerSet) {
            o.update(datos);
        }
    }
}
