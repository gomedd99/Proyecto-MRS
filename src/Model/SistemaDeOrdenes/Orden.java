package Model.SistemaDeOrdenes;

import Model.SistemaDeCarrito.Carrito;
import Model.SistemaDePago.Pago;

import java.io.Serializable;

public class Orden implements Serializable {
    private Pago bill;
    private Carrito Productos;

    public int id;

    private String estadoActual;

    public Orden(Pago pago, Carrito carrito, int id) {
        bill = pago;
        Productos = carrito;
        this.id = id;
        estadoActual = "En lista"; // En lista, En preparacion, LISTO!
    }

    public Boolean verificarPago() {
        // falta implementar
        return bill.getPago();
    }

    public Carrito getCarrito() {
        return Productos;
    }

    public void setCarrito(Carrito productos) {
        Productos = productos;
    }

    public Pago getPago() {
        return bill;
    }

    public void setPago(Pago bill) {
        this.bill = bill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    @Override
    public String toString() {
        return "\nOrden: #" + id +
                "Estado" + estadoActual +
                "Pago =" + bill.getCuenta() +
                ", Productos =" + Productos.toString();
    }

}
