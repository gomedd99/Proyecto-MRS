package SistemaDeOrdenes;

import SistemaDeCarrito.Carrito;
import SistemaDePago.Pago;

public class Orden {
    private Pago bill;
    private Carrito Productos;
    private static int cuenta_ordenes;
    public int id;

    public Orden(Pago pago, Carrito carrito) {
        bill = pago;
        Productos = carrito;
        cuenta_ordenes++;
        id = cuenta_ordenes;
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

    @Override
    public String toString() {
        return "Orden: #" + id +
                "Pago =" + bill.getCuenta() +
                ", Productos =" + Productos.toString() +
                '\n';
    }

}
