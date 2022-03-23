package ej7;

public abstract class Empleado {

	// CNOSTANTES
	public final static double PLUS = 300;
	
	// ATRIBUTOS
	protected String nombre;
	protected int edad;
	protected double salario;
	
	// CONSTRUCTOR
	protected Empleado(String nombre, int edad, double salario) throws EmpleadoException {
		super();
		this.nombre = nombre;
		setEdad(edad);
		setSalario(salario);
	}
	
	// GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws EmpleadoException {
		if(edad<16 || edad>66) {
			throw new EmpleadoException("ERROR: Edad no válida.");
		}
		this.edad = edad;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) throws EmpleadoException {
		if(salario<1000) {
			throw new EmpleadoException("ERROR: El salario es menor al SMI.");
		}
		this.salario = salario;
	}
	
	// MÉTODOS
	abstract void plus();
	
	// TOSTRING
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + "]";
	}
	
}
