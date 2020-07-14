package Model.SistemaDeInventario;
import Model.SistemaDeMenu.Platillo;
import java.io.*;
import java.util.ArrayList;

public class GestorInventario {


	public GestorInventario() {
	}

	public Boolean infoMenu(Platillo plato) throws IOException, FileNotFoundException, ClassNotFoundException{
		Inventario inven = new  Inventario();
		ArrayList<int[]> id_s = plato.getIngredientes();
		int[] comprobar;
		for (int i = 0; i < id_s.size() ; i++ ) {
			comprobar = id_s.get(i);
			if (!inven.getProducto(comprobar[0]).comprobarExistensias(comprobar[1]))
				 return false;
		}
		return true;
	}

    public Boolean agregarAlCarrito(Platillo plato) throws IOException, FileNotFoundException, ClassNotFoundException{
        Inventario inven = new  Inventario();
		ArrayList<int[]> id_s = plato.getIngredientes();
		int[] comprobar;
        for (int i = 0 ; i < id_s.size() ; i++ ) {
			comprobar = id_s.get(i);
			if (!inven.pedido(comprobar[0],comprobar[1]))
				return false;
        }
        inven.guardarInventario();
        return true;
    }

    public Boolean borrarDelCarrito(Platillo plato) throws IOException, FileNotFoundException, ClassNotFoundException{
        Inventario inven = new  Inventario();
		ArrayList<int[]> id_s = plato.getIngredientes();
		int[] comprobar;
        for (int i = 0;i < id_s.size() ; i++) {
			comprobar = id_s.get(i);
            inven.agregarExistenciasProducto(comprobar[0],comprobar[1]);
        }
        return inven.guardarInventario();
    }

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
