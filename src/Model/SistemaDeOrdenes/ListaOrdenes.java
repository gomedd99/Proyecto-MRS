package Model.SistemaDeOrdenes;

import Model.SistemaDeReservacion.Reservacion;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaOrdenes {
    private ArrayList<Orden> ordenes;
    private String nombreArchivo;

    public ListaOrdenes() throws IOException {
        nombreArchivo = "ListaOrdenes.bin";
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream( nombreArchivo );
            ois = new ObjectInputStream(fis);
            ordenes = (ArrayList<Orden>) ois.readObject();
            fis.close();
        } catch(IOException | ClassNotFoundException e) {
            ordenes = new ArrayList<Orden>();
        }finally{
            if (ois != null) {
                ois.close();
            }
        }
    }

    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }

    public Orden getOrden(int id){
        for (int i=0;i<ordenes.size();i++) {
            Orden orden = ordenes.get(i);
            if ( id == orden.getId() ){
                return orden;
            }
        }
        return null;
    }

    public boolean agregarOrden(Orden nuevaOrden){
        boolean regresar = true;
        try {
            ordenes.add(nuevaOrden);
        }
        catch (Exception e) {
            System.out.println("ERROR: No se agrego la orden");
            regresar = false;
        }
        return regresar;
    }

    public boolean borrarOrden(int id){
        boolean regresar = true;
        try {
            // Elimina el platillo con ID id
            // Iterator.remove()
            Iterator itr = ordenes.iterator();
            while (itr.hasNext())
            {
                Orden x = (Orden) itr.next();
                if (x.getId() == id)
                    itr.remove();
            }
        }
        catch (Exception e) {
            System.out.println("ERROR: No se borro la orden");
            regresar = false;
        }
        return regresar;
    }

    public Orden buscarOrden(int id){
        Orden regresar = null;
        try {
            // Elimina el platillo con ID id
            // Iterator.remove()
            for (Orden x : ordenes) {
                if (x.getId() == id)
                    regresar = x;
            }
        }
        catch (Exception e) {
            System.out.println("ERROR: No se borro la orden");
        }
        return regresar;
    }

    public Boolean guardarOrdenes()throws IOException {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream( nombreArchivo );
            oos = new ObjectOutputStream( fos );
            oos.writeObject( ordenes );
            fos.close();
        } catch(IOException e) {
            System.out.println("MISSING: ListaOrdenes.bin en guardarOrdenes()");
            return false;
        }finally{
            if (oos != null) {
                oos.close();
            }
        }
        return true;
    }

    public String verOdernes(){
        // Regresa las ordenes que no han sido completadas
        String regresar = "";
        for (Orden x : ordenes) {
            try {
                if (x.getEstadoActual() != "LISTA!")
                    regresar = x.toString();
            }
            catch (Exception e){}
        }
        return regresar;
    }

    @Override
    public String toString() {
        String strOrdenes = "";
        for (int i = 0; i < ordenes.size(); i++) {
            Orden orden = ordenes.get(i);
            strOrdenes += orden.toString();
        }

        return "Lista de Ordenes:" +
                 strOrdenes;
    }
}
