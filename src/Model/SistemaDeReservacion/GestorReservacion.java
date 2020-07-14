package Model.SistemaDeReservacion;


import Model.SistemaDeUsuario.Usuarios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class GestorReservacion {

    private AgendaRestaurante agendaRestaurante;

    public GestorReservacion() throws IOException {
        agendaRestaurante = new AgendaRestaurante();
    }

    public Reservacion crearReservacion(Calendar aReservar , Usuarios cliente) throws IOException {
        // Regresa null cuando no es posible hacer la reservacion, porque el dia no es valido
        Reservacion nueva = null;

        Calendar hoy = Calendar.getInstance();

        // valor MENOR a 0 => aReservar es antes de "hoy"
        // valor MAYOR a 0 => aReservar es despues de "hoy"
        // valor = 0 => es la misma fecha
        if ( aReservar.compareTo(hoy) > 0 ){
            // la reservacion sí es despues de "hoy", es valida
            nueva = new Reservacion(aReservar, cliente, agendaRestaurante.getCuentaDeReservaciones());
            agendaRestaurante.agregarReservacion(nueva); // agrega la reservacion a la agenda
            agendaRestaurante.guardarAgenda();
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

    public boolean eliminarReservacion( int id ) throws IOException {
        // Borra la reservacion de la agenda, dado un id
        // si no encuentra una reservacion con dicho id regresa null
        boolean regresar = false;
        Reservacion aEliminar = agendaRestaurante.buscarReservacion(id);
        if ( aEliminar != null){
            if ( agendaRestaurante.borrarReservacion(aEliminar) ){
                agendaRestaurante.guardarAgenda();
                regresar = true;
            }
        }
        return regresar;
    }

    public boolean eliminarReservacion( Calendar fechaPaEliminar , String usuario) throws IOException {
        // Borra la reservacion de la agenda que coincida con los datos dados
        // si no encuentra una reservacion con dicho id regresa null
        boolean regresar = false;

        Reservacion aEliminar = agendaRestaurante.buscarReservacion(fechaPaEliminar, usuario);

        if ( aEliminar != null){
            if ( agendaRestaurante.borrarReservacion(aEliminar) ){
                agendaRestaurante.guardarAgenda();
                regresar = true;
            }
        }
        return regresar;
    }

    public Reservacion modificarReservacion(Calendar nuevaFecha, int id) throws IOException {
        // modifica la reservacion con "id" por la fecha dada.
        // regresa true si se hizo el cambio, sino regresa false

        Reservacion aModificar = agendaRestaurante.buscarReservacion(id);
        agendaRestaurante.borrarReservacion(aModificar);

        // si la fecha es valida entonces se agrega a la agenda
        if ( aModificar.setFecha(nuevaFecha) ){
            agendaRestaurante.agregarReservacion(aModificar);
            agendaRestaurante.guardarAgenda();
            return aModificar;
        }
        return null;
    }

    public String verReservacionesHoy(){
        ArrayList<Reservacion> reservaciones = agendaRestaurante.getReservacions();
        // Regresa solo las reservaciones de hoy en adelante
        Calendar hoy = Calendar.getInstance();
        String regresar = " ";
        for (Reservacion reservacion : reservaciones) {
            try {
                // El metodo compareTo() devuelve 0 si son iguales.
                // El método compareTo() devuelve 1 si el "hoy" es mayor que el "fecha"
                Calendar fecha = reservacion.getFecha();
                if(fecha.compareTo(hoy) == 0){
                    regresar += fecha.toString();
                }
            }catch (Exception e){}

        }
        return regresar;
    }


    public String verReservacionesProximas(){
        ArrayList<Reservacion> reservaciones = agendaRestaurante.getReservacions();
        // Regresa solo las reservaciones de hoy en adelante
        Calendar hoy = Calendar.getInstance();
        String regresar = " ";
        for (Reservacion reservacion : reservaciones) {
            try{
                // El metodo compareTo() devuelve 0 si son iguales.
                // El método compareTo() devuelve 1 si el "hoy" es mayor que el "nuevaFecha".
                Calendar fecha = reservacion.getFecha();
                if(fecha.compareTo(hoy) >= 0){
                    regresar += "\n" +reservacion.toString();
                }
            }
            catch (Exception e){}
        }
            return regresar;
    }

    public String verAgenda(){
        return agendaRestaurante.toString();
    }


}
