package ej3;

public class Coche extends Vehiculo {

	// CONSTANTES
	public final static double PRECIO_GASOLINA = 3.5;
	public final static double PRECIO_DIESEL = 2.;
	
	// ATRIBUTOS
	private TipoCombustible combustible;
	
	// CONSTRUCTORES
	public Coche(String matricula, TipoGama gama, TipoCombustible combustible) {
		super(matricula, gama);
		this.combustible = combustible;
	}
	
	// GETTERS & SETTERS
	public TipoCombustible getCombustible() {
		return combustible;
	}
	public void setCombustible(TipoCombustible combustible) {
		this.combustible = combustible;
	}
	
	// MÉTDODOS
	@Override
	double precioAlquilerExtra(int numeroDias) {
		double precioExtra = numeroDias * this.combustible.getPrecioCombustible();
		return precioExtra;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Coche [combustible=" + combustible + ", matricula=" + matricula + ", gama=" + gama + "]";
	}
}
