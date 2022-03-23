package ej3;

public enum TipoCombustible {

	GASOLINA(Coche.PRECIO_GASOLINA),
	DIESEL(Coche.PRECIO_DIESEL);
	
	// ATRIBUTOS
	private double precioCombustible;
	
	// CONSTRUCTORES
	private TipoCombustible(double precioCombustible) {
		this.precioCombustible = precioCombustible;
	}

	// GETTERS
	public double getPrecioCombustible() {
		return precioCombustible;
	}
	
}
