package sistemadeinventario;
import java.io.Serializable;
import java.util.ArrayList;
public class ListaDeProductos implements Serializable {
    private ArrayList<Producto> Productos;

	public ListaDeProductos() {
		Productos = new ArrayList<Producto>();
	}

	public ListaDeProductos(ArrayList<Producto> Productos) {
		this.Productos = Productos;
	}

	public ArrayList<Producto> getProductos() {
		return Productos;
	}

	public void setProductos(ArrayList<Producto> Productos) {
		this.Productos = Productos;
	}

    

}
