public class Gestor Inventario {


	public Gestor Inventario() {
	}

    public Boolean infoMenu(Platillo plato){
        Inventario inven = new  Inventario();
        for (int i; i < plato.getElementos() ; i++ ) {
            if (!(inven.getProducto(plato.getIngrediente(i).getId()).comprobarExistensias(plato.getRecursos(i)))) {
                return false;
            }
        }
        return true;
    }

    public Boolean agregarAlCarrito(Platillo plato){
        Inventario inven = new  Inventario();
        for (int i; i < plato.getElementos() ; i++ ) {
            if (!(inven.getProducto(plato.getIngrediente(i).getId()).disExistensias(plato.getRecursos(i)))) {
                return false;
            }
        }
        inven.guardar Inventario();
        return true;
    }

    public Boolean borrarDelCarrito(Platillo plato){
        Inventario inven = new  Inventario();
        for (int i = 0;i < plato.getElementos() ; i++) {
            inven.getProducto(plato.getIngrediente(i).getId()).agregarExistencias(plato.getRecursos(i));
        }
        inven.guardar Inventario();
    }

	public String modificar Inventario(int selection){
		Inventario inven = new  Inventario();
		switch (selection) {
			case 1:
				return inven.listaProductos();
				break;
			case 2:
				return inven.listaProductosReponerse();
				break;
			default:
				return "No se eligio una opcion correcta\n";
				break;
		}
		return "Error";
	}

	public Boolean agregarProducto(String Nombre,int existencias){
		Boolean regreso = false;
		Inventario inven = new  Inventario();
	 	regreso = inven.agregarNuevoProducto(new Producto(Nombre,existencias));
		inven.guardar Inventario();
		return regreso;
	}

	public Boolean agregarExistencias(int id, int existencias){
		return new  Inventario().agregarExistenciasProducto(id,existencias);
	}


}
