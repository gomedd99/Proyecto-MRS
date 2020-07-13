package Model.SistemaDeOrdenes;

import Model.SistemaDeCarrito.Carrito;
import Model.SistemaDePago.Pago;

import java.io.IOException;

public class GestorOrdenes {

    private ListaOrdenes listaOrdenes;

    public GestorOrdenes() throws IOException {
        listaOrdenes = new ListaOrdenes();
    }

    public Orden generarOrden(Pago pago, Carrito carrito){

        Orden nuevaOrden = new Orden(pago, carrito);
        return nuevaOrden;
    }

    public boolean agregarOrden(Orden miOrden) throws IOException {
        // Agrega una orden dada.
        boolean x = listaOrdenes.agregarOrden( miOrden );
        if (x)
            listaOrdenes.guardarOrdenes();
        return x;
    }

    public boolean eliminarOrden(int id) throws IOException {
        boolean x = listaOrdenes.borrarOrden(id);
        if (x)
            listaOrdenes.guardarOrdenes();
        return x;
    }

    public boolean editarOrden(Pago pago, Carrito carrito, int id) throws IOException {
        boolean regresar = false;
        Orden aEditar = listaOrdenes.getOrden(id);

        if (aEditar != null) {
            listaOrdenes.borrarOrden(id);
            aEditar.setCarrito(carrito);
            aEditar.setPago(pago);
            regresar = listaOrdenes.agregarOrden(aEditar);
            listaOrdenes.guardarOrdenes();
        }
        return regresar;
    }

    public boolean actualizarEstado(int id, String estado) throws IOException {
        Orden orden = listaOrdenes.buscarOrden(id);
        if (orden != null ){
            listaOrdenes.borrarOrden(id);
            orden.setEstadoActual(estado);
            listaOrdenes.agregarOrden(orden);
            listaOrdenes.guardarOrdenes();
            return true;
        }
        return false;
    }

    public Orden verOrden(int id){
        return listaOrdenes.buscarOrden(id);
    }

    public String consultarEstado(int id){
        Orden orden = listaOrdenes.buscarOrden(id);
        return orden.getEstadoActual();
    }

    public String verOrdenes(){
        return listaOrdenes.verOdernes();
    }

}
