package empresaAgroalimentaria;

import java.util.Date;

public class Producto {

	//	Todos los productos llevan esta información común:
	//	fecha de caducidad y número de lote.
	protected Date fechaCaducidad;
	protected int numeroLote;
	
	// CONSTRUCTOR
	public Producto(Date fechaCaducidad, int numeroLote) {
		super();
		this.fechaCaducidad = fechaCaducidad;
		this.numeroLote = numeroLote;
	}

	// GETTERS & SETTER
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public int getNumeroLote() {
		return numeroLote;
	}
	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Producto [fechaCaducidad=" + fechaCaducidad + ", numeroLote=" + numeroLote + "]";
	}
	
}
