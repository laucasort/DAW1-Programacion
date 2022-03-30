package practica7;

public class Pasajero {

	// ATRIBUTOS
	private String nombre;
	private int pasaporte;
	private String nacionalidad;

	// CONSTRUCTOR
	public Pasajero(String nombre, int pasaporte, String nacionalidad) {
		this.nombre = nombre;
		this.pasaporte = pasaporte;
		this.nacionalidad = nacionalidad;
	}

	// GETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(int pasaporte) {
		this.pasaporte = pasaporte;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Pasajero [" + "nombre=" + nombre + ", pasaporte=" 
				+ pasaporte + ", nacionalidad=" + nacionalidad + "]";
	}

}
