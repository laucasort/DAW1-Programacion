package empresaAgroalimentaria;

import java.util.Date;

public class ProductoRefrigerado extends Producto {

	//	 Los productos refrigerados deben llevar el código del organismo de supervisión
	//	 alimentaria.
	private int codigoOrgSupervision;

	// CONSTRUCTOR
	public ProductoRefrigerado(Date fechaCaducidad, int numeroLote, int codigoOrgSupervision) {
		super(fechaCaducidad, numeroLote);
		this.codigoOrgSupervision = codigoOrgSupervision;
	}

	// GETTERS & SETTERS
	public int getCodigoOrgSupervision() {
		return codigoOrgSupervision;
	}
	public void setCodigoOrgSupervision(int codigoOrgSupervision) {
		this.codigoOrgSupervision = codigoOrgSupervision;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "ProductoRefrigerado [codigoOrgSupervision=" + codigoOrgSupervision + ", fechaCaducidad="
				+ fechaCaducidad + ", numeroLote=" + numeroLote + "]";
	}

}
