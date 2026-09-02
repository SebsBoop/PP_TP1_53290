package Ejercicio3;

public class Taller extends Actividad {
    Boolean requiereNotebook;

    public Taller (Boolean requiereNotebook, int id, String titulo, int cupoMaximo){

        super(id, titulo, cupoMaximo);
        this.requiereNotebook  = requiereNotebook;
    }

    public double calcularCostoMateriales() {
        if (requiereNotebook) {
            return 5000;
        }
    return 2000;
    }

    public String getTipo(){

        return "Taller";
    }
}
