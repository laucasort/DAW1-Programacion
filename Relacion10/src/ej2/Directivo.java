package ej2;

public class Directivo extends Empleado {

	// CONSTANTES
	private final static int SUELDO_MAXIMO = 3500;
	
	// ATRIBUTOS
	private String departamento;	
	
	// CONSTRUCTORES
	public Directivo(String dni, String nombre, int sueldo, String departamento)
			throws EmpleadoException {
		super(dni, nombre, sueldo, SUELDO_MAXIMO);
		this.departamento = departamento;
	}
	
	// GETTERS & SETTERS
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	// MÉTODOS
	
	// TOSTRING
	@Override
	public String toString() {
		return "Directivo [departamento=" + departamento + ", toString()=" + super.toString() + "]";
	}
}
