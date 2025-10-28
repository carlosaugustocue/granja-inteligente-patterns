package com.granjainteligente.patterns.behavioral.command.comandosconcretos;

import com.granjainteligente.patterns.behavioral.command.IComando;
import com.granjainteligente.patterns.behavioral.command.receptores.SistemaRiego;

public class ComandoEncenderRiego implements IComando {
    // El comando debe tener un receptor en este caso el sistema de riego
    private final SistemaRiego riego;

    public ComandoEncenderRiego(SistemaRiego riego) {
        this.riego = riego;
    }

    @Override
    public void execute() {
        riego.encender(); // Delega el trabajo al receptor
    }

    @Override
    public void undo() {
        riego.apagar();
    }
}
