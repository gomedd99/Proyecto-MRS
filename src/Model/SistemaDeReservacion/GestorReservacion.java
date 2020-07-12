package Model.SistemaDeReservacion;

import Model.SistemaDeAutenticacion.Usuario;

import java.io.IOException;
import java.util.Calendar;

public class GestorReservacion {

    private AgendaRestaurante agendaRestaurante;

    public GestorReservacion() throws IOException {
        agendaRestaurante = new AgendaRestaurante();
    }

    public Reservacion crearReservacion(Calendar aReservar , Usuario cliente){
        // Regresa null cuando no es posible hacer la reservacion, porque el dia no es valido
        Reservacion nueva = null;

        Calendar hoy = Calendar.getInstance();

        // valor MENOR a 0 => aReservar es antes de "hoy"
        // valor MAYOR a 0 => aReservar es despues de "hoy"
        // valor = 0 => es la misma fecha
        if ( aReservar.compareTo(hoy) > 0 ){
            // la reservacion sí es despues de "hoy", es valida
            nueva = new Reservacion(aReservar, cliente);
            agendaRestaurante.agregarReservacion(nueva); // agrega la reservacion a la agenda
        }

        return nueva;
    }

    public Reservacion verReservacion(int id){
        // Si encuentra la reservacion en con el id dado en la agenda, la regresa
        // sino regresa null
        Reservacion regresar = null;
        Reservacion buscada = agendaRestaurante.buscarReservacion(id);
        if (buscada != null){
            regresar = buscada;
        }
        return regresar;
    }

    public Reservacion verReservacion(Calendar aBuscar, String usuario){
        // Si encuentra la reservacion con dicha fecha y a nombre del usuario, la regresa
        // sino regresa null

        Reservacion regresar = null;
        Reservacion buscada = agendaRestaurante.buscarReservacion(aBuscar, usuario);
        if (buscada != null){
            regresar = buscada;
        }
        return regresar;
    }

    public boolean eliminarReservacion( int id ){
        // Borra la reservacion de la agenda, dado un id
        // si no encuentra una reservacion con dicho id regresa null
        boolean regresar = false;
        Reservacion aEliminar = agendaRestaurante.buscarReservacion(id);
        if ( aEliminar != null){
            if ( agendaRestaurante.borrarReservacion(aEliminar) ){
                regresar = true;
            }
        }
        return regresar;
    }

    public boolean eliminarReservacion( Calendar fechaPaEliminar , String usuario){
        // Borra la reservacion de la agenda que coincida con los datos dados
        // si no encuentra una reservacion con dicho id regresa null
        boolean regresar = false;

        Reservacion aEliminar = agendaRestaurante.buscarReservacion(fechaPaEliminar, usuario);

        if ( aEliminar != null){
            if ( agendaRestaurante.borrarReservacion(aEliminar) ){
                regresar = true;
            }
        }
        return regresar;
    }

    public Reservacion modificarReservacion(Calendar nuevaFecha, int id){
        // modifica la reservacion con "id" por la fecha dada.
        // regresa true si se hizo el cambio, sino regresa false

        Reservacion aModificar = agendaRestaurante.buscarReservacion(id);
        agendaRestaurante.borrarReservacion(aModificar);

        // si la fecha es valida entonces se agrega a la agenda
        if ( aModificar.setFecha(nuevaFecha) ){
            agendaRestaurante.agregarReservacion(aModificar);
            return aModificar;
        }
        return null;
    }

    public String verReservaciones(){
        return agendaRestaurante.toString();
    }


}
