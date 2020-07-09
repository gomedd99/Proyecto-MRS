package SistemaDeReservacion;

import SistemaDeAutenticacion.Usuario;

import java.util.Calendar;

public class GestorReservacion {

    private AgendaRestaurante agendaRestaurante;

    public GestorReservacion(AgendaRestaurante agendaRestaurante) {
        this.agendaRestaurante = agendaRestaurante;
    }

    public Reservacion crearReservacion(int año, int mes, int dia, int hora, int min, Usuario cliente){
        // Regresa null cuando no es posible hacer la reservacion, porque el dia no es valido
        Reservacion nueva = null;

        Calendar aReservar = Calendar.getInstance();
        aReservar.set(año, mes, dia, hora, min, 0);

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

    public Reservacion verReservacion(int año, int mes, int dia, int hora, int min, String usuario){
        // Si encuentra la reservacion con dicha fecha y a nombre del usuario, la regresa
        // sino regresa null
        Calendar aBuscar = Calendar.getInstance();
        aBuscar.set(año, mes, dia, hora, min, 0);

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

    public boolean eliminarReservacion( int año, int mes, int dia, int hora, int min, String usuario){
        // Borra la reservacion de la agenda que coincida con los datos dados
        // si no encuentra una reservacion con dicho id regresa null
        boolean regresar = false;
        Calendar fecha_a_Eliminar = Calendar.getInstance();
        fecha_a_Eliminar.set(año, mes, dia, hora, min, 0);

        Reservacion aEliminar = agendaRestaurante.buscarReservacion(fecha_a_Eliminar, usuario);

        if ( aEliminar != null){
            if ( agendaRestaurante.borrarReservacion(aEliminar) ){
                regresar = true;
            }
        }
        return regresar;
    }

    public boolean modificarReservacion(int año, int mes, int dia, int hora, int min, int id){
        // modifica la reservacion con "id" por la fecha dada.
        // regresa true si se hizo el cambio, sino regresa false
        boolean regresar = false;

        Reservacion aModificar = agendaRestaurante.buscarReservacion(id);
        agendaRestaurante.borrarReservacion(aModificar);

        Calendar nuevaFecha = Calendar.getInstance();
        nuevaFecha.set(año, mes, dia, hora, min, 0);

        // si la fecha es valida entonces se agrega a la agenda
        if ( aModificar.setFecha(nuevaFecha) ){
            regresar = agendaRestaurante.agregarReservacion(aModificar);
        }

        return regresar;

    }

    public String verReservaciones(){
        return agendaRestaurante.toString();
    }


}
