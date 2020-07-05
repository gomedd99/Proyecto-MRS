package SistemaDeInventario
import java.io.Serializable;
public class Producto implements Serializable {
    private String Nombre;
    private int id;
    private int Existensias;

	public Producto(String Nombre, int id, int Existensias) {
		this.Nombre = Nombre;
		this.id = id;
		this.Existensias = Existensias;
	}

	public String getNombre() {
		return Nombre;
	}

	public Boolean setNombre(String ) {
        try {
            this.Nombre = Nombre;
        } catch(Exception e) {
            return false;
        }
        return true;
	}

	public int getId() {
		return id;
	}

	public Boolean setId(int id) {
        try {
            this.id = id;
        } catch(Exception e) {
            System.out.println("no");
            return false;
        }
        return true;
	}

	public int getExistensias() {
		return Existensias;
	}

	public Boolean setExistensias(int Existensias) {
        try {
            this.Existensias = Existensias;
        } catch(Exception e) {
            return false;
        }
        return true;
	}
    public Boolean agregarExistencias(int masExistensias){
        try {
            Existensias += masExistensias;
        } catch(Exception e) {
            return  false;
        }
        return true;
    }
}
