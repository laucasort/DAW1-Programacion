package empresaAgroalimentaria;

import java.util.Date;

public class ProductoFresco extends Producto {

	//	Los productos frescos deben llevar la fecha de envasado y el país
	//	de origen.
	private Date fechaEnvasado;
	private String paisOrigen;
	
	// CONSTRUCTOR
	public ProductoFresco(Date fechaCaducidad, int numeroLote, Date fechaEnvasado, String paisOrigen) {
		super(fechaCaducidad, numeroLote);
		this.fechaEnvasado = fechaEnvasado;
		this.paisOrigen = paisOrigen;
	}
	
	// GETTERS & SETTERS
	public Date getFechaEnvasado() {
		return fechaEnvasado;
	}
	public void setFechaEnvasado(Date fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "ProductoFresco [fechaEnvasado=" + fechaEnvasado + ", paisOrigen=" + paisOrigen + ", fechaCaducidad="
				+ fechaCaducidad + ", numeroLote=" + numeroLote + "]";
	}
	
}
