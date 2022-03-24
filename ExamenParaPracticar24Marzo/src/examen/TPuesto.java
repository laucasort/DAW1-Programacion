package examen;

public enum TPuesto {

	ADMINISTRATIVO(EmpleadoBase.SUELDO_ADMINISTRATIVO),
	OPERARIO(EmpleadoBase.SUELDO_OPERARIO),
	CONTABLE(EmpleadoBase.SUELDO_CONTABLE);
	
	private double sueldoBase;
	
	private TPuesto(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public double getSueldoBase() {
		return this.sueldoBase;
	}
	
}
