package ej9_ej10;

import java.time.LocalDate;

public class Libro extends Publicacion implements Prestable {

	// ATRIBUTOS
	private boolean prestado;
	
	// CONSTRUCTORES
	public Libro(String codigo, String titulo, LocalDate fecha) {
		super(codigo, titulo, fecha);
		this.prestado = false;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Libro [prestado=" + prestado + ", codigo=" + codigo + ", titulo=" + titulo + ", fecha=" + fecha + "]";
	}
	
	// MÉTODOS
	@Override
	public void prestar() {
		this.prestado = true;
	}

	@Override
	public void devolver() {
		this.prestado = false;
	}

	@Override
	public boolean prestado() {
		return this.prestado;
	}

}
