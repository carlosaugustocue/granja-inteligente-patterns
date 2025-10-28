package com.granjainteligente.patterns.behavioral.command;

/**
 * Interfaz Command que
 * define el contrato para todas las acciones encapsuladas.
 * Incluye un método execute para ejecutar la acción y
 * undo para deshacerla.
 */
public interface IComando {
    void execute();
    void undo();
}
