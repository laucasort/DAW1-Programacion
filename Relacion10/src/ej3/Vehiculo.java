package ej3;

public abstract class Vehiculo {

	// CONSTANTES
	public final static double PRECIO_GAMA_BAJA = 30.;
	public final static double PRECIO_GAMA_MEDIA = 40.;
	public final static double PRECIO_GAMA_ALTA = 50.;
	
	// ATRIBUTOS
	protected String matricula;
	protected TipoGama gama;
	
	// CONSTRUCTORES
	public Vehiculo(String matricula, TipoGama gama) {
		super();
		this.matricula = matricula;
		this.gama = gama;
	}
	
	// GETTERS & SETTERS
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public TipoGama getGama() {
		return gama;
	}
	public void setGama(TipoGama gama) {
		this.gama = gama;
	}
	
	// MÉTODOS
	abstract double precioAlquilerExtra(int numeroDias);
	
	// TOSTRING
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", gama=" + gama + "]";
	}
}
