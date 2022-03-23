package ej7;

public class Comercial extends Empleado {

	// ATRIBUTOS
	private double comision;
	
	// CONSTRUCTORES
	protected Comercial(String nombre, int edad, double salario, double comision) throws EmpleadoException {
		super(nombre, edad, salario);
		this.comision = comision;
		plus();
	}
	
	// GETTERS & SETTER
	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}
	
	// MÉTODOS
	@Override
	void plus() {
		if(this.edad>30 && this.comision>200.) {
			this.salario += Empleado.PLUS;
		}
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Comercial [comision=" + comision + ", nombre=" + nombre + ", edad=" + edad + ", salario=" + salario
				+ "]";
	}
	
}
