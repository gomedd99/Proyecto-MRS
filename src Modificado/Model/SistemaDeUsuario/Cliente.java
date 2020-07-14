package Model.SistemaDeUsuario;
import java.io.Serializable;
public class Cliente extends Usuarios implements Serializable {
    private TarjetaBancaria tj;

	public Cliente(String contrasena, String cuenta,TarjetaBancaria tj) {
		super(3,contrasena,cuenta);
		this.tj = tj;
	}



	public TarjetaBancaria getTj() {
		return tj;
	}

	public void setTj(TarjetaBancaria tj) {
		this.tj = tj;
	}

    public String tipoDeUsuario(){
        return "Tipo  de usuario cliente\n";
    }



	@Override
	public String toString() {
		return "Cliente: "+super.getCuenta()+"\nTipo de Usuario : cliente\n";
	}
}
