package ej2;

public class Empleado {
	
	// CONSTANTES
	public static final int SUELDO_MINIMO=800;
	
	// ATRIBUTOS
	private String dni;
	private String nombre;
	private int sueldo;
	
	// CONSTRUCTORES
	public Empleado(String dni, String nombre, int sueldo, int sueldoMax) throws EmpleadoException {
		super();
		this.dni = dni;
		this.nombre = nombre;
		setSueldo(sueldo, sueldoMax);
	}
	
	// GETTERS & SETTERS
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo, int sueldoMax) throws EmpleadoException {
		if(sueldo < SUELDO_MINIMO)
			throw new EmpleadoException("ERROR: Sueldo incorrecto. El sueldo mínimo es " + SUELDO_MINIMO + "€.");
		if(sueldo > sueldoMax)
			throw new EmpleadoException("ERROR: Sueldo incorrecto. El sueldo máximo es " + sueldoMax + "€.");
		
		this.sueldo = sueldo;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", sueldo=" + sueldo + "]";
	}
}
