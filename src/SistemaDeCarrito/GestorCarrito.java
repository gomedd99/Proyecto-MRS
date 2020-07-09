package SistemaDeCarrito;

import SistemaDeAutenticacion.Usuario;
import SistemaDeMenu.Platillo;

import java.util.ArrayList;

public class GestorCarrito {
    private Carrito carrito;

    public GestorCarrito() {
        // inicia el carrito en null
        carrito = null;
    }

    public Carrito generarCarrito(ArrayList<Platillo> platillos){
        // crea un carrito nuevo
        carrito = new Carrito(platillos);
        return carrito;
    }

    public boolean agregarPatillos(ArrayList<Platillo> platillos) {
        boolean regresar = true;
        for (int i=0;i<platillos.size();i++) {
            Platillo p = platillos.get(i);
            regresar = carrito.agregarPlatillos(p);
        }
        return regresar;
    }

    public boolean eliminarPatillo(int id) {
        return carrito.borrarPlatillo(id);
    }

    public float extraerCuenta(){
        return carrito.getCuenta();
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public String toStringCarrito() {
        return carrito.toString();
    }
}
