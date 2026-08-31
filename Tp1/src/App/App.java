package App;

public class App {

    public static void main(String[] args) {

        // a. Creamos uno o más eventos universitarios
        EventoUniversitario evento1 = new EventoUniversitario("E01", "Hackathon UNCuyo", 1500.0, false);
        EventoUniversitario evento2 = new EventoUniversitario("E02", "Charla de IA", 0.0, true);

        // b. Creamos una copia de cada evento usando el constructor de copia
        EventoUniversitario copiaEvento1 = new EventoUniversitario(evento1);
        EventoUniversitario copiaEvento2 = new EventoUniversitario(evento2);

        // c. Mostramos los datos de los eventos creados y sus copias
        System.out.println("--- Evento 1 (original) ---");
        evento1.mostrarDatos();

        System.out.println("\n--- Copia de Evento 1 ---");
        copiaEvento1.mostrarDatos();

        System.out.println("\n--- Evento 2 (original) ---");
        evento2.mostrarDatos();

        System.out.println("\n--- Copia de Evento 2 ---");
        copiaEvento2.mostrarDatos();

        // d. Mostramos el contador total de eventos creados
        System.out.println("\nCantidad total de eventos creados: " + EventoUniversitario.getCantidadEventos());
    }


}
