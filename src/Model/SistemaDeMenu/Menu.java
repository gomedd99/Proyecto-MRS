package Model.SistemaDeMenu;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.*;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class Menu{
    private ArrayList<Platillo> menuPlatillos;
    private int numeroDePlatillos;
    private String nombreArchivo ;

    public Menu() throws FileNotFoundException, IOException, ClassNotFoundException{
        this.nombreArchivo = "Menu.bin";
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream( nombreArchivo );
            ois = new ObjectInputStream( fis );
            numeroDePlatillos = ois.read();
            menuPlatillos = (ArrayList) ois.readObject();
            fis.close();
        } catch(IOException e) {
            numeroDePlatillos = 0;
            menuPlatillos = new ArrayList<>();
        }finally{
            if (ois != null) {
                ois.close();
            }
        }
    }

	public ArrayList<Platillo> getMenuPlatillos() {
		return menuPlatillos;
	}

	public void setMenuPlatillos(ArrayList<Platillo> menuPlatillos) {
		this.menuPlatillos = menuPlatillos;
	}

	public int getNumeroDePlatillos() {
		return numeroDePlatillos;
	}

	public void setNumeroDePlatillos(int numeroDePlatillos) {
		this.numeroDePlatillos = numeroDePlatillos;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

    public Boolean guardarMenu()throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream( nombreArchivo );
            oos = new ObjectOutputStream( fos );
            oos.write( numeroDePlatillos );
            oos.writeObject( menuPlatillos );
            fos.close();
        } catch(IOException e) {
            System.out.println("MISSING: Menu.bin al guardarMenu");
            return false;
        }finally{
            if (oos != null) {
                oos.close();
            }
        }
        return true;
    }

    public Boolean agregarPlatillo(Platillo addPlatillo)throws FileNotFoundException, IOException, ClassNotFoundException{
        menuPlatillos.add(addPlatillo);
        numeroDePlatillos++;
        addPlatillo.setId(numeroDePlatillos-1);
        return guardarMenu();
    }

    public Platillo getPlatillo(int id){
        id--;
        try {
            if(menuPlatillos.get(id) != null)
                return menuPlatillos.get(id);
        } catch(Exception e) {
            System.out.println("\nNo se encontro el platillo\n");
            return null;
        }
        return null;
    }

    public String menuC(){
        String menu = "El menu completo es:\n";
        for (int i = 0;i < numeroDePlatillos ; i++ ) {
            menu += menuPlatillos.get(i).informacionMenu();
        }
        return menu;
    }

}
