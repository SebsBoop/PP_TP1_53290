package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // a. Se construye una lista de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("L001", "Juan Pérez"));
        estudiantes.add(new Estudiante("L002", "María Gómez"));
        estudiantes.add(new Estudiante("L003", "Carlos Ruiz"));

        // b. Se construyen eventos
        EventoUniversitario evento1 = new EventoUniversitario("E01", "Hackathon UNCuyo", 1500.0, false);
        EventoUniversitario evento2 = new EventoUniversitario("E02", "Semana de la IA", 0.0, true);

        // c. Se asigna una sala a cada evento
        Sala sala1 = new Sala(101, "Aula Magna");
        Sala sala2 = new Sala(202, "Laboratorio 3");
        evento1.asignarSala(sala1);
        evento2.asignarSala(sala2);

        // d. Se crean actividades propias de cada evento
        evento1.crearActividad(1, "Programación en equipos", 30);
        evento1.crearActividad(2, "Presentación de proyectos", 20);
        evento2.crearActividad(3, "Introducción a IA", 40);

        // e. Se inscriben estudiantes en cada actividad
        // Recuperamos las actividades ya creadas para inscribir gente en ellas
        Actividad actividad1 = evento1.getActividades().get(0);
        Actividad actividad2 = evento2.getActividades().get(0);

        actividad1.inscribir(estudiantes.get(0));
        actividad1.inscribir(estudiantes.get(1));
        actividad2.inscribir(estudiantes.get(2));

        // f. Se muestra el resumen de datos de cada evento creado
        System.out.println("--- Evento 1 ---");
        evento1.mostrarDatos();

        System.out.println("\n--- Evento 2 ---");
        evento2.mostrarDatos();

        System.out.println("\n--- Inscripciones Actividad 1 ---");
        actividad1.mostrarInscripciones();

        System.out.println("\n--- Inscripciones Actividad 2 ---");
        actividad2.mostrarInscripciones();

        // g. Se muestra el total de eventos creados
        System.out.println("\nCantidad total de eventos creados: " + EventoUniversitario.getCantidadEventos());
    }
}