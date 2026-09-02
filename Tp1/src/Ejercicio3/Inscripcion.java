package Ejercicio3;

import java.time.LocalDate;

public class Inscripcion {
    LocalDate fecha;
    String estado;

    public Inscripcion(String estado, LocalDate fecha){

        this.fecha = fecha;
        this.estado = estado;
    }

    public Inscripcion(LocalDate now, String confirmada) {
    }

    public String getestado(){
        return estado;
    }

    public LocalDate getFecha(){

        return fecha;
    }

    public String getEstado() {

        return "Estado: "+getestado();
    }

}
