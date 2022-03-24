package ej4;

public class Clerigo extends Personaje {

	// CONSTANTES
	private final static int INTELIGENCIA_MIN = 12;
	private final static int INTELIGENCIA_MAX = 16;
	private final static int FUERZA_MIN = 18;
	
	// ATRIBUTOS
	private String dios;
	
	// CONSTRUCTORES
	protected Clerigo(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMaxima, String dios)
			throws PersonajeException {
		super(nombre, raza, fuerza, inteligencia, vidaMaxima);
		this.setInteligencia(inteligencia);
		this.setFuerza(fuerza);
		this.dios = dios;
	}
	
	// GETTERS & SETTERS
	public String getDios() {
		return dios;
	}

	public void setDios(String dios) {
		this.dios = dios;
	}
	
	public void setInteligencia(int inteligencia) throws PersonajeException {
		if (inteligencia < INTELIGENCIA_MIN || inteligencia > INTELIGENCIA_MAX){
			throw new PersonajeException("La inteligencia tiene que estar entre "+ INTELIGENCIA_MIN + " y " + INTELIGENCIA_MAX);
		}
		super.setInteligencia(inteligencia);
	}
	
	public void setFuerza(int fuerza) throws PersonajeException {
		if (fuerza < FUERZA_MIN){
			throw new PersonajeException("La fuerza tiene no puede ser menor que " + FUERZA_MIN);
		}
		super.setFuerza(fuerza);
	}
	
	// MÉTODOS
	public void curar(Personaje p) throws PersonajeException {
		if(p.getVidaActual() == p.getVidaMaxima()) {
			throw new PersonajeException("La cura no tiene efecrto sobre el personaje ya que su vida se encuentra al máximo.");
		}
		p.setVidaActual(p.getVidaActual() + 10);
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Clerigo [dios=" + dios + ", toString()=" + super.toString() + "]";
	}
	
}
