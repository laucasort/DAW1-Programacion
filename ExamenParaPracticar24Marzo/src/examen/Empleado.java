package examen;

public abstract class Empleado {

	
	private static final int SUELDO_MINIMO_EMPLEADO = 1100;
	private String dni;
	private String nombre;
	private double sueldo;
	
	
	
	public Empleado(String dni, String nombre) throws EmpresaException  {
		setDni(dni);
		setNombre(nombre);
		this.sueldo = SUELDO_MINIMO_EMPLEADO;
	}
	public Empleado(String dni, String nombre, double sueldo) throws EmpresaException  {
		setDni(dni);
		setNombre(nombre);
		setSueldo(sueldo);
		
	}
	
	protected void setSueldo(double sueldo) throws EmpresaException {
		if (sueldo < SUELDO_MINIMO_EMPLEADO)
			throw new EmpresaException("El sueldo de cualquier empleado debe ser mayor a los " + SUELDO_MINIMO_EMPLEADO + "  euros");
		this.sueldo=sueldo;
	}

	public double getSueldo() {
		return sueldo;
	}

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
	
	
	@Override
	public String toString() {
		return "Empleado DNI=" + dni + ", nombre=" + nombre +  ", sueldo=" + sueldo;
	}
	
}