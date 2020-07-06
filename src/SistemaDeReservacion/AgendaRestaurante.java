package SistemaDeReservacion;

import SistemaDeAutenticacion.Usuario;
import SistemaDeOrdenes.Orden;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class AgendaRestaurante {
    private ArrayList<Reservacion> reservacions;

    public AgendaRestaurante() {
        this.reservacions = new ArrayList<Reservacion>();
    }

    public ArrayList<Reservacion> getReservacions() {
        return reservacions;
    }

    public Reservacion buscarReservacion(Calendar fecha, String usuario){
        // Busca la reservacion la regresa, si no la encuentra
        // regresa null
        for (int i=0;i<reservacions.size();i++) {
            Reservacion reservacion = reservacions.get(i);
            // El metodo compareTo() devuelve 0 si son iguales.
            if ( reservacion.getFecha().compareTo(fecha) == 0 &&
                 reservacion.getUsuario().getNombre() == usuario){
                return reservacion;
            }
        }
        return null;
    }

    public boolean agregarReservacion(Reservacion nuevaReservacion){
        boolean regresar = true;
        try {
            reservacions.add(nuevaReservacion);
        }
        catch (Exception e) {
            System.out.println("ERROR: No se agrego la reservacion");
            regresar = false;
        }
        return regresar;
    }

    public boolean borrarReservacion(Calendar fecha, String nombre){
        // Busca la reservacion que tenga la misma "fecha" y
        // "nombre", si la encuentra se elimina y regresa true
        // sino regresa false
        boolean regresar = true;
        try {
            // Elimina el platillo con ID id
            // Iterator.remove()
            Iterator itr = reservacions.iterator();
            while (itr.hasNext())
            {
                Reservacion reservacion = (Reservacion) itr.next();
                if (reservacion.getFecha().compareTo(fecha) == 0 &&
                        reservacion.getUsuario().getNombre() == nombre)
                    itr.remove();
            }
        }
        catch (Exception e) {
            System.out.println("ERROR: No se borro la reservacion");
            regresar = false;
        }
        return regresar;
    }

    public boolean borrarReservacion(Reservacion elimReserv){
        // Busca la reservacion "elimReserv"
        // si la encuentra se elimina y regresa true
        // sino regresa false
        boolean regresar = true;
        try {
            // Elimina el platillo con ID id
            // Iterator.remove()
            Iterator itr = reservacions.iterator();
            while (itr.hasNext())
            {
                Reservacion reservacion = (Reservacion) itr.next();
                if ( reservacion == elimReserv)
                    itr.remove();
            }
        }
        catch (Exception e) {
            System.out.println("ERROR: No se borro la reservacion");
            regresar = false;
        }
        return regresar;
    }

    @Override
    public String toString() {
        String strResevacion = "";
        for (int i=0;i<reservacions.size();i++) {
            Reservacion reservacion = reservacions.get(i);
            strResevacion += reservacion.toString();
            }
        return "AgendaRestaurante:\n" +
                strResevacion;
    }
}
