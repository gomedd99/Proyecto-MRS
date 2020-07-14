package Model.SistemaDeMenu;
import java.io.Serializable;
import java.util.ArrayList;
public class Platillo implements Serializable {
    private String Nombre;
    private String Receta;
    private String Descripcion;
    private float costo;
    private int id;
    private ArrayList<int[]> ingredientes;

	public Platillo() {

	}

	public Platillo(String Nombre, String Receta, String Descripcion,float costo) {
		this.Nombre = Nombre;
		this.Receta = Receta;
		this.Descripcion = Descripcion;
        this.costo = costo;
        ingredientes = new ArrayList<>();
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

    public Boolean agregarIngrediente(int id,int totalIngredientes){
        int[] datos = new int[2];
        datos[0] = id;
        datos[1] = totalIngredientes;
        try {
            ingredientes.add(datos);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}

	public String getReceta() {
		return Receta;
	}

	public void setReceta(String Receta) {
		this.Receta = Receta;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}

	public ArrayList<int[]> getIngredientes() {
		return ingredientes;
	}

    public float getCosto(){
        return costo;
    }

    public void setCosto(float Costo){
        this.costo = costo;
    }

	public void setIngredientes(ArrayList<int[]> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String informacionMenu() {
		return "\t\t" +Nombre +" ID: "+(id+1) +"\n\nDescripcion\n" + Descripcion + "\nCosto: "+costo+"\n";
	}

	public String informacionReceta() {
		return "Platillo Nombre:\n" + Nombre + "\nReceta=" + Receta +"\nIngredientes:\n";
	}
}
