package com.granjainteligente.patterns.behavioral.observer;

// Este record simulará los datos que el sensor enviara a los observadores
public record AlertasInfoDTO (String tipoAnimal, String recurso, String idCorral) {}
