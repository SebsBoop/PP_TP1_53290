package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {

    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos;
    private Sala sala;
    private List<Actividad> actividades;


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
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    public double calcularCostoEstimado() {
        if (gratuito) {
            return 0.0;
        }

        double costoActividades = 0.0;
        for (Actividad a : actividades) {
            costoActividades += a.calcularCostoMateriales();
        }

        return (costoBase + costoActividades) * 1.21;
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public void crearActividad(String tipo, int id, String titulo, int cupo, String disertante, boolean requiereNotebook) {
        Actividad nuevaActividad;

        if (tipo.equals("Charla")) {
            nuevaActividad = new Charla(id, titulo, cupo, disertante) {
                @Override
                public double calcularCostoMateriales() {
                    return 0;
                }
            };
        } else if (tipo.equals("Taller")) {
            nuevaActividad = new Taller(requiereNotebook, id, titulo, cupo) {
                @Override
                public double calcularCostoMateriales() {
                    return 0;
                }
            };
        } else {
            System.out.println("Tipo de actividad no reconocido: " + tipo);
            return;
        }

        actividades.add(nuevaActividad);
    }

    public void mostrarDatos() {
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Costo base: " + costoBase);
        System.out.println("Gratuito: " + gratuito);
        System.out.println("Costo estimado: " + calcularCostoEstimado());

        if (sala != null) {
            System.out.println("Sala asignada: " + sala.getNombre());
        }

        System.out.println("Actividades del evento:");
        for (Actividad a : actividades) {
            a.mostrarIdentificacion(); // polimorfismo: cada actividad muestra su propia identificación
        }
    }

    public String getTitulo() {
        return titulo;
    }



    public List<Actividad> getActividades() {
        return actividades;
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }
}