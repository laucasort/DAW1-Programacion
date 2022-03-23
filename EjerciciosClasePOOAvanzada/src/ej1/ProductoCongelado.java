package ej1;

import java.time.LocalDate;

public class ProductoCongelado extends Producto {

	// ATRIBUTOS
	private double temperaturaCongelacion;

	// CONSTRUCTORES
	public ProductoCongelado(LocalDate fechaCaducidad, int numeroLote, double temperaturaCongelacion)
			throws ProductoException {
		super(fechaCaducidad, numeroLote);
		this.temperaturaCongelacion = temperaturaCongelacion;
	}

	// GETTERS & SETTER
	public double getTemperaturaCongelacion() {
		return temperaturaCongelacion;
	}

	public void setTemperaturaCongelacion(double temperaturaCongelacion) {
		this.temperaturaCongelacion = temperaturaCongelacion;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "ProductoCongelado [temperaturaCongelacion=" + temperaturaCongelacion + ", toString()="
				+ super.toString() + "]";
	}
	
}
