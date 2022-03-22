package ej9_ej10;

import java.time.LocalDate;

public class Publicacion {
		
		// ATRIBUTOS
		protected String codigo;
		protected String titulo;
		protected LocalDate fecha;
		
		// CONSTRUCTOR
		public Publicacion(String codigo, String titulo, LocalDate fecha) {
			this.codigo = codigo;
			this.titulo = titulo;
			this.fecha = fecha;
		}
		
		// TOSTRING
		@Override
		public String toString() {
			return "ArticuloBiblioteca [codigo=" + codigo + ", titulo=" + titulo + ", fecha=" + fecha + "]";
		}
		
		// GETTERS & SETTERS
		public String getCodigo() {
			return codigo;
		}

		// M�TODOS
		/**
		 * M�todo que devuelve el a�o de publicaci�n.
		 * @return int
		 */
		public int releaseYear() {
			return this.fecha.getYear();
		}
}
