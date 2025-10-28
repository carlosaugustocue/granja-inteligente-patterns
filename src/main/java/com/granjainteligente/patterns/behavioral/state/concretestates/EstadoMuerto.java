package com.granjainteligente.patterns.behavioral.state.concretestates;

import com.granjainteligente.patterns.behavioral.state.AnimalContext;
import com.granjainteligente.patterns.behavioral.state.IStateAnimal;

public class EstadoMuerto implements IStateAnimal {

    @Override
    public void alimentar(AnimalContext animal) {
        System.out.printf("ALIMENTACIÓN: [%s] (Muerto) no se puede alimentar animales facellidos.\n", animal.getNombre());
    }

    @Override
    public void ejercitarse(AnimalContext animal) {
        System.out.printf("EJERCICIO: [%s] (Muerto) no se puede ejercitar animales fallecidos.\n", animal.getNombre());
    }

    @Override
    public void trasladarDeCorral(AnimalContext animal, String nuevoCorral) {
        System.out.printf(
                "MOVILIDAD: [%s] (Muerto) se traslada a %s (cementerio).\n",
                animal.getNombre(),
                nuevoCorral
        );
    }

    @Override
    public void reportarSalud(AnimalContext animal) {
        System.out.printf("REPORTE: [%s] está Muerto.\n", animal.getNombre());
    }



    // No hay transiciones de salida para un animal fallecido

    @Override
    public void detectarSintomas(AnimalContext animal) {
        System.out.println("SINTOMAS: El animal ha muerto.");
    }
    @Override
    public void administrarMedicina(AnimalContext animal) {
        System.out.println("MEDICINA: No puedes suministrar medicina a un animal ya muerto.");
    }
    @Override
    public void recibirChequeoPositivo(AnimalContext animal) {
        System.out.println("El animal ha muerto.");
    }
    @Override
    public void iniciarCicloReproductivo(AnimalContext animal) {
        System.out.println("REPRODUCION: No se puede reproducir animales ya muertos.");
    }
    @Override
    public void morir(AnimalContext animal) {
        System.out.println("El animal ya ha muerto.");
    }

}
