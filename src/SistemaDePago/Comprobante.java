package SistemaDePago;

import SistemaDeCarrito.Carrito;

public class Comprobante {
    private Carrito carrito;
    private Pago pago; // EL comprobante esta asociado a un pago
    private String info;


    public Comprobante(Carrito carrito, Pago pago) { // Es una agregacion, NO una composicion
        this.carrito = carrito;
        this.pago = pago;
        info =  "\nComprobante: Pago #" + pago.getId() +
                "\nTitular: " + pago.getUsuario().getNombre() +
                "\nPlatillos: " + carrito.platillosToString() +
                "\nTOTAL: " + pago;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return info;
    }
}
