package ej1;

import java.time.LocalDate;

public class Producto {

	// ATRIBUTOS
	private LocalDate fechaCaducidad;
	private int numeroLote;
	
	// CONSTRUCTORES
	public Producto(LocalDate fechaCaducidad, int numeroLote) throws ProductoException {
		super();
		setFechaCaducidad(fechaCaducidad);
		setNumeroLote(numeroLote);
	}
	
	// GETTERS & SETTERS
	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) throws ProductoException {
		if(fechaCaducidad.isBefore(LocalDate.now())) {
			throw new ProductoException("ERROR: Fecha introducida inv�lida.");
		}
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(int numeroLote) throws ProductoException {
		if(numeroLote < 0) {
			throw new ProductoException("ERROR: El n�mero de lote es inv�lido.");
		}
		this.numeroLote = numeroLote;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Producto [fechaCaducidad=" + fechaCaducidad + ", numeroLote=" + numeroLote + "]";
	}
	
}
