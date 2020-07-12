package Model.SistemaDeCarrito;

import Model.SistemaDeMenu.Platillo;

import java.util.ArrayList;

public class GestorCarrito {
    private Carrito carrito;

    public GestorCarrito() {
        // inicia el carrito en null
        carrito = null;
    }

    public Carrito generarCarrito(ArrayList<Platillo> platillos){
        // Crea un carrito nuevo en this.carrito
        // Se puede usar para vaciar el carrito
        carrito = new Carrito(platillos);
        return carrito;
    }

    public boolean agregarPatillos(ArrayList<Platillo> platillos) {
        // Agrega una lista de platillos al carrito
        boolean regresar = true;
        for (int i=0;i<platillos.size();i++) {
            Platillo p = platillos.get(i);
            regresar = carrito.agregarPlatillos(p);
        }
        return regresar;
    }

    public boolean agregarPatillo(Platillo platillo) {
        // Agrega un solo platillo al carrito
        return carrito.agregarPlatillos(platillo);
    }

    public boolean eliminarPatillo(int id) {
        // Borra un platillo con "id"
        return carrito.borrarPlatillo(id);
    }

    public float extraerCuenta(){
        // Regresa la cuenta $$ del carrito
        return carrito.getCuenta();
    }

    public Carrito getCarrito() {
        // Regresa el carrito actual
        return carrito;
    }

    public String toStringCarrito() {
        return carrito.toString();
    }
}
