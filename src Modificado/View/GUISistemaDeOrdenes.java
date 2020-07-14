package View;


import Model.SistemaDeOrdenes.GestorOrdenes;
import Model.SistemaDeOrdenes.Orden;

import java.io.IOException;
import java.util.Scanner;

public class GUISistemaDeOrdenes {

    private GestorOrdenes gestorOrdenes;

    public GUISistemaDeOrdenes() throws IOException {
        gestorOrdenes = new GestorOrdenes();
    }

    public void menuOrdenesChef() throws IOException {
        int opcion = 0;
        Boolean activo = true;

        System.out.println("\n= =\tAdministrar ordenes = =\n");

        while(activo) {
            System.out.println("Ingrese la opción deseada " +
                    "\n\t1. Ver Ordenes " +
                    "\n\t2. Actualizar estado de una orden" +
                    "\n\t3. Buscar una orden" +
                    "\n\t0. Regresar");
            opcion = ingresoDatosInt();
            clearScreen(); // limpia la pantalla
            switch (opcion) {
                case 0:
                    activo = false;
                    break;
                case 1:
                    verOrdenes();
                    break; // break es opcional

                case 2:
                    actualizarEstadoOrden();
                    break; // break es opcional

                case 3:
                    buscarOrden();
                    break; // break es opcional

                default:
                    System.out.println("\nEscoja una opcion valida.");
            }
            if (activo)
                pressAnyKeyToContinue(); // Espera a que el usuario entre algo para continuar
            clearScreen();
        }
    }

    private void verOrdenes(){
        System.out.println("\t* * Lista de ordenes * *");
        gestorOrdenes.verOrdenes();
    }

    private void actualizarEstadoOrden() throws IOException {
        System.out.println("\t+ + Actualizar estado de una orden + +");

        System.out.println("\nIngrese el ID de la orden que desea actualizar:");
        int id = ingresoDatosInt();

        String estado = escogerEstado();

        if (gestorOrdenes.actualizarEstado(id, estado)){
                System.out.println("\nSe actualizo correctamente la orden con ID " + id);
        }
        else{
            System.out.println("\nNo existe la orden con ID " + id);
        }
    }

    private void buscarOrden() {
        System.out.println("\t/ / Buscar orden / /");

        System.out.println("\nIngrese el ID de la orden que desea buscar:");
        int id = ingresoDatosInt();

        Orden orden = gestorOrdenes.verOrden(id);

        if (orden != null){
            System.out.println(orden);
        }
        else{
            System.out.println("\nNo existe la orden con ID " + id);
        }
    }

    private String escogerEstado(){
        String estado = "";
        int op = 0;
        while (estado.equals("")){
            System.out.println("Ingrese la opcion deseada " +
                "\n1. \tEn Proceso " +
                "\n2. \tLISTA!");
            op = ingresoDatosInt();
            if (op == 2 ){
                estado = "LISTA!";
            }
            else if (op == 1 ){
                estado = "En proceso!";
            }
            else {
                System.out.println("\nEsa opcion no es valida. ");
            }
        }
        return estado;
    }

//    public void menuOrdenes(Usuario usr){
//        int opcion = 0;
//        Boolean activo = true;
//
//        System.out.println("\n= =\tMenu ordenes = =\n");
//
//        while(activo) {
//            System.out.println("Ingrese la opción deseada " +
//                    "\n1. \tVer mis Ordenes " +
//                    "\n2. \tBuscar Orden" +
//                    "\n3. \tEliminar Orden" +
//                    "\n0. \tRegresar");
//            opcion = ingresoDatosInt();
//            clearScreen(); // limpia la pantalla
//            switch (opcion) {
//                case 0:
//                    activo = false;
//                    break;
//                case 1:
//                    verMiOrden(usr);
//                    break; // break es opcional
//
//                case 2:
//                    editarMiOrden(usr);
//                    break; // break es opcional
//
//                case 3:
//                    eliminarMiOrden(usr);
//                    break; // break es opcional
//
//                default:
//                    System.out.println("\nEscoja una opcion valida.");
//            }
//            if (activo)
//                pressAnyKeyToContinue(); // Espera a que el usuario entre algo para continuar
//            clearScreen();
//        }
//    }
//
//    private void verMiOrden(Usuario usr) {
//    }
//
//    private void editarMiOrden(Usuario usr) {
//    }
//
//    private void eliminarMiOrden(Usuario usr) {
//    }


//      U T I L I D A D E S

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
