package ej7;

public class Repartidor extends Empleado {

	// ATRIBUTOS
	private String zona;
	
	// CONSTRUCTORES
	protected Repartidor(String nombre, int edad, double salario, String zona) throws EmpleadoException {
		super(nombre, edad, salario);
		this.zona = zona;
		plus();
	}
	
	// GETTERS & SETTERS
	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	
	// MÉTODOS
	@Override
	void plus() {
		if(this.edad<25 && this.zona.equals("zona 3")) {
			this.salario += Empleado.PLUS;
		}
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Repartidor [zona=" + zona + ", nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + "]";
	}

}
