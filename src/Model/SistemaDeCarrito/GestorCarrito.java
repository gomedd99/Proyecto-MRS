package Model.SistemaDeCarrito;

import Model.SistemaDeMenu.Platillo;

import java.util.ArrayList;

public class GestorCarrito {
    private Carrito carrito;

    public GestorCarrito() {
        // inicia el carrito en null
        carrito = new Carrito();
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
