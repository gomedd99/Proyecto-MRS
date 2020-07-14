package View;
import SistemaDeInventario.GestorInventario;
import SistemaDeInventario.Producto;
import java.util.Scanner;
import java.io.*;
import java.io.FileOutputStream;

public class GUISistemaDeInventario{
    private GestorInventario g;
    public GUISistemaDeInventario(){
        g = new GestorInventario();
    }
    public void menuAdministradorInventario()throws FileNotFoundException, IOException, ClassNotFoundException{
        GestorInventario Ges = new GestorInventario();
        int id ;
        int elementos;
        int selector = 0;
        String nuevoProducto;
        Boolean flag = true;
        Producto info = null;
        while (flag) {
            System.out.println("ingresa la opcion deseada\n1.Visualizar inventario\n2.Visualizar productos con pocas existencias\n3.Agregar nuevo Producto\n4.Agregar existencias a algun producto\n5.Modificar existencias del producto\n0.Salir del menu Inventario\n");
            selector = ingresoDatosInt();
            switch (selector) {
                case 1:
                    System.out.println(Ges.verInventario(1));
                    break;
                case 2:
                    System.out.println(Ges.verInventario(2));
                    break;
                case 3:
                    System.out.println("Ingresa el nombre del producto a agregar");
                    nuevoProducto = ingresoDatosString();
                    System.out.println("ingresa el numero de elementos de "+nuevoProducto+" que quieres agregar");
                    elementos = ingresoDatosInt();
                    System.out.println("Confirfa si quieres agregar "+nuevoProducto+" con "+elementos+" elementos\n1.Si\n2.No");
                    selector = ingresoDatosInt();
                    if (selector == 1) {
                        seLogro(Ges.agregarProducto(nuevoProducto,elementos));
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el id del producto");
                    id = ingresoDatosInt();
                    System.out.println("Ingrese el valor de elementos del producto a agregar");
                    elementos = ingresoDatosInt();
                    info = Ges.infoProducto(id);
                    if (info != null) {
                        System.out.println("Confirfa si quieres agregar "+elementos+" al producto "+info.getNombre()+"\n1.Si\n2.No");
                        selector = ingresoDatosInt();
                        seLogro(Ges.modificarExistencias(id,elementos,1));
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el id del producto");
                    id = ingresoDatosInt();
                    System.out.println("Ingrese el valor de elementos a cambiar del producto");
                    elementos = ingresoDatosInt();
                    info = Ges.infoProducto(id);
                    if (info != null) {
                        System.out.println("Confirfa si quieres cambiar de "+info.getExistensias()+" a "+elementos+" del producto "+info.getNombre()+"\n1.Si\n2.No");
                        selector = ingresoDatosInt();
                        seLogro(Ges.modificarExistencias(id,elementos,2));
                    }
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta\n\n");
                    break;

            }
        }



    }

    private int ingresoDatosInt() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                return scan.nextInt();
            } catch (Exception e) {
                System.out.println("Ingresa un Numero");
                scan.nextLine();
            }
        }
    }

    private String ingresoDatosString() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                return scan.next();
            } catch (Exception e) {
                System.out.println("Ingresa un valor valido");
                scan.nextLine();
            }
        }
    }

    public void seLogro(Boolean ingreso){
        if(ingreso){
            System.out.println("La accion se completo de manera correcta");
        }else {
            System.out.println("no se pudo hacer la accion, vuelva a intentarlo");
        }
    }

}
