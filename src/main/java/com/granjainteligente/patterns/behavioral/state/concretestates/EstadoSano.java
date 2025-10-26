package com.granjainteligente.patterns.behavioral.state.concretestates;

import com.granjainteligente.patterns.behavioral.state.AnimalContext;
import com.granjainteligente.patterns.behavioral.state.IStateAnimal;

public class EstadoSano implements IStateAnimal {
    @Override
    public void alimentar(AnimalContext animal) {
        System.out.printf(
                "ALIMENTACION: [%s] (Sano) está comiendo %.2f kg de alimento.\n",
                animal.getNombre(),
                animal.getCantidadComidaBaseKg() * 1.0 // Come el 100%
        );
    }

    @Override
    public void ejercitarse(AnimalContext animal) {
        System.out.printf("SALUD: [%s] (Sano) corre felizmente.\n", animal.getNombre());
    }

    @Override
    public void trasladarDeCorral(AnimalContext animal, String nuevoCorral) {
        System.out.printf(
                "TRASLADO: [%s] (Sano) se traslada al corral %s.\n",
                animal.getNombre(),
                nuevoCorral
        );
    }

    @Override
    public void reportarSalud(AnimalContext animal) {
        System.out.printf("REPORTE DE SALUD: [%s] está Sano.\n", animal.getNombre());
    }




    // Transiciones desde Sano

    @Override
    public void detectarSintomas(AnimalContext animal) {
        animal.setEstado(new EstadoEnfermo());
    }

    @Override
    public void administrarMedicina(AnimalContext animal) {
        System.out.println("No se puede medicar a un animal Sano");
    }

    @Override
    public void recibirChequeoPositivo(AnimalContext animal) {
        System.out.println("El animal ya se encuentra en perfectas condiciones");
    }

    @Override
    public void iniciarCicloReproductivo(AnimalContext animal) {
        animal.setEstado(new EstadoApareamiento());
    }

    @Override
    public void morir(AnimalContext animal) {
        animal.setEstado(new EstadoMuerto());
    }

}
