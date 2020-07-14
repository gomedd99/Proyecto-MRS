package Model.SistemaDeUsuario;
import java.io.Serializable;

public abstract class Usuarios implements Serializable {
  private int id;
  private String contrasena;
  private String cuenta;

  public Usuarios(int id, String contrasena, String cuenta) {
    this.id = id;
    this.contrasena = contrasena;
    this.cuenta = cuenta;
  }
  public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}


    public abstract String tipoDeUsuario();
    public abstract String toString();

    public void setNumeroDeGerente(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombre() {
        return cuenta; //To change body of generated methods, choose Tools | Templates.
    }


}
