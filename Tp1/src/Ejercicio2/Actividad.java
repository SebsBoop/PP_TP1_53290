package Ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Actividad {

    private int id;
    private String titulo;
    private int cupoMaximo;
    public static final int cupoMinimo = 5;
    private List<Inscripcion> inscripciones;
    private Object i;

    public Actividad (int id, String titulo, int cupoMaximo) {

        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }


    public Inscripcion inscribir(Estudiante estudiante){

        Inscripcion nuevaInscripcion = new Inscripcion("Confirmada", LocalDate.now());
        inscripciones.add(nuevaInscripcion);

        return nuevaInscripcion;

    }

    public void mostrarInscripciones(){

        System.out.println("Inscripcion de la actividad: "+ titulo);
        for (Inscripcion i: inscripciones)
            System.out.println("Fecha: " + i.getFecha() + "Estado: "+ i.getestado());
    }



}
