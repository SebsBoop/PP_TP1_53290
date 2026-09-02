package Ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        int id = 1;

        List<Estudiante> estudiantes = new ArrayList<>();

        System.out.println("CARGA DE ESTUDIANTES: ");
        System.out.println("====================");

        while (continuar) {
            System.out.println("Ingrese el número de legajo del alumno: ");
            String legajo = scanner.nextLine();
            System.out.println("Ingrese el nombre completo del estudiante: ");
            String apenomb = scanner.nextLine();
            estudiantes.add(new Estudiante(legajo, apenomb));
            System.out.println("¿Desea registrar otro estudiante? (S/N)");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            continuar = respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí");
        }

        System.out.println("\n\nCARGA DE EVENTOS: ");
        System.out.println("=================");
        continuar = true;
        while (continuar) {
            System.out.println("Ingrese el nombre del evento: ");
            String titulo = scanner.nextLine();
            System.out.println("Indique el importe base: ");
            double costoBase = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("¿El evento tendrá un costo para los participantes? (S/N)");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            boolean esGratuito = !(respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí"));

            EventoUniversitario evento = new EventoUniversitario(
                    "EVT-" + id,
                    titulo,
                    costoBase,
                    esGratuito
            );

            System.out.println("Ingrese el nombre de la sala en la que se llevará a cabo el evento: ");
            String nombreSala = scanner.nextLine();
            Sala sala = new Sala(id, nombreSala);
            evento.asignarSala(sala);

            System.out.println("\n\nCARGA DE ACTIVIDADES PARA EL EVENTO " + evento.getClass());
            System.out.println("========================================================");
            int idActividad = 1;
            boolean continuarActividades = true;
            while (continuarActividades) {
                System.out.println("Ingrese el nombre de la actividad: ");
                String tituloActividad = scanner.nextLine();
                System.out.println("Indique la cantidad máxima de estudiantes que podrán participar: ");
                int cupo = scanner.nextInt();
                scanner.nextLine();
                System.out.println("¿La actividad corresponde a una Charla o a un Taller? (Charla/Taller)");
                String tipo = scanner.nextLine().trim();

                String disertante = null;
                boolean requiereNotebook = false;

                if (tipo.equalsIgnoreCase("Charla")) {
                    System.out.println("Ingrese el nombre del disertante: ");
                    disertante = scanner.nextLine();
                } else if (tipo.equalsIgnoreCase("Taller")) {
                    System.out.println("¿El taller requiere el uso de notebook? (S/N)");
                    String resp = scanner.nextLine().trim().toLowerCase();
                    requiereNotebook = resp.equals("s") || resp.equals("si") || resp.equals("sí");
                }

                evento.crearActividad(tipo, idActividad, tituloActividad, cupo, disertante, requiereNotebook);

                System.out.println("¿Desea agregar otra actividad al evento " + evento.getClass() + "? (S/N)");
                String resp = scanner.nextLine().trim().toLowerCase();
                continuarActividades = resp.equals("s") || resp.equals("si") || resp.equals("sí");
                idActividad++;
            }

            System.out.println("\n\nINSCRIPCIÓN DE ESTUDIANTES A LAS ACTIVIDADES DEL EVENTO " + evento.getClass());
            System.out.println("================================================================================");
            boolean continuarInscripciones = true;
            while (continuarInscripciones) {
                System.out.println("Ingrese el legajo del estudiante que desea inscribir: ");
                String legajo = scanner.nextLine();
                System.out.println("Indique el identificador de la actividad: ");
                int idAct = scanner.nextInt();
                scanner.nextLine();
                for (Estudiante estudiante : estudiantes) {
                    if (estudiante.getLegajo().equals(legajo)) {
                        evento.getActividades().get(idAct - 1).inscribir(estudiante);
                    }
                }
                System.out.println("¿Desea realizar una nueva inscripción? (S/N)");
                String resp = scanner.nextLine().trim().toLowerCase();
                continuarInscripciones = resp.equals("s") || resp.equals("si") || resp.equals("sí");
            }

            System.out.println("\n\nINFORMACIÓN DEL EVENTO");
            evento.mostrarDatos();

            System.out.println("\n\n¿Desea registrar otro evento? (S/N)");
            String respFinal = scanner.nextLine().trim().toLowerCase();
            continuar = respFinal.equals("s") || respFinal.equals("si") || respFinal.equals("sí");
            id++;
        }

        System.out.println("\n\nCANTIDAD TOTAL DE EVENTOS REGISTRADOS: " + EventoUniversitario.getCantidadEventos());
    }
}