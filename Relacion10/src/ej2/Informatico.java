package ej2;

public class Informatico extends Empleado {

	// CONSTANTES
	private final static int SUELDO_MAXIMO = 2500;
	
	// ATRIBUTOS
	private Especialidad especialidad;
	
	// CONSTRUCTORES
	public Informatico(String dni, String nombre, int sueldo, Especialidad especialidad)
			throws EmpleadoException {
		super(dni, nombre, sueldo, SUELDO_MAXIMO);
		this.especialidad = especialidad;
	}
		
	// GETTERS & SETTERS
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) throws EmpleadoException {
		this.especialidad = especialidad;
	}
	
	// MÉTODOS - No hay.
		
	// TOSTRING
	@Override
	public String toString() {
		return "Informatico [especialidad=" + especialidad + ", toString()=" + super.toString() + "]";
	}
}
