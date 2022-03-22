package ej9_ej10;

import java.time.LocalDate;

public class Revista extends Publicacion {

	// ATRIBUTOS
	private int numero;
	
	// CONSTRUCTORES
	public Revista(String codigo, String titulo, LocalDate fecha, int numero) throws Exception {
		super(codigo, titulo, fecha);
		setNumero(numero);
	}
	
	// GETTERS & SETTERS
	private void setNumero(int numero) throws Exception {
		if(numero < 0) {
			throw new Exception("ERROR: El número de la revista no puede ser negativo.");
		}
		this.numero = numero;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Revista [numero=" + numero + ", codigo=" + codigo + ", titulo=" + titulo + ", fecha=" + fecha + "]";
	}
}
