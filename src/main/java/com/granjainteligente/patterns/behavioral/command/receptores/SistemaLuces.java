package com.granjainteligente.patterns.behavioral.command.receptores;

public class SistemaLuces {
    private final String area;
    public SistemaLuces(String area) { this.area = area; }

    public void encender() {
        System.out.printf("LUCES [%s]: Encendidas (100%%).\n", area);
    }
    public void apagar() {
        System.out.printf("LUCES [%s]: Apagadas.\n", area);
    }
}
