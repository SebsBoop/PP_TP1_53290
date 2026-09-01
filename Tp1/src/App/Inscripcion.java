import java.time.LocalDate;

public class Inscripcion {
    LocalDate fecha;
    String estado;

    public Inscripcion(String estado, LocalDate fecha){

        this.fecha = fecha;
        this.estado = estado;
    }

    public String getestado(){
        return estado;
    }

    public LocalDate getFecha(){

        return fecha;
    }
}
