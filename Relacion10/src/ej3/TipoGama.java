package ej3;

public enum TipoGama {

	BAJA(Vehiculo.PRECIO_GAMA_BAJA),
	MEDIA(Vehiculo.PRECIO_GAMA_MEDIA),
	ALTA(Vehiculo.PRECIO_GAMA_ALTA);
	
	// ATRIBUTOS
	private double precioGama;
	
	// CONSTRUCTORES
	private TipoGama(double precioGama) {
		this.precioGama = precioGama;
	}
	
	// GETTERS
	public double getPrecioGama() {
		return precioGama;
	}
}
