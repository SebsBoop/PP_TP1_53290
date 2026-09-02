package Ejercicio3;

public abstract class Charla extends Actividad {
    private String disertante;

    public Charla(int id, String titulo, int cupoMaximo, String disertante) {
        super(id, titulo, cupoMaximo);
        this.disertante = disertante;
    }
    public double calcularCostosMateriales(){

        return 0.0;
    }
    public String getTipo(){

        return "Charla";
    }
}
