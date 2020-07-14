package Model.SistemaDeReservacion;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class AgendaRestaurante {

    private ArrayList<Reservacion> reservaciones;
    private String nombreArchivo ;

    public AgendaRestaurante() throws FileNotFoundException, IOException {
        nombreArchivo = "AgendaRestaurante.bin";
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream( nombreArchivo );
            ois = new ObjectInputStream( fis );
            reservaciones = (ArrayList) ois.readObject();
            fis.close();
        } catch(IOException | ClassNotFoundException e) {
            reservaciones = new ArrayList<>();
        }finally{
            if (ois != null) {
                ois.close();
            }
        }
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
            // El metodo compareTo() devuelve 0 si son iguales.
            if ( reservacion.getFecha().compareTo(fecha) == 0 &&
                 reservacion.getUsuario().getNombre() == usuario){
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
            Iterator itr = reservaciones.iterator();
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

    public Boolean guardarAgenda()throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream( nombreArchivo );
            oos = new ObjectOutputStream( fos );
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
