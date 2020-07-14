package Model.SistemaDeInventario;
import Model.SistemaDeMenu.Platillo;
import java.io.*;


public class GestorInventario {


	public GestorInventario() {
	}

    public Boolean infoMenu(Platillo plato) throws IOException, FileNotFoundException, ClassNotFoundException{
        Inventario inven = new  Inventario();
        
        for (int i; i < plato.get() ; i++ ) {
            if (!(inven.getProducto(plato.getIngrediente(i).getId()).comprobarExistensias(plato.getRecursos(i))))
                return false;
        }
        return true;
    }

    /*public Boolean agregarAlCarrito(Platillo plato){
        Inventario inven = new  Inventario();
        for (int i; i < plato.getElementos() ; i++ ) {
            if (!(inven.getProducto(plato.getIngrediente(i).getId()).disExistensias(plato.getRecursos(i)))) {
                return false;
            }
        }
        inven.guardarInventario();
        return true;
    }*/

    /*public Boolean borrarDelCarrito(Platillo plato){
        Inventario inven = new  Inventario();
        for (int i = 0;i < plato.getElementos() ; i++) {
            inven.getProducto(plato.getIngrediente(i).getId()).agregarExistencias(plato.getRecursos(i));
        }
        inven.guardarInventario();
    }*/

	public String verInventario(int selection)throws FileNotFoundException, IOException, ClassNotFoundException {
		Inventario inven = new Inventario();
		switch (selection) {
			case 1:
				return inven.listaDeProductos();
			case 2:
				return inven.listaProductosReponerse();
			default:
				return "No se eligio una opcion correcta\n";
		}
	}

	public Boolean agregarProducto(String Nombre,int existencias)throws FileNotFoundException, IOException, ClassNotFoundException {
		Boolean regreso = false;
		Inventario inven = new  Inventario();
	 	regreso = inven.agregarNuevoProducto(new Producto(Nombre,existencias));
		inven.guardarInventario();
		return regreso;
	}

	public Boolean modificarExistencias(int id, int existencias,int selector)throws FileNotFoundException, IOException, ClassNotFoundException {
		Inventario inven = new Inventario();
		Boolean ret;
		switch (selector) {
			case 1:
				ret = inven.agregarExistenciasProducto(id,existencias);
				break;
			case 2:
				ret = inven.modificarExistenciasProducto(id,existencias);
				break;
			default:
				return false;
		}
		if(ret){
			inven.guardarInventario();
			return ret;
		}else {
			return false;
		}
	}

	public Producto infoProducto(int id)throws FileNotFoundException, IOException, ClassNotFoundException{
		return new Inventario().getProducto(id);
	}

}
