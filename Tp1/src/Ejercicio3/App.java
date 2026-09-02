package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("L001", "Juan Pérez"));
        estudiantes.add(new Estudiante("L002", "María Gómez"));
        estudiantes.add(new Estudiante("L003", "Carlos Ruiz"));


        EventoUniversitario evento1 = new EventoUniversitario("E01", "Hackathon UNCuyo", 1500.0, false);
        EventoUniversitario evento2 = new EventoUniversitario("E02", "Semana de la IA", 0.0, true);


        Sala sala1 = new Sala(101, "Aula Magna");
        Sala sala2 = new Sala(202, "Laboratorio 3");
        evento1.asignarSala(sala1);
        evento2.asignarSala(sala2);


        evento1.crearActividad("Taller", 1, "Taller de Programación", 30, null, true);
        evento1.crearActividad("Charla", 2, "Charla de cierre", 50, "Ing. López", false);
        evento2.crearActividad("Charla", 3, "Introducción a IA", 40, "Dra. Fernández", false);

        // e. Se inscriben estudiantes en cada actividad
        List<Actividad> actividadesEvento1 = evento1.getActividades();
        List<Actividad> actividadesEvento2 = evento2.getActividades();

        actividadesEvento1.get(0).inscribir(estudiantes.get(0));
        actividadesEvento1.get(1).inscribir(estudiantes.get(1));
        actividadesEvento2.get(0).inscribir(estudiantes.get(2));


        System.out.println("--- Evento 1 ---");
        evento1.mostrarDatos();

        System.out.println("\n--- Evento 2 ---");
        evento2.mostrarDatos();

        // g. Se muestra el total de eventos creados
        System.out.println("\nCantidad total de eventos creados: " + EventoUniversitario.getCantidadEventos());
    }
}