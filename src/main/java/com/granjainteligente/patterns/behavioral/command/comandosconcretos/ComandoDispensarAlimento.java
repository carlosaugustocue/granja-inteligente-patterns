package com.granjainteligente.patterns.behavioral.command.comandosconcretos;

import com.granjainteligente.patterns.behavioral.command.IComando;

public class ComandoDispensarAlimento implements IComando {
    // El comando debe tener un receptor en este caso simulamos directamente los valores en el comando,
    // pero en un caos real se instanciara un receptor "Dispensador" para el comando de alimentos

    // Se almacenan datos necesarios para la simulación.
    private final String tipoAnimal;
    private final String idCorral;

    public ComandoDispensarAlimento(String tipoAnimal, String idCorral) {
        this.tipoAnimal = tipoAnimal;
        this.idCorral = idCorral;
    }

    @Override
    public void execute() {
        System.out.printf(
                "REABASTECMIENTO: Se estan llenando los corrales con alimento' para [%s] en corral [%s].\n",
                this.tipoAnimal,
                this.idCorral
        );
    }

    @Override
    public void undo() {
        System.out.printf(
                "REABASTECIMIENTO: Se han cerrado las compuertas del dispensar de alimento para [%s] en [%s].\n",
                this.tipoAnimal,
                this.idCorral
        );
    }
}
