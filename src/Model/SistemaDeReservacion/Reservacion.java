package Model.SistemaDeReservacion;


import Model.SistemaDeUsuario.Usuarios;

import java.io.Serializable;
import java.util.Calendar;

public class Reservacion implements Serializable {
    private Calendar fecha;
    Usuarios cliente;

    public int id;


    public Reservacion(Calendar fecha, Usuarios cliente, int id) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.id = id;
    }

    public Usuarios getUsuario() {
        return cliente;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public boolean setFecha(Calendar nuevaFecha) {
        Calendar hoy = Calendar.getInstance();
        // El método compareTo() devuelve 1 si el "hoy"
        // es mayor que el "nuevaFecha"
        if(hoy.compareTo(nuevaFecha) > 0){
            return false;
        }
        else{
            this.fecha = nuevaFecha;
            return true;
        }
    }

    public int getId() {
        return id;
    }

    public boolean setId(int id) {
        this.id = id;
        return true;
    }

    @Override
    public String toString() {
        return "Reservacion ID: " + id  +
                "\nFecha: " + fecha.getTime() +
                //"\nA nombre de " + cliente + // COMENTAR AL PROBAR
                '\n';
    }
}
