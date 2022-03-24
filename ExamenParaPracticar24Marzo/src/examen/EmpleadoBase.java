package examen;

public class EmpleadoBase extends Empleado implements ActualizableSueldo {

	// CONSTANTES
	public final static int SUELDO_ADMINISTRATIVO = 1150;
	public final static int SUELDO_OPERARIO = 1100;
	public final static int SUELDO_CONTABLE = 1350;
	public final static double INCREMENTO_ANUAL = 102.5;
	
	// ATRIBUTOS
	private TPuesto puesto;
	
	// CONSTRUCTORES
	public EmpleadoBase(String dni, String nombre, int sueldo, TPuesto puesto) throws EmpresaException {
		super(dni, nombre);
		this.puesto = puesto;
		this.setSueldo(sueldo);
	}
	
	// GETTERS & SETTERS
	public TPuesto getPuesto() {
		return puesto;
	}
	
	protected void setSueldo(double sueldo) throws EmpresaException {
		if (sueldo < this.puesto.getSueldoBase())
			throw new EmpresaException("El sueldo de cualquier empleado debe ser mayor a los " + this.puesto.getSueldoBase() + "  euros");
		super.setSueldo(sueldo);
	}
	
	// MÉTODOS
	public void actualizarSueldo() throws EmpresaException {
		this.setSueldo(this.getSueldo()*INCREMENTO_ANUAL);
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "EmpleadoBase [puesto=" + puesto + ", toString()=" + super.toString() + "]";
	}
	
}
