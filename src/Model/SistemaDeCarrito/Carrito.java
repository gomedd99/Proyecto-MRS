package Model.SistemaDeCarrito;

import Model.SistemaDeMenu.Platillo;

import java.util.ArrayList;
import java.util.Iterator;

public class Carrito {
    private ArrayList<Platillo> platillos;
    private float cuenta;


    public Carrito() {
        this.platillos = new ArrayList<Platillo>();
        this.cuenta = 0;
    }

    public ArrayList<Platillo> getPlatillos() {
        return platillos;
    }

    public Platillo getPlatillo(int id){
        // Regresa el platillo que tenga el id solicitado, si no
        // existe regresa null
        for (int i=0;i<platillos.size();i++) {
            Platillo p = platillos.get(i);
            if ( id == p.getId() ){
                return p;
            }
        }
        return null;
    }

    public boolean agregarPlatillos( Platillo nuevo_platillo) {
        boolean regresar = true;
        try {
            platillos.add(nuevo_platillo);
        }
        catch (Exception e) {
            System.out.println("ERROR: No se agrego el platillo");
            regresar = false;
        }
        actualizarCuenta();
        return regresar;
    }

    public boolean borrarPlatillo( int id ){
        boolean regresar = true;
        try {
            // Elimina el platillo con ID id
            // Iterator.remove()
            Iterator itr = platillos.iterator();
            while (itr.hasNext())
            {
                Platillo x = (Platillo)itr.next();
                if (x.getId() == id)
                    itr.remove();
            }
        }
        catch (Exception e) {
            System.out.println("ERROR: No se borro el platillo");
            regresar = false;
        }
        actualizarCuenta();
        return regresar;
    }

    private void actualizarCuenta() {
        // Actualiza la cuenta cada que se llama
        for (int i=0;i<platillos.size();i++) {
            Platillo p = platillos.get(i);
            cuenta += p.getCosto();
        }
    }

    public float getCuenta() {
        return cuenta;
    }

    public String platillosToString() {
        String strPlatillos = "";
        for (int i = 0; i < platillos.size(); i++) {
            Platillo p = platillos.get(i);
            strPlatillos += p.getNombre() + " " + p.getCosto() + " \n";
        }
        return strPlatillos; // return fuera de for
    }

    @Override
    public String toString(){
        return "Carrito:" +
                "\tPlatillos =" + platillosToString() +
                "\tA pagar: $ " + cuenta ;
    }
}
