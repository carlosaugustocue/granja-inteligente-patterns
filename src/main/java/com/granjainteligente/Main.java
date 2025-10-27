package com.granjainteligente;

import com.granjainteligente.patterns.creational.abstractfactory.factory.FabricaVacasLecheras;
import com.granjainteligente.patterns.creational.abstractfactory.model.animals.Animal;
import com.granjainteligente.patterns.creational.abstractfactory.model.food.Alimento;
import com.granjainteligente.patterns.creational.abstractfactory.model.environment.Entorno;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase principal del sistema de Granja Inteligente.
 * Punto de entrada de la aplicación.
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("===========================================");
        log.info("   SISTEMA DE GRANJA INTELIGENTE v1.0");
        log.info("===========================================");
        log.info("Iniciando sistema...");

        try {
            // TODO: Inicializar el sistema de la granja
            inicializarSistema();

            // TODO: Ejecutar simulación
            ejecutarSimulacion();

        } catch (Exception e) {
            log.error("Error fatal en el sistema: ", e);
            System.exit(1);
        }

        log.info("Sistema finalizado correctamente.");
    }

    /**
     * Inicializa todos los componentes del sistema.
     */
    private static void inicializarSistema() {
        log.info("Inicializando componentes del sistema...");

        // 🧩 Prueba del patrón Abstract Factory
        FabricaVacasLecheras fabricaVacas = new FabricaVacasLecheras();

        Animal vaca = fabricaVacas.crearAnimal();
        Alimento alimento = fabricaVacas.crearAlimento();
        Entorno entorno = fabricaVacas.crearEntorno();

        log.info("Animal creado: {} ({})", vaca.getTipo(), vaca.getRaza());
        log.info("Descripción: {}", vaca.getDescripcion());
        log.info("Alimento: {} - {}", alimento.getTipo(), alimento.getComposicion());
        log.info("Entorno: {} - {}", entorno.getTipo(), entorno.getDescripcion());

        // TODO: Inicializar AlimentadorGlobal (Singleton)
        // TODO: Configurar fábricas de animales
        // TODO: Registrar observadores de sensores
        // TODO: Cargar estrategias de alimentación

        log.info("Sistema inicializado correctamente.");
    }

    /**
     * Ejecuta la simulación principal del sistema.
     */
    private static void ejecutarSimulacion() {
        log.info("Ejecutando simulación de la granja...");

        // TODO: Simular sensores detectando niveles bajos
        // TODO: Crear animales usando Factory
        // TODO: Aplicar estrategias según la estación
        // TODO: Ejecutar comandos de alimentación
        // TODO: Mostrar estado del sistema

        log.info("Simulación completada.");
    }
}