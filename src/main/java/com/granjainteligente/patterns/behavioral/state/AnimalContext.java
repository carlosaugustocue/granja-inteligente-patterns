package com.granjainteligente.patterns.behavioral.state;

import com.granjainteligente.patterns.behavioral.state.concretestates.EstadoSano;

public class AnimalContext {

    // Se instancia una variable de
    protected IStateAnimal estadoActual;

    // Datos específicos de cada animal
    protected String nombre;
    protected double cantidadComidaBaseKg;

    public AnimalContext(String nombre, double cantidadComidaBaseKg) {
        this.nombre = nombre;
        this.cantidadComidaBaseKg = cantidadComidaBaseKg;
        // Todo animal nuevo empieza Sano por defecto.
        this.estadoActual = new EstadoSano();
    }

    // Proveemos un setter para que los Estados puedan cambiar el estado del Contexto.
    public void setEstado(IStateAnimal nuevoEstado) {
        this.estadoActual = nuevoEstado;
        System.out.printf(
                "*** CAMBIO DE ESTADO: [%s] ha cambiado al estado: %s\n",
                this.nombre,
                nuevoEstado.getClass().getSimpleName()
        );
    }

    // Establecemos getters para los Estados
    public String getNombre() {
        return this.nombre;
    }
    public double getCantidadComidaBaseKg() {
        return this.cantidadComidaBaseKg;
    }


    // Delegamos comportamientos al Estado

    public void alimentar() {
        this.estadoActual.alimentar(this);
    }

    public void ejercitarse() {
        this.estadoActual.ejercitarse(this);
    }

    public void trasladarDeCorral(String nuevoCorral) {
        this.estadoActual.trasladarDeCorral(this, nuevoCorral);
    }

    public void reportarSalud() {
        this.estadoActual.reportarSalud(this);
    }


    // Delegamos los Eventos/Transiciones al Estado

    public void detectarSintomas() {
        this.estadoActual.detectarSintomas(this);
    }

    public void administrarMedicina() {
        this.estadoActual.administrarMedicina(this);
    }

    public void recibirChequeoPositivo() {
        this.estadoActual.recibirChequeoPositivo(this);
    }

    public void iniciarCicloReproductivo() {
        this.estadoActual.iniciarCicloReproductivo(this);
    }

    public void morir() {
        this.estadoActual.morir(this);
    }
}
