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
    private ArrayList<Producto> inven;

	public Inventario() throws FileNotFoundException, IOException, ClassNotFoundException{
        this.nombreArchivo = "Inventario.bin";
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream( nombreArchivo );
            ois = new ObjectInputStream( fis );
            numeroDeProductos = ois.read();
            inven = (ArrayList) ois.readObject();
            fis.close();
        } catch(IOException e) {
            numeroDeProductos = 0;
            inven = new ArrayList<>();
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

	public ArrayList<Producto> getinven() {
		return inven;
	}

	public void setinven(ArrayList<Producto> inven) {
		this.inven = inven;
	}

    public Boolean guardarInventario()throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream( nombreArchivo );
            oos = new ObjectOutputStream( fos );
            oos.write( numeroDeProductos );
            oos.writeObject( inven );
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
            inven.add(nuevoProducto);
            numeroDeProductos++;
            nuevoProducto.setId(numeroDeProductos-1);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    public Boolean pedido(int idProducto,int totalDeProducto){
        idProducto--;
        if(inven.get(idProducto).disminuirExistencias(totalDeProducto))
            return true;
        return false;
    }
    public Producto getProducto(int id){
        id--;
        try {
            if(inven.get(id)!=null)
                return inven.get(id);
        }catch (Exception e) {
            return null;
        }
        return null;
    }
    public String listaDeProductos(){
        String listaProductos = "\t\tLista de Productos\n";
        for (int i = 0;i < numeroDeProductos ;i++ ) {
            listaProductos += inven.get(i).toString()+"\n";
        }
        return listaProductos;
    }
    public String listaProductosReponerse(){
        String aReponerse = "\tProductos con bajas existencias\n";
        for (int i = 0;i < numeroDeProductos ;i++ ) {
            if (inven.get(i).getExistensias()<=10) {
                aReponerse += inven.get(i).toString()+"\n";
            }
        }
        return aReponerse;
    }

    public Boolean agregarExistenciasProducto(int id, int existencias){
        return inven.get(id-1).agregarExistencias(existencias);
    }

}
