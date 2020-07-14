package Model.SistemaDeMenu;
import Model.SistemaDeInventario.GestorInventario;
import View.GUISistemaDeMenu;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GestorDeMenu{

	public GestorDeMenu() {
	}

    public String menuDisponible() throws IOException, FileNotFoundException, ClassNotFoundException{
        String Ret = "\t\tEl menu\n";
        GestorInventario comprobar = new GestorInventario();
        ArrayList<Platillo> platillos = new Menu().getMenuPlatillos();
        for (int i = 0; i < platillos.size() ; i++)
            if (comprobar.infoMenu(platillos.get(i)))
                Ret+= platillos.get(i).informacionMenu();
        return Ret;
    }

	public Boolean agregarPlatilloAlMenu(String nombre,String Receta,String Descripcion,float Costo) throws IOException, FileNotFoundException, ClassNotFoundException{
		Menu menu = new Menu();
		if(menu.agregarPlatillo(new Platillo(nombre,Receta,Descripcion,Costo))){
			GUISistemaDeMenu setIngredientes = new GUISistemaDeMenu();
			while (setIngredientes.addIngredienteDG(menu.getNumeroDePlatillos()));
			return true;
		}
		else {
			return false;
		}
	}

	public Boolean addInd(int idPlatillo,int idProducto, int cantidad) throws IOException, FileNotFoundException, ClassNotFoundException{
		Menu menu = new Menu();
	 	menu.getPlatillo(idPlatillo).agregarIngrediente(idProducto,cantidad);
		return menu.guardarMenu();
	}

	public String menuClompleto() throws IOException, FileNotFoundException, ClassNotFoundException{
		return new Menu().menuC();
	}

	public Platillo getPlatilloG(int id) throws IOException, FileNotFoundException, ClassNotFoundException{
		return new Menu().getPlatillo(id);
	}

	public String receteIngredientes(int id) throws IOException, FileNotFoundException, ClassNotFoundException{
		GestorInventario gesI = new GestorInventario();
		Platillo plt = new Menu().getPlatillo(id);
		String ret = plt.informacionReceta();
		ArrayList<int[]> id_s = plt.getIngredientes();
		int[] datos;
		for (int i = 0;i <  id_s.size() ;i++ ) {
			datos = id_s.get(i);
			ret += gesI.infoProducto(datos[0]);
		}
		return ret;
	}

}
