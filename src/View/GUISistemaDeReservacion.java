package View;

import Model.SistemaDeAutenticacion.Usuario;
import Model.SistemaDeReservacion.GestorReservacion;
import Model.SistemaDeReservacion.Reservacion;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class GUISistemaDeReservacion {

    private GestorReservacion gestorReservacion;

    public GUISistemaDeReservacion() throws IOException {
        gestorReservacion = new GestorReservacion();
    }

    public void menuAdminReservaciones() throws IOException {
        int opcion = 0;
        Boolean activo = true;

        System.out.println("\n\t= = Administrador de reservaciones = =\n");

        while(activo) {
            System.out.println("Ingrese la opción deseada " +
                                "\n\t1. Ver Agenda de Hoy" +
                                "\n\t2. Ver Agenda Proxima" +
                                "\n\t3. Eliminar una reservacion" +
                                "\n\t4. Buscar una reservacion" +
                                "\n\t5. Ver Historial" +
                                "\n\t0. Regresar");
            opcion = ingresoDatosInt();
            clearScreen(); // limpia la pantalla
            switch (opcion) {
                case 0:
                    activo = false;
                    break;
                case 1:
                    verAgendaHoy();
                    break; // break es opcional

                case 2:
                    verAgenda();
                    break; // break es opcional

                case 3:
                    eliminarUnaReservacion();
                    break; // break es opcional

                case 4:
                    verUnaReservacion();
                    break; // break es opcional

                case 5:
                    verHistorial();
                    break;

                default:
                    System.out.println("\nEscoja una opcion valida.");
            }
            if (activo)
                pressAnyKeyToContinue(); // Espera a que el usuario entre algo para continuar
            clearScreen();
        }

    }

    private void verAgenda(){
        System.out.println("\t+ + Agenda Proxima + + ");
        System.out.println(gestorReservacion.verReservacionesProximas());
    }

    private void verHistorial(){
        System.out.println("\t- - Historial de Reservacion - - ");
        System.out.println(gestorReservacion.verAgenda());
    }

    private void verAgendaHoy(){
        System.out.println("\t* * Agenda de hoy * * ");
        System.out.println(gestorReservacion.verReservacionesHoy());
    }

    private void eliminarUnaReservacion() throws IOException {
        System.out.println("\t- - Eliminar una reservacion - -");
        System.out.println("\nIngrese el ID de la reservacion que desea eliminar:");
        int id = ingresoDatosInt();
        if ( gestorReservacion.eliminarReservacion(id) ){
            System.out.println("\nSe elimino correctamente al reservación con ID " + id);
        }
        else{
            System.out.println("\nNo se encontro una reservacion con ID " + id);
        }
    }

    private void verUnaReservacion(){
        System.out.println("\t* * Buscar una reservacion * *");
        System.out.println("\nIngrese el ID de la reservacion que desea buscar:");
        int id = ingresoDatosInt();
        Reservacion buscada = gestorReservacion.verReservacion(id);
        if ( buscada != null ){
            System.out.println( buscada );
        }
        else{
            System.out.println("\nNo hay una reservacion con ID " + id);
        }
    }


    public void menuClienteReservaciones(Usuario usr) throws IOException {
        int opcion = 0;
        Boolean activo = true;

        System.out.println("\n\t= = Mis reservaciones = =\n");

        while(activo) {
            System.out.println("Ingrese la opción deseada " +
                    "\n\t1. Hacer una reservacion " +
                    "\n\t2. Eliminar una reservacion" +
                    "\n\t3. Buscar una reservacion" +
                    "\n\t4. Modificar una reservacion"+
                    "\n\t0. Regresar");
            opcion = ingresoDatosInt();
            clearScreen(); // limpia la pantalla
            switch (opcion) {
                case 0:
                    activo = false;
                    break;
                case 1:
                    hacerUnaReservacion(usr);
                    break; // break es opcional

                case 2:
                    eliminarUnaReservacionUsr(usr);
                    break; // break es opcional

                case 3:
                    buscarUnaReservacion(usr);
                    break; // break es opcional
                case 4:
                    editarUnaReservacion();
                    break; // break es opcional

                default:
                    System.out.println("\nEscoja una opcion valida.");
            }
            if (activo)
                pressAnyKeyToContinue(); // Espera a que el usuario entre algo para continuar
            clearScreen();
        }

    }

    private void hacerUnaReservacion(Usuario usr) throws IOException {
        System.out.println("\t+ + Hacer una reservacion + +");
        Calendar fecha = pedirFecha();

        Reservacion reservacion = gestorReservacion.crearReservacion(fecha, usr);

        if ( reservacion != null){
            System.out.println("\nSe agendo con exito su reservacion\n" + reservacion);
        }
        else{
            System.out.println("\nUps! Esa fecha no es valida. \nNo se pudo agendar su reservacion. " );
        }
    }

    private void eliminarUnaReservacionUsr(Usuario usr) throws IOException {
        System.out.println("\t- - Eliminar una reservacion - -");
        Calendar fecha = pedirFecha();

        if ( gestorReservacion.eliminarReservacion(fecha, usr.getNombre() ) ){
            System.out.println("\nSe elimino correctamente la reservación");
        }
        else{
            System.out.println("\n" + usr.getNombre() + " no tienes ninguna reservacion para el " + fecha.getTime() );
        }
    }

    private void buscarUnaReservacion(Usuario usr) {
        System.out.println("\t* * Buscar una reservacion * *");
        Calendar fecha = pedirFecha();
        Reservacion buscada = gestorReservacion.verReservacion(fecha, usr.getNombre());
        if ( buscada != null ){
            System.out.println(buscada);
        }
        else{
            System.out.println("\n" + usr.getNombre() + " no tienes ninguna reservacion para el " + fecha.getTime() );
        }
    }

    private void editarUnaReservacion() throws IOException {
        System.out.println("\t / / Modificar una reservacion / /");

        System.out.println("\nIngrese el ID de la reservacion que desea modificar:");
        int id = ingresoDatosInt();

        System.out.println("\n Ingrese la nueva fecha: ");
        Calendar fecha = pedirFecha();

        Reservacion reservacionModificada = gestorReservacion.modificarReservacion(fecha, id);
        if( reservacionModificada != null ){
            System.out.println("\n Su reservacion quedo: " + reservacionModificada);
        }
        else {
            System.out.println("\nUps! Esa fecha no es valida. \nNo se pudo cambiar su reservacion. " );
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

    private Calendar pedirFecha(){

        System.out.println("\nIngrese el día ");
        int dia = ingresoDatosInt();

        System.out.println("\nIngrese la hora ");
        int hora = ingresoDatosInt();

        System.out.println("\nIngrese minutos ");
        int min = ingresoDatosInt();

        System.out.println("\nIngrese el mes ");
        int mes = ingresoDatosInt();

        System.out.println("\nIngrese el año ");
        int anio = ingresoDatosInt();

        Calendar nuevaFecha = Calendar.getInstance();
        nuevaFecha.set(anio, mes, dia, hora, min, 0);

        return nuevaFecha;
    }

    public static void pressAnyKeyToContinue()
    {
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
