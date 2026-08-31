package App;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
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

    public static int getCantidadEventos() {
        return cantidadEventos;
    }


}
