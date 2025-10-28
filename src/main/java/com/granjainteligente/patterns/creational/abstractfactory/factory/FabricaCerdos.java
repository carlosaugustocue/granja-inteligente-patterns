package com.granjainteligente.patterns.creational.abstractfactory.factory;

import com.granjainteligente.patterns.creational.abstractfactory.model.animals.Animal;
import com.granjainteligente.patterns.creational.abstractfactory.model.animals.Cerdo;
import com.granjainteligente.patterns.creational.abstractfactory.model.food.Alimento;
import com.granjainteligente.patterns.creational.abstractfactory.model.food.AlimentoPorcino;
import com.granjainteligente.patterns.creational.abstractfactory.model.environment.Entorno;
import com.granjainteligente.patterns.creational.abstractfactory.model.environment.CorralCalido;

/**
 * Fábrica concreta que crea una familia de productos para Cerdos:
 * Animal: Cerdo
 * Alimento: AlimentoPorcino
 * Entorno: CorralCalido
 */

public class FabricaCerdos implements FabricaAbstracta {

    @Override
    public Animal crearAnimal() {
        return new Cerdo("Large White", "Raza orientada a la producción de carne.");
    }

    @Override
    public Alimento crearAlimento() {
        return new AlimentoPorcino("Pienso energético alto en proteínas.");
    }

    @Override
    public Entorno crearEntorno() {
        return new CorralCalido("Corral cerrado con temperatura controlada.");
    }
}