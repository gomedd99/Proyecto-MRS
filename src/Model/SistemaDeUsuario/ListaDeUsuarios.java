package Model.SistemaDeUsuario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ListaDeUsuarios {

    private ArrayList<Usuarios> usuarios;
    private String nombreArchivo;
    private  int numeroDeUsuarios;

    public ListaDeUsuarios() throws FileNotFoundException, IOException, ClassNotFoundException{
        nombreArchivo = "D:\\Gomedd\\Git\\ListaUsuarios.bin";
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(nombreArchivo);
            ois = new ObjectInputStream( fis );
            numeroDeUsuarios = ois.read();
            usuarios = (ArrayList) ois.readObject();
            fis.close();
        } catch(Exception e) {
            numeroDeUsuarios = 0;
            usuarios = new ArrayList<>();
        }finally{
            if(ois != null)
                ois.close();
        }
    }

    private Boolean guardarUsuarios() throws IOException{
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(nombreArchivo);
            oos = new ObjectOutputStream( fos );
            oos.write( numeroDeUsuarios );
            oos.writeObject( usuarios );
            fos.close();
        } catch(Exception e) {
            System.out.println("No guardado");
            return false;
        }finally{
            if (oos != null) {
                oos.close();
            }
        }
        return true;
    }

    public Boolean nuevoUsuario(Usuarios usuario){
        try {
            usuarios.add(usuario);
            numeroDeUsuarios++;
            return guardarUsuarios();
        } catch(Exception e) {
            return false;
        }
    }

    public Boolean darAutorizacion(int tipoDeUsuario,String pass,String name){
        for (int i = 0 ; i < numeroDeUsuarios ; i++ ) {
            switch (tipoDeUsuario) {
                case 1:
                    if (1 == usuarios.get(i).getId())
                        if (usuarios.get(i).getContrasena().equals(pass) && usuarios.get(i).getCuenta().equals(name)) {
                            return true;
                        }
                    break;
                case 2:
                    if (2 == usuarios.get(i).getId())
                        if (usuarios.get(i).getContrasena().equals(pass) && usuarios.get(i).getCuenta().equals(name)) {
                            return true;
                        }
                    break;
                case 3:
                    if (3 == usuarios.get(i).getId())
                        if (usuarios.get(i).getContrasena().equals(pass) && usuarios.get(i).getCuenta().equals(name)) {
                            return true;
                        }
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    return false;
            }

        }
        return false;
    }

    public Boolean borrarUsusario(int tipoDeUsuario,String pass,String name) throws IOException{
        for (int i = 0 ; i < numeroDeUsuarios ; i++ ) {
            switch (tipoDeUsuario) {
                case 1:
                    if (1 == usuarios.get(i).getId())
                        if (usuarios.get(i).getContrasena().equals(pass) && usuarios.get(i).getCuenta().equals(name)) {
                            usuarios.remove(i);
                            return guardarUsuarios();
                        }
                    break;
                case 2:
                    if (2 == usuarios.get(i).getId())
                        if (usuarios.get(i).getContrasena().equals(pass) && usuarios.get(i).getCuenta().equals(name)) {
                            usuarios.remove(i);
                            return guardarUsuarios();
                        }
                    break;
                case 3:
                    if (3 == usuarios.get(i).getId())
                        if (usuarios.get(i).getContrasena().equals(pass) && usuarios.get(i).getCuenta().equals(name)) {
                            usuarios.remove(i);
                            return guardarUsuarios();
                        }
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    return false;
            }

        }
        return false;
    }

    public Usuarios getUsuarioLi(int tipoDeUsuario,String pass,String name){
        for (int i = 0 ; i < numeroDeUsuarios ; i++ ) {
            switch (tipoDeUsuario) {
                case 1:
                    if (1 == usuarios.get(i).getId())
                        if (usuarios.get(i).getContrasena().equals(pass) && usuarios.get(i).getCuenta().equals(name)) {
                            return usuarios.get(i);
                        }
                    break;
                case 2:
                    if (2 == usuarios.get(i).getId())
                        if (usuarios.get(i).getContrasena().equals(pass) && usuarios.get(i).getCuenta().equals(name)) {
                            return usuarios.get(i);
                        }
                    break;
                case 3:
                    if (3 == usuarios.get(i).getId())
                        if (usuarios.get(i).getContrasena().equals(pass) && usuarios.get(i).getCuenta().equals(name)) {
                            return usuarios.get(i);
                        }
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    return null;
            }

        }
        return null;
    }


}
