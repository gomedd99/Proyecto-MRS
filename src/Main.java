import View.GUISistemaDeCarrito.GUISistemaDeCarrito;
import Model.SistemaDeUsuario.Usuarios;
import View.GUISistemaDeAutenticacion.GUISistemaDeAutenticacion;
import View.GUISistemaDeInventario.GUISistemaDeInventario;
import View.GUISistemaDeMenu.GUISistemaDeMenu;
import View.GUISistemaDeOrdenes.GUISistemaDeOrdenes;
import View.GUISistemaDeReservacion.GUISistemaDeReservacion;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        clearScreen();
        GUISistemaDeAutenticacion guiA = new GUISistemaDeAutenticacion();
        System.out.println("\t= = RESTAURANTE ``DONDE SIEMPRE´´ = =");

        // Que se identifique el usuario
        // se manda a si respectivo menú
        Usuarios usr;
        usr = null;

        boolean flag = true;

        while(flag){ // El "login" deberia estar en un while
            // - - - - - - - -
            System.out.println(" Escoja una opcion:");
            System.out.println("\n\t1. Cliente" +
                                "\n\t2. Gerente" +
                                "\n\t3. Chef" +
                                "\n\t0. Salir ");

            int ir_a_menu = ingresoDatosInt(); // dependoendo el tipo de usuario lo manda a su respectivo menu
            // - - - - - - - -

            switch (ir_a_menu){
                case 1:
                    clearScreen();
                    usr = guiA.menuCliente();
                    if (usr != null) {
                        menuClientes(usr);
                    }
                    else {
                        System.out.println("Contraseña incorrecta");;
                    }
                    break;
                case 2:
                    clearScreen();
                    if (guiA.menuGerente()) {
                        menuGerente();
                    }
                    break;
                case 3:
                    clearScreen();
                    if (guiA.menuChef()) {
                        menuChef();
                    }
                    break;
                case 0: // 0 para salir
                    flag = false;
                    break;
                default:
                    System.out.println("\tERROR: USUARIO NO VALIDO");
            }
        }

    }

    private static void menuClientes(Usuarios usr) throws IOException, ClassNotFoundException {
        int opcion = 0;
        Boolean activo = true;
        clearScreen();
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
                    GUISistemaDeMenu guiM = new GUISistemaDeMenu();
                    guiM.menuClientes();
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

    private static void menuChef() throws IOException, FileNotFoundException, ClassNotFoundException {
        int opcion = 0;
        Boolean activo = true;
        clearScreen();
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
                    GUISistemaDeMenu guiM = new GUISistemaDeMenu();
                    guiM.menuChef();
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
        clearScreen();
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
