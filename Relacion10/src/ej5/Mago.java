package ej5;

public class Mago extends Personaje {
	
	/**
	 * FUERZA MAXIMA DEL MAGO
	 */
	public final int FUERZA_MAX = 15; 
	/**
	 * INTELIGENCIA MINIMA DEL MAGO
	 */
	public final int FUERZA_MIN = 17;
	/**
	 * NUMERO MAXIMO DE HECHIZOS QUE PUEDE APRENDER
	 */
	public final int HECHIZOS_MAX = 4;
	/**
	 * NUMERO DE PUNTOS QUE SE PIERDE AL RECIBIR UN HECHIZO
	 */
	public  final int DANNO = 10;
	
	/**
	 * Array de hechizos
	 */
	private String hechizos[]; 

	// Constructor
	public Mago(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMaxima)
			throws PersonajeException {
		super(nombre, raza, fuerza, inteligencia, vidaMaxima);		
		this.setInteligencia(inteligencia);
		this.setFuerza(fuerza);
		hechizos = new String[HECHIZOS_MAX];
	}

	/**
	 * Modifica la inteligenicia del Mago, controlando que est� en el rango adecuado. Si no lo estuviese
	 * lanzar�a la excepci�n
	 * @param inteligencia Nueva inteligencia
	 */
	
	public void setInteligencia(int inteligencia) throws PersonajeException {
		
		if (inteligencia < FUERZA_MIN) {
			throw new PersonajeException(
					"La inteligencia no puede ser menor que " + FUERZA_MIN + " para el mago");
		}
		super.setInteligencia(inteligencia);

	}

	/**
	 * Modifica la fuerza del Mago, controlando que est� en el rango adecuado. Si no lo estuviese lanzar�a la
	 * excepci�n
	 * @param fuerza Nueva fuerza
	 */
	public void setFuerza(int fuerza) throws PersonajeException {
		if (fuerza > FUERZA_MAX) {
			throw new PersonajeException(
					"La fuerza no puede ser mayor que " + FUERZA_MAX+ " para el mago");
		}
		super.setFuerza(fuerza);

	}


	/**
	 * Aprende un nuevo hechizo, insertandolo en el array de hechizos. Si no puede aprenderlo porque no hay
	 * ning�n hueco el array lanzar� la excepci�n
	 * @param hechizo Nombre del hechizo que se va a aprender
	 * @throws PersonajeException
	 */
	public void aprenderHechizo(String hechizo) throws PersonajeException {
		int posicion = -1;

		//Comprobar que el hechizo no este repetido
		hechizo= hechizo.toUpperCase();
		posicion=buscarHechizo(hechizo);
		if ( posicion != -1) // ya existe ese hechizo
			throw new PersonajeException("Ya existe ese hechizo");
		
		// Buscar el sitio para este nuevo hechizo
		posicion = comprobarHuecoHechizo();
		if (posicion == -1) { // el array esta lleno, no hay hueco
			throw new PersonajeException("No puedo aprender mas hechizos");
		}
		
	
		hechizos[posicion] = hechizo;
		
	}

	/**
	 * Busca una posici�n a null en el array de hechizos
	 * @return Posici�n donde est� el primer hueco ( valor null) en el array  o -1 si no existiese hueco
	 */
	private int comprobarHuecoHechizo() {
		int i = 0, posicion = -1;

		while (i < HECHIZOS_MAX && posicion == -1) {

			if (hechizos[i] == null) {
				posicion = i;
			}
			i++;
		}
		return posicion;
	}
	
	/**
	 * Busca la posici�n de un hechizo en el array de hechizos
	 * @param Hechizo que se va a buscar
	 * @return posici�n del hechizo en el array o -1 si no se encuentra
	 */
	private int buscarHechizo(String hechizo) {
		int i = 0, posicion = -1;

		while (i < HECHIZOS_MAX && posicion == -1) {

			if (hechizos[i]!= null && hechizos[i].equals(hechizo)) {
				posicion = i;
			}
			i++;
		}
		return posicion;
	}
	/**
	 * Lanza un hechizo ya aprendido sobre un personaje
	 * @param magia Nombre del hechizo ya aprendido. Si no estuviera en el array de hechizos lanzar�a la excepci�n.
	 * Cuando se lanza un hechizo se olvida (se borra del array) 
	 * @param otro Personaje sobre el que se lanzara el hechizo
	 * @throws PersonajeException
	 * @throws MuerteException 
	 */
	public void lanzarHechizo(String hechizo, Personaje otro)
			throws PersonajeException {
		
		int posicion = -1;
		
		if ( this.equals(otro))
			throw new PersonajeException("No se puede lanzar un hechizo a sí mismo");
		
		hechizo= hechizo.toUpperCase();
		posicion = buscarHechizo(hechizo);

		if (posicion == -1) {
			throw new PersonajeException("No conozco este hechizo");
		} 
		hacerDanno(otro);
		hechizos[posicion] = null;
		
	}

	/**
	 * Decrementa la vida del personaje. Si al hacerlo, el resultado de la vida fuese negativo o cero, se pone
	 * la vida a cero y se lanza la excepci�n
	 * @param otro Nombre del personaje que se va a da�ar (decrementar su vida)
	 * @throws PersonajeException
	 */
	
	private void hacerDanno(Personaje otro) throws PersonajeException {

		if (otro.getVidaActual() - DANNO <= 0) { // si al hacer el da�o se pone a negativo se pondr�a a 0 su vida
			otro.setVidaActual(0);
			throw new PersonajeException("El PERSONAJE " + otro.getNombre() + " ESTA MUERTO");
		} 

		otro.setVidaActual(otro.getVidaActual() - DANNO);
		
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder(200);
		int i;

		cadena.append("Mago " + super.toString() + "\n Libro de hechizos:  ");
				
		for (i = 0; i < HECHIZOS_MAX; i++) {

			if (hechizos[i] != null) {
				cadena.append(hechizos[i] + " ");
			}
			

		}
		cadena.append("\n");

		return cadena.toString();
	}

}
