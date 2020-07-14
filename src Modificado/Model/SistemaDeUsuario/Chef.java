package Model.SistemaDeUsuario;
import java.io.Serializable;
public class Chef extends Usuarios implements Serializable {
	private int numeroDeEmpleado;

	public Chef(String contrasena, String cuenta,int numeroDeEmpleado) {
		super(2,contrasena,cuenta);
		this.numeroDeEmpleado = numeroDeEmpleado;
	}

	public int getNumeroDeEmpleado() {
		return numeroDeEmpleado;
	}

	public void setNumeroDeEmpleado(int numeroDeEmpleado) {
		this.numeroDeEmpleado = numeroDeEmpleado;
	}

	public String tipoDeUsuario(){
        return "Tipo  de usuario chef\n";
    }

	@Override
	public String toString() {
		return "Chef: ="+super.getCuenta()+ "\nNumero de empleado " + numeroDeEmpleado+ "\n";
	}
}
