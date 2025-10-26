package com.granjainteligente.patterns.behavioral.command.receptores;

public class SistemaRiego {
    private final String zona;
    public SistemaRiego(String zona) { this.zona = zona; }

    public void encender() {
        System.out.printf("RIEGO [%s]: Sistema encendido. Fluyendo agua.\n", zona);
    }
    public void apagar() {
        System.out.printf("RIEGO [%s]: Sistema apagado. Válvulas cerradas.\n", zona);
    }
}
