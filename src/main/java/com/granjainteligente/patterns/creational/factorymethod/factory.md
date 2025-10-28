🧩 Patrón de Diseño: Factory Method
Proyecto: Granja Inteligente – Simulación de Producción Animal
📘 Descripción General

El Factory Method es un patrón de diseño creacional que permite delegar la creación de objetos a subclases o clases concretas, evitando acoplar el código cliente a clases específicas.

En la Granja Inteligente, este patrón se utiliza para crear distintos tipos de animales (Vaca, Cerdo, Gallina) de forma flexible, según el tipo de corral o propósito productivo (leche, carne, huevos).

🎯 Problema

El sistema de simulación debía permitir la creación dinámica de animales sin que el código principal (Main) conociera las clases concretas (Vaca, Cerdo, Gallina).

Inicialmente, cada tipo se creaba directamente con new, generando:

Alto acoplamiento.

Dificultad para extender el sistema con nuevos tipos.

Violación del principio OCP (Open/Closed Principle).

💡 Solución

El patrón Factory Method propone encapsular la lógica de creación en una jerarquía de fábricas concretas, todas derivadas de una interfaz común.

Esto permite crear animales de forma polimórfica y extensible, cumpliendo con los principios SOLID.

🏗️ Estructura Implementada
patterns/creational/factorymethod/
├── AnimalFactory.java          # Interfaz base del método de fábrica
├── CorralVacas.java            # Fábrica concreta para vacas
├── CorralCerdo.java            # Fábrica concreta para cerdos
├── CorralGallinas.java         # Fábrica concreta para gallinas
└── AnimalFactoryProvider.java  # Proveedor central de fábricas (Selector)

🧠 Ventajas
Ventaja	Descripción
Desacoplamiento	El cliente no conoce las clases concretas (Vaca, Cerdo, Gallina).
Extensibilidad	Nuevos tipos de animales pueden agregarse sin modificar el código existente.
Mantenibilidad	Cada fábrica tiene una única responsabilidad.
Cumple SOLID	SRP y OCP especialmente.
Compatible con SonarQube	Sin switch ni if-else anidados, sin code smells.
⚠️ Posibles Errores Comunes
Error	Causa	Solución
ExceptionInInitializerError	Lombok incompatible con JDK 21	Actualizar a Lombok ≥ 1.18.34
NullPointerException al crear animales	TipoAnimal no registrado en FACTORIES	Registrar el nuevo tipo en AnimalFactoryProvider
Too many responsibilities (Sonar)	Fábrica haciendo lógica de negocio	Mantener fábricas puras (solo creación)
🔍 Validación SonarQube

✔️ Sin Code Smells
✔️ Alta cohesión / Bajo acoplamiento
✔️ Métodos cortos y claros
✔️ Naming descriptivo y consistente

🧾 Conclusión

El Factory Method permitió a la Granja Inteligente:

Crear animales de forma modular y extensible.

Cumplir con las buenas prácticas de ingeniería de software.

Servir de base para otros patrones creacionales como Abstract Factory o Builder.