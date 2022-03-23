package ej3;

public class Microbus extends Vehiculo {

	//CONSTANTES - No hay.
	
	// ATRIBUTOS
	private int plazas;
	
	// CONSTRUCTORES
	public Microbus(String matricula, TipoGama gama, int plazas) throws VehiculoException {
		super(matricula, gama);
		setPlazas(plazas);
	}
	
	// GETTERS & SETTERS
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) throws VehiculoException {
		if(plazas<=0) {
			throw new VehiculoException("ERROR: El número de plazas del microbus no puede ser negativo o 0.");
		}
		this.plazas = plazas;
	}
	
	// MÉTODOS
	@Override
	double precioAlquilerExtra(int numeroDias) {
		double precioExtra = 5. * this.plazas;
		return precioExtra;
	}
	
	// TOSTRNG
	@Override
	public String toString() {
		return "Microbus [plazas=" + plazas + ", matricula=" + matricula + ", gama=" + gama + "]";
	}
}
