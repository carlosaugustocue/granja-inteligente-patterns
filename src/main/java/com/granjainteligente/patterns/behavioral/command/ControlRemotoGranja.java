package com.granjainteligente.patterns.behavioral.command;

import java.util.Stack;

public class ControlRemotoGranja {
    // Usamos un Stack para guardar un historial de comandos y poder deshacer el último gracias al comportamiento de tipo Stack.
    private final Stack<IComando> historialComandos = new Stack<>();

    /**
     * El usuario "presiona un botón del control remoto" que ejecuta un comando.
     */
    public void ejecutarComando(IComando comando) {
        comando.execute();
        // Guardamos el comando ejecutado del usuario en caso de requerir deshacerlo
        historialComandos.push(comando);
    }

    /**
     * El usuario "presiona un botón de deshacer del control remoto".
     */
    public void presionarBotonUndo() {
        if (historialComandos.isEmpty()) {
            System.out.println("CONTROL: Nada que deshacer.");
            return;
        }

        IComando ultimoComando = historialComandos.pop();
        System.out.println("CONTROL: Deshaciendo la última acción...");
        ultimoComando.undo();
    }
}
