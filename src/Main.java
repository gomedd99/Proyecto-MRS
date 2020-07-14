import Model.SistemaDeAutenticacion.Usuario;
import View.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        clearScreen();
        System.out.println("\t= = RESTAURANTE ``DONDE SIEMPRE´´ = =");

        // Que se identifique el usuario
        // se manda a si respectivo menú
        Usuario usr = null;

        boolean flag = true;

        while(flag){ // El "login" deberia estar en un while
            // - - - - - - - -  ESTO ES TEMPORAL
            System.out.println("1 cliente, 2 gerente, 3 chef, 0 salir: ");


            int ir_a_menu = ingresoDatosInt(); // dependoendo el tipo de usuario lo manda a su respectivo menu
            // - - - - - - - -

            switch (ir_a_menu){
                case 1:
                    clearScreen();
                    menuClientes(usr);
                    break;
                case 2:
                    clearScreen();
                    menuGerente();
                    break;
                case 3:
                    clearScreen();
                    menuChef();
                    break;
                case 0: // 0 para salir
                    flag = false;
                    break;
                default:
                    System.out.println("\tUSUARIO NO VALIDO");
            }
        }

    }

    private static void menuClientes(Usuario usr) throws IOException, ClassNotFoundException {
        int opcion = 0;
        Boolean activo = true;

        while(activo) {
            System.out.println("\n\t= = Menu Principal = = ");
            System.out.println("\nIngrese la opción deseada\n" +
                    "\n\t1. Menu del Restaurante" +
                    "\n\t2. Mi carrito" +
                    "\n\t3. Mis Reservaciones" +
                    "\n\t0. Cerrar Sesion");
            opcion = ingresoDatosInt();
            clearScreen(); // limpia la pantalla
            switch (opcion) {
                case 0:
                    activo = false;
                    break;
                case 1:
                    // GUI MENU - PARA CLIENTES
                    break;

                case 2:
                    GUISistemaDeCarrito menuCarrito = new GUISistemaDeCarrito();
                    menuCarrito.menuCarrito(usr);
                    break;

                case 3:
                    GUISistemaDeReservacion menuReservaciones = new GUISistemaDeReservacion();
                    menuReservaciones.menuClienteReservaciones(usr);
                    break;

                default:
                    System.out.println("\nEscoja una opcion valida.");
            }
            clearScreen();
        }
    }

    private static void menuChef() throws IOException {
        int opcion = 0;
        Boolean activo = true;

        while(activo) {
            System.out.println("\n\t= = Menu Chef = = ");
            System.out.println("\nIngrese la opción deseada\n" +
                    "\n\t1. Editar Menu del Restaurante" +
                    "\n\t2. Administrar ordenes" +
                    "\n\t0. Cerrar Sesion");
            opcion = ingresoDatosInt();
            clearScreen(); // limpia la pantalla
            switch (opcion) {
                case 0:
                    activo = false;
                    break;
                case 1:
                    // GUI MENU - PARA CHEFS
                    break;

                case 2:
                    GUISistemaDeOrdenes menuOrdenes = new GUISistemaDeOrdenes();
                    menuOrdenes.menuOrdenesChef();
                    break;

                default:
                    System.out.println("\nEscoja una opcion valida.");
            }
            clearScreen();
        }
    }

    private static void menuGerente() throws IOException, ClassNotFoundException {
        int opcion = 0;
        Boolean activo = true;

        while(activo) {
            System.out.println("\n\t= = Menu Gerente = = ");
            System.out.println("\nIngrese la opción deseada\n" +
                    "\n\t1. Administrar Inventario" +
                    "\n\t2. Administrador de reservaciones" +
                    "\n\t0. Cerrar Sesion");
            opcion = ingresoDatosInt();
            clearScreen(); // limpia la pantalla
            switch (opcion) {
                case 0:
                    activo = false;
                    break;
                case 1:
                    GUISistemaDeInventario menuInv = new GUISistemaDeInventario();
                    menuInv.menuAdministradorInventario();
                    break;

                case 2:
                    GUISistemaDeReservacion menuReservaciones = new GUISistemaDeReservacion();
                    menuReservaciones.menuAdminReservaciones();
                    break;

                default:
                    System.out.println("\nEscoja una opcion valida.");
            }
            clearScreen();
        }
    }



    //      U T I L I D A D E S

    private static String ingresoDatosString() {
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

    private static int ingresoDatosInt() {
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

    public static void pressAnyKeyToContinue() {
        String seguir;
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nPress Enter key to continue...");
        try
        {
            seguir = teclado.nextLine();
        }
        catch(Exception ignored) {}
    }

    public static void clearScreen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

    }
}
