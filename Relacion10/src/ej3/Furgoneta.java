package ej3;

public class Furgoneta extends Vehiculo {

	// CONSTANTES - No hay.
	
	// ATRIBUTOS
	private double pma;
	
	// CONSTRUCTORES
	public Furgoneta(String matricula, TipoGama gama, double pma) throws VehiculoException {
		super(matricula, gama);
		setPma(pma);
	}
	
	// GETTERS & SETTERS
	public double getPma() {
		return pma;
	}
	public void setPma(double pma) throws VehiculoException {
		if(pma<=0) {
			throw new VehiculoException("ERROR: El PMA no puede ser 0 o negativo.");
		}
		this.pma = pma;
	}
	
	// MÉTODOS
	@Override
	double precioAlquilerExtra(int numeroDias) {
		double precioExtra = 0.5 * this.pma;
		return precioExtra;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Furgoneta [pma=" + pma + ", matricula=" + matricula + ", gama=" + gama + "]";
	}
}
