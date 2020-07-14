package Model.SistemaDeUsuario;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GestorDeUsuarios{

	public GestorDeUsuarios() {

	}
    public Boolean addUsuarioCliente(String Cuenta,String Contra,TarjetaBancaria tar) throws IOException, FileNotFoundException, ClassNotFoundException{
        Usuarios usu = null;
        usu = new Cliente(Contra,Cuenta,tar);
        return new ListaDeUsuarios().nuevoUsuario(usu);
    }

    public Boolean addUsuarioStaff(int tipo,String Cuenta,String Contrasena,int numero) throws IOException, FileNotFoundException, ClassNotFoundException{
        Usuarios usu = null;
        switch (tipo) {
            case 1:
                usu = new Gerente(Contrasena,Cuenta,numero);
                break;
            case 2:
                usu = new Chef(Contrasena,Cuenta,numero);
                break;
            default:
                return false;
        }
        return new ListaDeUsuarios().nuevoUsuario(usu);
    }

    public Boolean autorizarGerente(String contra){
        if (contra.equals("5591708787"))
            return true;
        return false;
    }

    public Boolean autorizarChef(String contra){
        if (contra.equals("5545497895") )
            return true;
        return false;
    }

    public Boolean ingresar(int id,String Cuenta, String pass) throws IOException, FileNotFoundException, ClassNotFoundException{
        return new ListaDeUsuarios().darAutorizacion(id,pass,Cuenta);
    }

    public Boolean removeUser(int id,String Cuenta, String pass) throws IOException, FileNotFoundException, ClassNotFoundException{
        return new ListaDeUsuarios().borrarUsusario(id,pass,Cuenta);

    }

	public Usuarios getUsuario(int id,String Cuenta, String pass) throws IOException, FileNotFoundException, ClassNotFoundException{
		return new ListaDeUsuarios().getUsuarioLi(id,pass,Cuenta);
	}

}
