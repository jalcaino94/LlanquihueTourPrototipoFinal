# Llanquihue Tour - Sistema de Gestión Operativa 

Este repositorio contiene el prototipo modular desarrollado para la agencia **Llanquihue Tour** (Sede Llanquihue, Región de Los Lagos), correspondiente a la 

El sistema resuelve las problemáticas de desorganización de la información y flujos manuales mediante una arquitectura basada en componentes reutilizables, persistencia de datos en archivos planos, control de integridad con excepciones propias y una interfaz gráfica básica de usuario.

---

## Características Principales 

* **Organización en Paquetes** Estructura  funcional dividida en capas (`app`, `data`, `model`, `utils`) para garantizar alta cohesión y bajo acoplamiento
* **Principios de POO** 
  * **Encapsulamiento:** Atributos privados con accesores (*getters* y *setters*)
  * **Composición:** Relación estructural donde la clase `Persona` contiene una instancia de la clase `Direccion`
  * **Excepciones Personalizadas:** Control de integridad del RUT mediante el lanzamiento de `ValidacionException` ante datos corruptos o incompletos
* **Persistencia y Colecciones** Carga automatizada de registros desde un archivo plano externo (`datos.txt`) hacia una colección dinámica homogénea basada en un `ArrayList<Registrable>`
* **Jerarquías e Interfaces** Implementación del contrato común `Registrable` mediante el método `mostrarDatos()`. Estructura de herencia funcional partiendo de la superclase abstracta `Persona` hacia las subclases `Cliente` y `Proveedor`
* **Interfaz Gráfica (GUI):** Menú interactivo interactivo desarrollado con `JOptionPane` para la captura manual y lectura visual de los flujos de datos.

---

## Estructura del Proyecto

```text
EvaluacionFinalTransversal/
├── datos.txt             # Archivo externo con datos de prueba (.txt)
└── src/
    ├── app/              # Capa de Aplicación (Punto de entrada)
    │   └── Main.java     # Flujo principal e Interfaz Gráfica (GUI)
    ├── data/             # Capa de Datos (Controladores y Colecciones)
    │   └── GestorAgencia.java
    ├── model/            # Capa del Modelo (Entidades y Contratos)
    │   ├── Registrable.java     (Interfaz Común)
    │   ├── Persona.java         (Superclase Abstracta)
    │   ├── Direccion.java       (Composición)
    │   ├── Cliente.java         (Subclase)
    │   └── Proveedor.java       (Subclase)
    └── utils/            # Capa de Utilidades (Soporte Técnico)
        ├── LectorArchivo.java   (Lector I/O)
        └── ValidacionException.java (Excepción Personalizada)
