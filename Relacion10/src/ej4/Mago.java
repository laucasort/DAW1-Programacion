package ej4;

import java.util.Arrays;

public class Mago extends Personaje {

	// CONSTANTES
	private final static int INTELIGENCIA_MIN = 17;
	private final static int FUERZA_MAX = 15;
	
	// ATRIBUTOS
	private String[] hechizos;
	
	// CONSTRUCTOR
	protected Mago(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMaxima)
			throws PersonajeException {
		super(nombre, raza, fuerza, inteligencia, vidaMaxima);
		this.setInteligencia(inteligencia);
		this.setFuerza(fuerza);
		this.hechizos = new String[4];
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Mago [hechizos=" + Arrays.toString(hechizos) + ", toString()=" + super.toString() + "]";
	}
	
	// GETTERS & SETTERS
	public String[] getHechizos() {
		return hechizos;
	}

	public void setHechizos(String[] hechizos) {
		this.hechizos = hechizos;
	}
	
	public void setInteligencia(int inteligencia) throws PersonajeException {
		if (inteligencia < INTELIGENCIA_MIN){
			throw new PersonajeException("La inteligencia no puede ser menor que "+ INTELIGENCIA_MIN);
		}
		super.setInteligencia(inteligencia);
	}
	
	public void setFuerza(int fuerza) throws PersonajeException {
		if (fuerza > FUERZA_MAX){
			throw new PersonajeException("La fuerza tiene no puede ser mayor que " + FUERZA_MAX);
		}
		super.setFuerza(fuerza);
	}
	
	// MÉTODOS
	/**
	 * Método que añade un nuevo hechizo a la lista de hechizos del mago.
	 * @param hechizo
	 * @throws PersonajeException 
	 */
	public void aprendeHechizo(String hechizo) throws PersonajeException {
		boolean espacio = false;
		for(int i=0; i<this.hechizos.length; i++) {
			if(this.hechizos[i] == null) {
				this.hechizos[i] = hechizo.toUpperCase();
				espacio = true;
				break;
			} else if(this.hechizos[i].equals(hechizo.toUpperCase())) {
				throw new PersonajeException("El hechizo ya existe");
			}
		}
		
		if(!espacio) {
			throw new PersonajeException("No se puede añadir un nuevo hechizo.");
		}
	}
	
	public void lanzaHechizo(String hechizo, Personaje p) throws PersonajeException {
		boolean existe = false;
		for(int i=0; i<this.hechizos.length; i++) {
			if(this.hechizos[i]!=null && this.hechizos[i].equals(hechizo.toUpperCase())) {
				p.setVidaActual(p.getVidaActual() - 10);
				this.hechizos[i] = null;
				existe = true;
			}
		}
		
		if(!existe) {
			throw new PersonajeException("El hechizo introducido no existe.");
		}
	}

}
