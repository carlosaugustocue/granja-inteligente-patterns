package com.granjainteligente.patterns.behavioral.command.comandosconcretos;

import com.granjainteligente.patterns.behavioral.command.IComando;
import com.granjainteligente.patterns.behavioral.command.receptores.SistemaLuces;

public class ComandoEncenderLuces implements IComando {
    // El comando debe tener un receptor en este caso el sistema de luces
    private final SistemaLuces luces;

    public ComandoEncenderLuces(SistemaLuces luces) {
        this.luces = luces;
    }

    @Override
    public void execute() {
        luces.encender();
    }

    @Override
    public void undo() {
        luces.apagar();
    }
}
