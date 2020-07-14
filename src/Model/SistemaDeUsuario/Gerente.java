package Model.SistemaDeUsuario;
import java.io.Serializable;
public class Gerente extends Usuarios implements Serializable {

	private int numeroDeGerente;

	public Gerente(String contrasena, String cuenta,int numeroDeGerente) {
		super(1,contrasena,cuenta);
		this.numeroDeGerente = numeroDeGerente;
	}

	public int getNumeroDeGerente() {
		return numeroDeGerente;
	}

	public void setNumeroDeGerente(int numeroDeGerente) {
		this.numeroDeGerente = numeroDeGerente;
	}

	public String tipoDeUsuario(){
		return "Tipo  de usuario gerente\n";
	}

	@Override
	public String toString() {
		return "Gerente: ="+super.getCuenta()+ "\nNumero de gerente " + numeroDeGerente+ "\n";
	}
}
