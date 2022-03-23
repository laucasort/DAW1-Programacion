package ej2;

public class Operario extends Empleado {

	// CONSTANTES
	private final static int SUELDO_MAXIMO = 1200;
	
	// ATRIBUTOS
	private int nave;
		
	// CONSTRUCTORES
	public Operario(String dni, String nombre, int sueldo, int nave) throws EmpleadoException {
		super(dni, nombre, sueldo, SUELDO_MAXIMO);
		setNave(nave);
	}
	
	// GETTERS & SETTERS
	public int getNave() {
		return nave;
	}
	public void setNave(int nave) throws EmpleadoException {
		if(nave<1 || nave>5) {
			throw new EmpleadoException("ERROR: La nave debe ser 1, 2, 3, 4 o 5.");
		}
		this.nave = nave;
	}
	
	// MÉTODOS - No hay.
		
	// TOSTRING
	@Override
	public String toString() {
		return "Operario [nave=" + nave + ", toString()=" + super.toString() + "]";
	}
		
}
