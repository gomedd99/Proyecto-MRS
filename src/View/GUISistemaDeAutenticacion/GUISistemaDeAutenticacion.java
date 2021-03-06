package View.GUISistemaDeAutenticacion;
import Model.SistemaDeUsuario.*;
import java.util.Scanner;
import java.io.*;
import java.io.FileOutputStream;

public class GUISistemaDeAutenticacion{

        Usuarios logIn = null;

  public GUISistemaDeAutenticacion(){
  }

  /*public Boolean acceder() throws IOException, FileNotFoundException, ClassNotFoundException {
    int selector;
    System.out.println("Que tipo de usuario eres \n1 Cliente\n2.Gerente\n3.Chef\n");
    selector = ingresoDatosInt();
    switch (selector) {
        case 1:
            return menuCliente();
        case 2:
            return menuGerente();
        case 3:
            return menuChef();
        default:
            return false;
    }
  }*/



  public Usuarios menuCliente() throws IOException, FileNotFoundException, ClassNotFoundException{
      long numerodetarjeta;
      int mesDeExpiracion;
      int year;
      String cuenta;
      String contrasena;
      GestorDeUsuarios Ges = new GestorDeUsuarios();
      while (true) {
          System.out.println("\nQuieres: \n\t1.Crear Nuevo Usuario\n\t2.Acceder\n\t0.Salir");
          int seleccion = ingresoDatosInt();
          clearScreen(); // Limpia la Pantalla
          switch (seleccion){
                case 1:
                    System.out.println("\t= = Crear Usuario = =\n");
                    System.out.println("Cual es tu nombre de usuario:\n");
                    cuenta = ingresoDatosString();
                    System.out.println("Cual es tu contrasena:\n");
                    contrasena = ingresoDatosString();
                    System.out.println("Cual es tu numero de tarjeta:\n");
                    numerodetarjeta = ingresoDatoslong();
                    System.out.println("Cual es tu mes De Expiracion:\n");
                    mesDeExpiracion = ingresoDatosInt();
                    System.out.println("Cual es tu año de experacion:\n");
                    year = ingresoDatosInt();
                    Ges.addUsuarioCliente(cuenta,contrasena,new TarjetaBancaria(numerodetarjeta,mesDeExpiracion,year));
                    break;
                case 2:
                    if (accederSistema(Ges,3)) {
                        return logIn;
                    }
                case 0:
                    return null;
                default:
                        System.out.println("Ingrese una opcion correcta");
                        break;
          }
          clearScreen();
      }

  }

  public Boolean menuChef() throws IOException, FileNotFoundException, ClassNotFoundException{
      GestorDeUsuarios Ges = new GestorDeUsuarios();
      System.out.println("Ingresa la clave para poder ingresar a un usuario de tipo Chef");
      String pass = ingresoDatosString();
      if (Ges.autorizarChef(pass))
          return accederSistema(Ges,2);
      else {
          System.out.println("Contraseña Incorrecta");
          return false;
      }
  }

  public Boolean menuGerente() throws IOException, FileNotFoundException, ClassNotFoundException{
      GestorDeUsuarios Ges = new GestorDeUsuarios();
      int selector;
      System.out.println("Ingresa la clave para poder ingresar a un usuario de tipo Admin");
      String pass = ingresoDatosString();
      if (Ges.autorizarGerente(pass)) {
          while (true) {
              System.out.println("Que Quieres hacer\n\t1.Ingresar al sistema \n\t2.Agregar Usuario Chef o Gerente \n\t3.Borrar Usuario\n\t0.Salir");
              selector = ingresoDatosInt();
              switch (selector) {
                case 0:
                    return false;
                case 1:
                    return accederSistema(Ges,1);
                case 2:
                     agregarUsuarioStaff(Ges);
                     break;
                case 3:
                     borrarUsuario(Ges);
                     break;
                default:
                    System.out.println("Ingresa una opcion correcta");
              }
              clearScreen(); // Limpia pantalla
          }
      }else{
          return false;
      }
  }

  private Boolean accederSistema(GestorDeUsuarios Ges,int tipoUsuario) throws IOException, FileNotFoundException, ClassNotFoundException{
      String cuenta;
      String contrasena;
      System.out.println("\t = = Acceder al Sistema = =");
      System.out.println("Cual es tu nombre de usuario:\n");
      cuenta = ingresoDatosString();
      System.out.println("Cual es tu contrasena:\n");
      contrasena = ingresoDatosString();
      logIn = Ges.getUsuario(tipoUsuario,cuenta,contrasena);
      return Ges.ingresar(tipoUsuario,cuenta,contrasena);
  }

  private Boolean agregarUsuarioStaff(GestorDeUsuarios ges) throws IOException, FileNotFoundException, ClassNotFoundException {
    int id;
    String contrasena;
    String cuenta;
    int selector;
    System.out.println("\t + + Agregar Staff + +");
    System.out.println("Que tipo de usuario quieres agregar \n1.Gerente\n2.Chef");
    selector = ingresoDatosInt();
    switch (selector) {
      case 1:
          System.out.println("Cual es tu nombre de usuario:\n");
          cuenta = ingresoDatosString();
          System.out.println("Cual es tu contrasena:\n");
          contrasena = ingresoDatosString();
          System.out.println("Cual es el numero de gerente:\n");
          id = ingresoDatosInt();
          return ges.addUsuarioStaff(selector,cuenta,contrasena,id);
      case 2:
          System.out.println("Cual es tu nombre de usuario:\n");
          cuenta = ingresoDatosString();
          System.out.println("Cual es tu contrasena:\n");
          contrasena = ingresoDatosString();
          System.out.println("Cual es el numero de chef:\n");
          id = ingresoDatosInt();
          return ges.addUsuarioStaff(selector,cuenta,contrasena,id);
      default:
        System.out.println("No se ingreso una opcion correcta");
        return false;
    }
  }

  private Boolean borrarUsuario(GestorDeUsuarios ges) throws IOException, FileNotFoundException, ClassNotFoundException{
    int selector;
    String contrasena;
    String cuenta;
    int i;
      System.out.println("\t + + Borrar Staff + +");
    System.out.println("Que tipo de usuario quieres Borrar \n\t1. Cliente\n\t2.Gerente\n\t3.Chef\n");
    selector = ingresoDatosInt();
    System.out.println("Cual es tu nombre de usuario:\n");
    cuenta = ingresoDatosString();
    System.out.println("Cual es tu contrasena:\n");
    contrasena = ingresoDatosString();
    System.out.println("Estas seguro que quieres borrar el usuario :\n1.si \n2.no \n");
    i = ingresoDatosInt();
    if(i==1){
      return ges.removeUser(selector,cuenta,contrasena);
    }
    else {
        System.out.println("No se borro el usuario");
      return false;
    }
  }

    // U T I L I D A D E S

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

  private long ingresoDatoslong() {
    Scanner scan = new Scanner(System.in);
    while (true) {
      try {
        return scan.nextLong();
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

    public static void clearScreen() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
    }
}
