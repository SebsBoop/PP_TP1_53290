package Ejercicio1;

public class EventoUniversitario {

    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos;

    // Constructor principal
    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++;
    }

    // Constructor de copia
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
        System.out.println("Título: " + titulo);
        System.out.println("Costo base: " + costoBase);
        System.out.println("Gratuito: " + gratuito);
        System.out.println("Costo estimado: " + calcularCostoEstimado());
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }
}