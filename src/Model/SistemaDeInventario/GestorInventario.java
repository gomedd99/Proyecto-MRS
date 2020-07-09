public class GestorInventario {


	public GestorInventario() {
	}

    public Boolean infoMenu(Platillo plato){
        Inventario inve = new Inventario();
        for (int i; i < plato.getElementos() ; i++ ) {
            if (!(inve.getProducto(plato.getIngrediente(i).getId()).comprobarExistensias(plato.getRecursos(i)))) {
                return false;
            }
        }
        return true;
    }

    public Boolean agregarAlCarrito(Platillo plato){
        Inventario inve = new Inventario();
        for (int i; i < plato.getElementos() ; i++ ) {
            if (!(inve.getProducto(plato.getIngrediente(i).getId()).disExistensias(plato.getRecursos(i)))) {
                return false;
            }
        }
        inve.guardarInventario();
        return true;
    }

    public Boolean borrarDelCarrito(Platillo plato){
        Inventario inve = new Inventario();
        for (int i = 0;i < plato.getElementos() ; i++) {
            inve.getProducto(plato.getIngrediente(i).getId()).agregarExistencias(plato.getRecursos(i));
        }
        inve.guardarInventario();
    }

}
