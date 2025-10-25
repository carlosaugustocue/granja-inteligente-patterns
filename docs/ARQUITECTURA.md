# 📐 Arquitectura del Sistema Granja Inteligente

## Visión General

El sistema de Granja Inteligente está diseñado siguiendo principios SOLID y aplicando patrones de diseño para crear una solución escalable, mantenible y flexible.

## Estructura de Paquetes

```
com.granjainteligente/
├── models/              # Entidades del dominio
├── patterns/           
│   ├── creational/     # Patrones creacionales
│   ├── structural/     # Patrones estructurales
│   └── behavioral/     # Patrones comportamentales
└── services/           # Lógica de negocio
```

## Patrones de Diseño Implementados

### 1. Patrones Creacionales

#### Factory Method
- **Propósito**: Crear instancias de animales sin especificar su clase exacta
- **Ubicación**: `patterns.creational.factory`
- **Clases principales**:
  - `AnimalFactory` (interfaz)
  - `VacaFactory`, `CerdoFactory`, `GallinaFactory`

#### Abstract Factory
- **Propósito**: Crear familias de objetos relacionados
- **Ubicación**: `patterns.creational.abstractfactory`
- **Ejemplo**: Fábrica de vacas lecheras con raza y alimento específicos

#### Builder
- **Propósito**: Construir objetos complejos paso a paso
- **Ubicación**: `patterns.creational.builder`
- **Clase principal**: `AnimalBuilder`

#### Singleton
- **Propósito**: Garantizar una única instancia del alimentador global
- **Ubicación**: `patterns.creational.singleton`
- **Clase principal**: `AlimentadorGlobal`

### 2. Patrones Estructurales

#### Adapter
- **Propósito**: Compatibilidad con sensores legacy
- **Ubicación**: `patterns.structural.adapter`
- **Clases**: `SensorAdapter`, `SensorLegacy`

#### Decorator
- **Propósito**: Añadir funcionalidades dinámicamente
- **Ubicación**: `patterns.structural.decorator`
- **Decoradores**: `AnimalConVacuna`, `AnimalConGPS`

#### Facade
- **Propósito**: Interfaz simplificada para subsistemas complejos
- **Ubicación**: `patterns.structural.facade`
- **Clase principal**: `GranjaFacade`

### 3. Patrones Comportamentales

#### Observer
- **Propósito**: Notificación automática de cambios
- **Ubicación**: `patterns.behavioral.observer`
- **Interfaces**: `Subject`, `Observer`

#### Strategy
- **Propósito**: Algoritmos intercambiables de alimentación
- **Ubicación**: `patterns.behavioral.strategy`
- **Estrategias**: `EstrategiaInvierno`, `EstrategiaVerano`

#### Command
- **Propósito**: Encapsular operaciones como objetos
- **Ubicación**: `patterns.behavioral.command`
- **Comandos**: `DispensarAlimentoCommand`, `EncenderRiegoCommand`

#### State
- **Propósito**: Cambiar comportamiento según estado interno
- **Ubicación**: `patterns.behavioral.state`
- **Estados**: `Sano`, `Enfermo`, `EnTratamiento`

## Diagrama de Clases Principal

```
                    <<interface>>
                       Animal
                         |
                    AnimalBase
                    /    |    \
                Vaca  Cerdo  Gallina
                  |      |       |
            [Decorators] |  [Decorators]
                         |
                   [State Pattern]
```

## Flujo de Integración

```
Sensor (Observer) 
    ↓
Detecta nivel bajo
    ↓
Factory Method
    ↓
Crea animales
    ↓
Strategy Pattern
    ↓
Selecciona alimentación
    ↓
Command Pattern
    ↓
Ejecuta acción
    ↓
Facade Pattern
    ↓
Coordina todo
```

## Principios SOLID Aplicados

### S - Single Responsibility
Cada clase tiene una única responsabilidad bien definida.

### O - Open/Closed
Las clases están abiertas para extensión pero cerradas para modificación.

### L - Liskov Substitution
Las subclases pueden sustituir a sus clases base sin alterar el comportamiento.

### I - Interface Segregation
Interfaces específicas en lugar de una interfaz general.

### D - Dependency Inversion
Dependemos de abstracciones, no de implementaciones concretas.

## Decisiones de Diseño

1. **Uso de Lombok**: Reduce el código boilerplate
2. **Logging con SLF4J**: Abstracción para logging flexible
3. **UUID para IDs**: Garantiza identificadores únicos
4. **Enums para tipos**: Type-safety y mejor mantenibilidad
5. **Maven para gestión**: Estándar de la industria

## Consideraciones de Rendimiento

- Singleton para recursos compartidos
- Lazy initialization donde sea posible
- Caching de cálculos costosos
- Pool de objetos para entidades reutilizables

## Seguridad

- Validación de entrada en todos los métodos públicos
- Encapsulación adecuada
- Inmutabilidad donde sea posible
- Manejo apropiado de excepciones

## Pruebas

- Tests unitarios para cada patrón
- Tests de integración para el flujo completo
- Cobertura mínima del 80%
- TDD como práctica recomendada
