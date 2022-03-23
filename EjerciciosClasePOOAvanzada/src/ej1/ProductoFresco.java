package ej1;

import java.time.LocalDate;

public class ProductoFresco extends Producto {

	// ATRIBUTOS
	private LocalDate fechaEnvasado;
	private String pais;
	
	// CONSTRUCTORES
	public ProductoFresco(LocalDate fechaCaducidad, int numeroLote, LocalDate fechaEnvasado, String pais)
			throws ProductoException {
		super(fechaCaducidad, numeroLote);
		this.fechaEnvasado = fechaEnvasado;
		this.pais = pais;
	}
	
	// GETTERS & SETTER
	public LocalDate getFechaEnvasado() {
		return fechaEnvasado;
	}

	public void setFechaEnvasado(LocalDate fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "ProductoFresco [fechaEnvasado=" + fechaEnvasado + ", pais=" + pais + ", toString()=" + super.toString()
				+ "]";
	}
	
}
