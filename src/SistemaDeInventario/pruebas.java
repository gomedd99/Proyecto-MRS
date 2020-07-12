import java.io.*;
import java.io.FileOutputStream;

public class pruebas {
    public static void main(String[] args)throws FileNotFoundException, IOException, ClassNotFoundException {
        inventario in = new inventario();
        in.agregarNuevoProducto(new Producto("Cerveza",6));
        System.out.println(in.listaDeProductos());
        System.out.println(in.listaProductosReponerse());
        if (in.getProducto(1).agregarExistencias(16)) {
            System.out.println("si es correcto ");
        }else {
            System.out.println("no");
        }
        System.out.println(in.listaProductosReponerse());
        System.out.println(in.listaDeProductos());

    }
}
