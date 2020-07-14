package Model.SistemaDeUsuario;
import java.io.Serializable;
public class TarjetaBancaria implements Serializable{
  private long  numerodetarjeta;
  private int mesDeExpiracion;
  private int year;

	public TarjetaBancaria() {
		super();
	}

	public TarjetaBancaria(long numerodetarjeta, int mesDeExpiracion, int year) {

		this.numerodetarjeta = numerodetarjeta; 
		this.mesDeExpiracion = mesDeExpiracion;
		this.year = year;
	}


	public long getnumerodetarjeta() {
		return numerodetarjeta;
	}

	public void setLong(long numerodetarjeta) {
		this.numerodetarjeta = numerodetarjeta; 
	}

	public int getMesDeExpiracion() {
		return mesDeExpiracion;
	}

	public void setMesDeExpiracion(int mesDeExpiracion) {
		this.mesDeExpiracion = mesDeExpiracion;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
