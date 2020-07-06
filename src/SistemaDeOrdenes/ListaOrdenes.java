package SistemaDeOrdenes;

import SistemaDeMenu.Platillo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaOrdenes {
    private ArrayList<Orden> ordenes;

    public ListaOrdenes() {
        this.ordenes = new ArrayList<Orden>();
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

    @Override
    public String toString() {
        String strOrdenes = "";
        for (int i = 0; i < ordenes.size(); i++) {
            Orden orden = ordenes.get(i);
            strOrdenes += orden.toString();
        }

        return "ListaOrdenes{" +
                 strOrdenes +
                '}';
    }
}
