package SistemaDePago;

import SistemaDeAutenticacion.Usuario;
import SistemaDeCarrito.Carrito;

public class GestorDePago {
    public GestorDePago() {
    }
    public Pago generarPago(Usuario user, float cuenta){
        Pago pago = new Pago(user, cuenta);
        return pago;
    }

    public Comprobante generarComprobante(Carrito carrito, Pago bill){
        Comprobante comprobante = new Comprobante(carrito, bill);
        return comprobante;
    }
}
