package View.GUISistemaDeMenu;


import Model.SistemaDeInventario.GestorInventario;
import Model.SistemaDeMenu.GestorDeMenu;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GUISistemaDeMenu{


	public GUISistemaDeMenu() {
	}

	public void menuChef() throws IOException, FileNotFoundException, ClassNotFoundException{
		GestorDeMenu geM = new GestorDeMenu();
		int selector;
		Boolean flag = true;
		while (flag) {
			System.out.println("Ingrese que quieres hacer\n1.Ver menu completo\n2.Agregar Platillo\n3.añadir ingredientes Platillo\n4.Ver receta\n0.Salir");
			selector = ingresoDatosInt();
			switch (selector) {
				case 1:
					System.out.println(geM.menuClompleto());
					break;
				case 2:
					crearPlatillo();
					break;
				case 3:
					System.out.println("Ingresa el id del platillo a agregar ingredientes");
					selector = ingresoDatosInt();
					addIngredienteFP(selector);
					break;
				case 4:
					System.out.println("Ingresa el id del platillo ");
					selector = ingresoDatosInt();
					System.out.println(informacionProductoReceta(selector));
					break;
				case 0:
					flag = false;
					break;
				default:
					System.out.println("ingresa una opcion correwcta");
					break;
			}

		}
	}

    public Boolean crearPlatillo() throws IOException, FileNotFoundException, ClassNotFoundException{
        System.out.println("Ingresa el nombre del platillo");
        String name = ingresoDatosString();
        System.out.println("Ingresa la receta");
        String receta = ingresoDatosString();
        System.out.println("Ingresa una descripcion a mostrar");
        String info = ingresoDatosString();
        System.out.println("Ingresa el precio del platillo");
        float costo = ingresaDatosFloat();
        return new GestorDeMenu().agregarPlatilloAlMenu(name,receta,info,costo);
    }

    public Boolean addIngredienteDG(int id) throws IOException, FileNotFoundException, ClassNotFoundException{
        if(!addIngredienteFP(id)){
            System.out.println("No se pudo ingresar producto");
        }
        System.out.println("Quieres ingresar un producto mas a tu platillo\n1.Si\n2.No");
        int selector = ingresoDatosInt();
        if (selector == 1) {
            return true;
        }
        return false;
    }

    public Boolean addIngredienteFP(int id) throws IOException, FileNotFoundException, ClassNotFoundException{
        int selector;
        int idProducto;
        int cantidad;
        System.out.println("Quieres ver la lista de Productos\n1.Si\n2.No");
        selector = ingresoDatosInt();
        if (selector == 1) {
            System.out.println( new GestorInventario().verInventario(1));
        }
        System.out.println("Ingrese el id del producto a agregar al platillo");
        idProducto = ingresoDatosInt();
        System.out.println("Ingrese la cantidad que se le asignara al platillo");
        cantidad = ingresoDatosInt();
        return new GestorDeMenu().addInd(id,idProducto,cantidad);
    }

	private String informacionProductoReceta(int id) throws IOException, FileNotFoundException, ClassNotFoundException{
		return new GestorDeMenu().receteIngredientes(id);
	}

	public void menuClientes() throws IOException, FileNotFoundException, ClassNotFoundException{
		System.out.println("Menu disponible");
		System.out.println(new GestorDeMenu().menuDisponible());
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
          return scan.nextLine();
        } catch (Exception e) {
          System.out.println("Ingresa un valor valido");
          scan.nextLine();
        }
      }
    }

    private float ingresaDatosFloat(){
        Scanner scan = new Scanner(System.in);
        while (true) {
          try {
            return scan.nextFloat();
          } catch (Exception e) {
            System.out.println("Ingresa un Numero");
            scan.nextLine();
          }
        }
    }



}
