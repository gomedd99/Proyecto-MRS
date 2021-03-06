package Model.SistemaDePago;


import Model.SistemaDeCarrito.Carrito;
import Model.SistemaDeUsuario.Usuarios;

public class GestorDePago {
    public GestorDePago() {
    }
    public Pago generarPago(Usuarios user, float cuenta){
        Pago pago = new Pago(user, cuenta);
        pago.generarPago();
        return pago;
    }

    public Comprobante generarComprobante(Carrito carrito, Pago bill){
        Comprobante comprobante = new Comprobante(carrito, bill);
        return comprobante;
    }
}
