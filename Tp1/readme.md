# TP1 - Paradigmas de Programación

**UTN - FRM**
Trabajo Práctico N°1: Fundamentos de la POO e implementación básica en Java.

Implementación de un sistema de gestión de eventos universitarios, desarrollado de forma incremental a lo largo de 4 ejercicios que introducen progresivamente: encapsulamiento, relaciones entre clases (asociación, agregación, composición), herencia y polimorfismo.

## Estructura del repositorio

```
Tp1/
└── src/
    ├── Ejercicio1/
    │   ├── App.java
    │   └── EventoUniversitario.java
    │
    ├── Ejercicio2/
    │   ├── App.java
    │   ├── EventoUniversitario.java
    │   ├── Actividad.java
    │   ├── Sala.java
    │   ├── Estudiante.java
    │   └── Inscripcion.java
    │
    ├── Ejercicio3/
    │   ├── App.java
    │   ├── EventoUniversitario.java
    │   ├── Actividad.java      (clase abstracta)
    │   ├── Charla.java         (extiende Actividad)
    │   ├── Taller.java         (extiende Actividad)
    │   ├── Sala.java
    │   ├── Estudiante.java
    │   └── Inscripcion.java
    │
    └── Ejercicio4/
        └── mapa-memoria.png    (diagrama, no contiene código)
```

Cada ejercicio vive en su propio paquete Java, de forma independiente, ya que cada uno escala el modelo del ejercicio anterior.

## Ejercicio 1 — Fundamentos de la POO

**Objetivo:** implementar la clase `EventoUniversitario` aplicando encapsulamiento, constructores (incluyendo constructor de copia) y un atributo/método `static` como contador de instancias.

**Conceptos aplicados:**
- Modificadores de acceso (`private`, `public`)
- Atributo `final` para datos que no cambian tras la creación
- Constructor de copia
- Atributo y método `static` (`cantidadEventos`, `getCantidadEventos()`)

**Resultado esperado:** se crean eventos, se copian con el constructor de copia, se muestran sus datos y se consulta el total de eventos creados.

## Ejercicio 2 — Relaciones entre clases

**Objetivo:** escalar el modelo incorporando relaciones entre `EventoUniversitario`, `Sala`, `Actividad`, `Estudiante` e `Inscripcion`.

**Conceptos aplicados:**
- **Asociación** — `EventoUniversitario` referencia una `Sala` (relación "agrega")
- **Composición** — `EventoUniversitario` contiene una lista de `Actividad` (`List<Actividad>`), que no existen sin su evento
- **Clase de asociación** — `Inscripcion` representa el vínculo entre `Actividad` y `Estudiante`
- Colecciones (`List`, `ArrayList`) y recorridos con `for-each`

**Resultado esperado:** se registran estudiantes, se construyen eventos, se les asigna sala, se crean actividades propias de cada evento y se inscriben estudiantes en ellas.

## Ejercicio 3 — Herencia y polimorfismo

**Objetivo:** transformar `Actividad` en una clase abstracta y crear las subclases concretas `Charla` y `Taller`, tratadas de forma polimórfica desde `EventoUniversitario`.

**Conceptos aplicados:**
- Clase **abstracta** (`Actividad`) y métodos abstractos (`calcularCostoMateriales()`, `getTipo()`)
- **Herencia** (`extends`) y uso de `super(...)` en los constructores de las subclases
- Método `final` (`mostrarIdentificacion()`) que no puede redefinirse en las subclases
- **Polimorfismo**: `EventoUniversitario` recorre `List<Actividad>` sin conocer el tipo concreto de cada elemento, y cada objeto ejecuta su propia implementación de los métodos abstractos
- Reglas de negocio propias de cada subclase: las charlas son gratuitas; los talleres cuestan $5000 (con notebook) o $2000 (sin notebook)
- Costo total del evento: `(costoBase + costo de actividades) * 1.21`

**Resultado esperado:** se registran estudiantes, se construyen eventos con sala y actividades de tipo Charla y/o Taller, se inscriben estudiantes, y se muestra el resumen de cada evento recorriendo sus actividades de forma polimórfica.

## Ejercicio 4 — Mapa de memoria

**Objetivo:** representar gráficamente cómo se construyen y vinculan en memoria (Stack y Heap) los objetos creados al ejecutar el `main()` del Ejercicio 3.

Incluye el diagrama en `Ejercicio4/mapa-memoria.png`, mostrando las variables locales del `main`, los objetos en el Heap, y las relaciones de asociación, agregación, composición y herencia entre ellos.

## Autor

Trabajo práctico realizado por Sebastian Alvarez.