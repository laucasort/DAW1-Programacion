package empresaAgroalimentaria;

import java.util.Date;

public class ProductoCongelado extends Producto {

	//	Los productos congelados deben llevar la temperatura de congelación
	//	recomendada.
	private double temperaturaCongelacionRec;

	// cONSTRUCTOR
	public ProductoCongelado(Date fechaCaducidad, int numeroLote, double temperaturaCongelacionRec) {
		super(fechaCaducidad, numeroLote);
		this.temperaturaCongelacionRec = temperaturaCongelacionRec;
	}

	// GETTERS & SETTERS
	public double getTemperaturaCongelacionRec() {
		return temperaturaCongelacionRec;
	}
	public void setTemperaturaCongelacionRec(double temperaturaCongelacionRec) {
		this.temperaturaCongelacionRec = temperaturaCongelacionRec;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "ProductoCongelado [temperaturaCongelacionRec=" + temperaturaCongelacionRec + ", fechaCaducidad="
				+ fechaCaducidad + ", numeroLote=" + numeroLote + "]";
	}
	
}
