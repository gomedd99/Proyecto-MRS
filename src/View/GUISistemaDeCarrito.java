package View;

import Model.SistemaDeAutenticacion.Usuario;
import Model.SistemaDeCarrito.Carrito;
import Model.SistemaDeCarrito.GestorCarrito;
import Model.SistemaDeOrdenes.GestorOrdenes;
import Model.SistemaDeOrdenes.Orden;
import Model.SistemaDePago.GestorDePago;
import Model.SistemaDePago.Pago;
import Model.SistemaDeReservacion.GestorReservacion;

import java.io.IOException;
import java.util.Scanner;

public class GUISistemaDeCarrito {

    private GestorCarrito gestorCarrito;

    public GUISistemaDeCarrito() throws IOException {
        gestorCarrito = new GestorCarrito();
    }

    public void menuCarrito(Usuario usr) throws IOException {
        int opcion = 0;
        Boolean activo = true;

        System.out.println("\n= =\tMenu de mi Carrito = =\n");

        while(activo) {
            System.out.println("Ingrese la opción deseada " +
                    "\n1. \tVer Carrito " +
                    "\n2. \tAgregar Platillo a Carrito" +
                    "\n3. \tEliminar Platillo de Carrito" +
                    "\n4. \tPagar" +
                    "\n0. \tRegresar");
            opcion = ingresoDatosInt();
            clearScreen(); // limpia la pantalla
            switch (opcion) {
                case 0:
                    activo = false;
                    break;
                case 1:
                    verMiCarrito();
                    break; // break es opcional

                case 2:
                    agregarPlatilloMiCarrito();
                    break; // break es opcional

                case 3:
                    eliminarPlatilloMiCarrito();
                    break; // break es opcional

                case 4:
                    pagarMiCarrito(usr);
                    break; // break es opcional

                default:
                    System.out.println("\nEscoja una opcion valida.");
            }
            if (activo)
                pressAnyKeyToContinue(); // Espera a que el usuario entre algo para continuar
            clearScreen();
        }
    }

    private void pagarMiCarrito(Usuario usr) throws IOException {
        System.out.println("\t$ $ Pagar $ $ ");
        System.out.println(gestorCarrito.getCarrito());
        if(confirmarCompra()){
            Carrito miCarrito = gestorCarrito.getCarrito();

            // Genera Pago
            GestorDePago gestorDePago = new GestorDePago();
            Pago pago = gestorDePago.generarPago(usr, miCarrito.getCuenta());

            // Genera la Orden y la agrega a la lista de ordenes
            GestorOrdenes gestorOrdenes = new GestorOrdenes();
            Orden miOrden = gestorOrdenes.generarOrden(pago, miCarrito);
            if (gestorOrdenes.agregarOrden(miOrden)){
                System.out.println("\nSe genero con exito su orden: ");
                System.out.println(miOrden);
            }
        }
    }

    private boolean confirmarCompra(){
        int confirmar = 0;
        boolean regresar = false;
        boolean flag = true;
        while ( flag ) {
            System.out.println("\nConfirmar compra " +
                    "\n\t1. Si " +
                    "\n\t2. No");
            confirmar = ingresoDatosInt();
            switch (confirmar) {
                case 1:
                    flag = false;
                    regresar = true;
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    System.out.println("\tElija una opcion valida");
            }
        }
        return regresar;
    }

    private void verMiCarrito() {
        System.out.println("\t* * MI CARRITO * * ");
        System.out.println(gestorCarrito.getCarrito());
    }

    private void agregarPlatilloMiCarrito() {
        System.out.println("\t+ + Agregar Platillo + + ");
        System.out.println("\nIngrese el ID del platillo que desea agregar al carrito:");
        int id = ingresoDatosInt();
        if (gestorCarrito.agregarPatillo(id)){
            System.out.println("\nSe ha agregado al carrito el platillo con ID " + id);
        }
        else{
            System.out.println("\nLo sentimos! Ya se agoto el platillo con ID " + id);
        }
    }

    private void eliminarPlatilloMiCarrito(){
        System.out.println("\t- - Eliminar Platillo - - ");
        System.out.println("\nIngrese el ID del platillo que desea eliminar del carrito:");
        int id = ingresoDatosInt();
        if (gestorCarrito.eliminarPatillo(id)){
            System.out.println("\nSe ha borrado del carrito el platillo con ID " + id);
        }
        else{
            System.out.println("\nUps! Parece que en tu carrito no hay un platillo con ID " + id);
        }
    }


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
