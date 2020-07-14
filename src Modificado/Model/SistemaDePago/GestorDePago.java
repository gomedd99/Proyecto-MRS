package Model.SistemaDePago;

import Model.SistemaDeAutenticacion.Usuario;
import Model.SistemaDeCarrito.Carrito;

public class GestorDePago {
    public GestorDePago() {
    }
    public Pago generarPago(Usuario user, float cuenta){
        Pago pago = new Pago(user, cuenta);
        pago.generarPago();
        return pago;
    }

    public Comprobante generarComprobante(Carrito carrito, Pago bill){
        Comprobante comprobante = new Comprobante(carrito, bill);
        return comprobante;
    }
}
