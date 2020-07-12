package Model.SistemaDeOrdenes;

import Model.SistemaDeCarrito.Carrito;
import Model.SistemaDePago.Pago;

public class GestorOrdenes {

    private ListaOrdenes listaOrdenes;

    public GestorOrdenes(ListaOrdenes listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }

    public Orden generarOrden(Pago pago, Carrito carrito){

        Orden nuevaOrden = new Orden(pago, carrito);

        return nuevaOrden;
    }

    public boolean agregarOrden(Pago pago, Carrito carrito){
        return listaOrdenes.agregarOrden( generarOrden(pago, carrito) );
    }

    public boolean eliminarOrden(int id){
        return listaOrdenes.borrarOrden(id);
    }

    public boolean editarOrden(Pago pago, Carrito carrito, int id) {
        boolean regresar = false;
        Orden aEditar = listaOrdenes.getOrden(id);

        if (aEditar != null) {
            listaOrdenes.borrarOrden(id);
            aEditar.setCarrito(carrito);
            aEditar.setPago(pago);
            regresar = listaOrdenes.agregarOrden(aEditar);
        }
        return regresar;
    }

    public String verOrdenes(){
        return listaOrdenes.toString();
    }

}
