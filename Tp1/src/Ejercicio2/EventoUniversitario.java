package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private Sala sala;
    private List<Actividad> actividades;
    private static int cantidadEventos;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;

    }

    public EventoUniversitario(EventoUniversitario otro) {

        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        cantidadEventos++;
    }

    public double calcularCostoEstimado() {
        if (gratuito) {
            return 0.0;
        }
        return costoBase;
    }

    public void mostrarDatos() {

        System.out.println("ID: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Gratuito: " + gratuito);
        System.out.println("Costo Base: " + costoBase);
        System.out.println("Costo Estimado: " + calcularCostoEstimado());

    }

    public void asignarSala(Sala sala){

        this.sala = sala;

    }

    public void crearActividad(int id, String titulo, int cupo) {
        Actividad nuevaActividad = new Actividad(id, titulo, cupo);
        actividades.add(nuevaActividad);
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public static int getCantidadEventos() {


        return cantidadEventos;

    }


}
