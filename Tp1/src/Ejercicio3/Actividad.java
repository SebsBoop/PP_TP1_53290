package Ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {

    private int id;
    private String titulo;
    private int cupoMaximo;
    public static final int CUPO_MINIMO = 5;
    private List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    public Inscripcion inscribir(Estudiante estudiante) {
        Inscripcion nuevaInscripcion = new Inscripcion(LocalDate.now(), "Confirmada");
        inscripciones.add(nuevaInscripcion);
        return nuevaInscripcion;
    }

    public void mostrarInscripciones() {
        System.out.println("Inscripciones de la actividad: " + titulo);
        for (Inscripcion i : inscripciones) {
            System.out.println("Fecha: " + i.getFecha() + " - Estado: " + i.getEstado());
        }
    }

    public final void mostrarIdentificacion() {
        System.out.println("Tipo: " + getTipo());
        System.out.println("Id de Actividad: " + id);
        System.out.println("Titulo de Actividad: " + titulo);
    }

    public abstract double calcularCostoMateriales();
    public abstract String getTipo();

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }
}