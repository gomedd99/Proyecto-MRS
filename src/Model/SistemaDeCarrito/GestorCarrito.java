package Model.SistemaDeCarrito;

import Model.SistemaDeInventario.GestorInventario;
import Model.SistemaDeMenu.GestorDeMenu;
import Model.SistemaDeMenu.Platillo;
import Model.SistemaDeOrdenes.GestorOrdenes;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GestorCarrito {
    private Carrito carrito;

    public GestorCarrito() {
        // inicia el carrito en null
        carrito = new Carrito();
    }

    public boolean agregarPatillo(int id) throws IOException, FileNotFoundException, ClassNotFoundException {
        // Agrega un solo platillo al carrito
        GestorInventario gestorInventario = new GestorInventario();
        boolean regresar = false;
        GestorDeMenu gestorMenu = new GestorDeMenu();
        Platillo platillo = gestorMenu.getPlatillo(id); // Este debe comprobar si hay existencia del platillo
        if ( platillo != null && gestorInventario.agregarAlCarrito(platillo) ) {
            carrito.agregarPlatillos(platillo);
            regresar = true;
        }
        return regresar;
    }

    public boolean eliminarPatillo(int id) throws IOException, FileNotFoundException, ClassNotFoundException {
        // Borra un platillo con "id"
        GestorInventario gInventario = new GestorInventario();
        gInventario.borrarDelCarrito(carrito.getPlatillo(id));
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
