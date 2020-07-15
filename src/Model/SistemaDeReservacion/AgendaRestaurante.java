package Model.SistemaDeReservacion;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgendaRestaurante {

    private ArrayList<Reservacion> reservaciones;
    private String nombreArchivo ;

    private int cuentaDeReservaciones;


    public AgendaRestaurante() throws IOException {
        nombreArchivo = "AgendaRestaurante.bin";
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream( nombreArchivo );
            ois = new ObjectInputStream( fis );
            cuentaDeReservaciones = ois.read();
            reservaciones = (ArrayList) ois.readObject();
            fis.close();
        } catch(IOException | ClassNotFoundException e) {
            cuentaDeReservaciones = 0;
            reservaciones = new ArrayList<>();
        }finally{
            if (ois != null) {
                ois.close();
            }
        }
    }

    public int getCuentaDeReservaciones() {
        cuentaDeReservaciones++;
        return cuentaDeReservaciones;
    }

    public ArrayList<Reservacion> getReservacions() {
        return reservaciones;
    }

    public Reservacion buscarReservacion(Calendar fecha, String usuario){
        // Busca la reservacion la regresa, si no la encuentra
        // regresa null
        Reservacion regresar = null;
        for (int i=0; i<reservaciones.size(); i++) {
            Reservacion reservacion = reservaciones.get(i);
            // El metodo compareTo() devuelve 0 si son iguales

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            int anio_reservacion = reservacion.getFecha().get(Calendar.YEAR);
            int mes_reservacion = reservacion.getFecha().get(Calendar.MONTH);
            int dia_reservacion = reservacion.getFecha().get(Calendar.DATE);

            int anio_busqueda = fecha.get(Calendar.YEAR);
            int mes_busqueda = fecha.get(Calendar.MONTH);
            int dia_busqueda = fecha.get(Calendar.DATE);

            boolean anio_igual = (anio_busqueda == anio_reservacion);
            boolean mes_igual = (mes_busqueda == mes_reservacion);
            boolean dia_igual = (dia_busqueda == dia_reservacion);

            if ( anio_igual && mes_igual &&  dia_igual &&
                 reservacion.getUsuario().getNombre().equals(usuario)){
                regresar = reservacion;
                break;
            }
        }
        return regresar;
    }

    public Reservacion buscarReservacion(int id){
        // Busca la reservacion la regresa, si no la encuentra
        // regresa null
        Reservacion regresar = null;
        for (Reservacion reservacion : reservaciones) {
            // El metodo compareTo() devuelve 0 si son iguales.
            if (reservacion.getId() == id) {
                regresar = reservacion;
                break;
            }
        }
        return regresar;
    }

    public boolean agregarReservacion(Reservacion nuevaReservacion){
        boolean regresar = true;
        cuentaDeReservaciones++;
        if ( !reservaciones.add(nuevaReservacion)){
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
            Iterator itr = reservaciones.iterator();
            while (itr.hasNext())
            {
                Reservacion reservacion = (Reservacion) itr.next();
                if (reservacion.getFecha().compareTo(fecha) == 0 &&
                        reservacion.getUsuario().getNombre() == nombre) {
                    itr.remove();
                    cuentaDeReservaciones--;
                }
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
            Iterator itr = reservaciones.iterator();
            while (itr.hasNext())
            {
                Reservacion reservacion = (Reservacion) itr.next();
                if ( reservacion == elimReserv) {
                    itr.remove();
                    cuentaDeReservaciones--;
                }
            }
        }
        catch (Exception e) {
            System.out.println("ERROR: No se borro la reservacion");
            regresar = false;
        }
        return regresar;
    }

    public Boolean guardarAgenda()throws IOException {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream( nombreArchivo );
            oos = new ObjectOutputStream( fos );
            oos.write( cuentaDeReservaciones );
            oos.writeObject( reservaciones );
            fos.close();
        } catch(IOException e) {
            System.out.println("\nMISSING: AgendaRestaurante.bin en guardarAgenda()");
            return false;
        }finally{
            if (oos != null) {
                oos.close();
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String strResevacion = "";
        for (int i=0; i<reservaciones.size(); i++) {
            Reservacion reservacion = reservaciones.get(i);
            strResevacion += reservacion.toString();
            }
        return "AgendaRestaurante:\n" +
                strResevacion;
    }
}
