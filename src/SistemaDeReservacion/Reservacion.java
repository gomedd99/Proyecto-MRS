package SistemaDeReservacion;

import SistemaDeAutenticacion.Usuario;
import SistemaDeCarrito.Carrito;

import java.util.Calendar;

public class Reservacion {
    private Calendar fecha;
    Usuario cliente;

    private static int cuentaReservaciones;
    public int id;


    public Reservacion(Calendar fecha, Usuario cliente) {
        this.fecha = fecha;
        this.cliente = cliente;
        cuentaReservaciones++;
        id = cuentaReservaciones;
    }

    public Usuario getUsuario() {
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
        return "Reservacion #: " + id  +
                "\nFecha: " + fecha.getTime() +
                "\nA nombre de " + cliente +
                '\n';
    }
}
