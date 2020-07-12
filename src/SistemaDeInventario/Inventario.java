import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.*;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Inventario {
    private int numeroDeProductos;
    private String nombreArchivo ;
    private ArrayList<Producto> Inven;

	public Inventario() throws FileNotFoundException, IOException, ClassNotFoundException{
        this.nombreArchivo = "Inventario.bin";
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream( nombreArchivo );
            ois = new ObjectInputStream( fis );
            numeroDeProductos = ois.read();
            Inven = (ArrayList) ois.readObject();
            fis.close();
        } catch(IOException e) {
            numeroDeProductos = 0;
            Inven = new ArrayList<>();
        }finally{
            if (ois != null) {
                ois.close();
            }
        }
	}

	public int getNumeroDeProductos() {
		return numeroDeProductos;
	}

	public void setNumeroDeProductos(int numeroDeProductos) {
		this.numeroDeProductos = numeroDeProductos;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public ArrayList<Producto> getInven() {
		return Inven;
	}

	public void setInven(ArrayList<Producto> Inven) {
		this.Inven = Inven;
	}

    public Boolean guardarInventario()throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream( nombreArchivo );
            oos = new ObjectOutputStream( fos );
            oos.write( numeroDeProductos );
            oos.writeObject( Inven );
            fos.close();
        } catch(IOException e) {
            System.out.println("No guardo");
            return false;
        }finally{
            if (oos != null) {
                oos.close();
            }
        }
        return true;
    }

    public Boolean agregarNuevoProducto(Producto nuevoProducto){
        try {
            Inven.add(nuevoProducto);
            numeroDeProductos++;
            nuevoProducto.setId(numeroDeProductos-1);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    public Boolean pedido(int idProducto,int totalDeProducto){
        idProducto--;
        if(Inven.get(idProducto).disminuirExistencias(totalDeProducto))
            return true;
        return false;
    }
    public Producto getProducto(int id){
        id--;
        try {
            if(Inven.get(id)!=null)
                return Inven.get(id);
        }catch (Exception e) {
            return null;
        }
        return null;
    }
    public String listaDeProductos(){
        String listaProductos = "\t\tLista de Productos\n";
        for (int i = 0;i < numeroDeProductos ;i++ ) {
            listaProductos += Inven.get(i).toString()+"\n";
        }
        return listaProductos;
    }
    public String listaProductosReponerse(){
        String aReponerse = "\tProductos con bajas existencias\n";
        for (int i = 0;i < numeroDeProductos ;i++ ) {
            if (Inven.get(i).getExistensias()<=10) {
                aReponerse += Inven.get(i).toString()+"\n";
            }
        }
        return aReponerse;
    }
}
