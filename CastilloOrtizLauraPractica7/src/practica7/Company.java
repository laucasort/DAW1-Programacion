package practica7;

import java.util.Arrays;

import practica7.exceptions.AeropuertoException;
import practica7.exceptions.CompanyException;

public class Company {

	// ATRIBUTOS
	private String nombre;
	private Vuelo [] vuelos;
	private int numeroRealDeVuelos;

	// CONSTRUCTOR
	public Company(String nombre, int cantidadDeVuelos) throws CompanyException{
		if(cantidadDeVuelos<=0)	// Si la cantidad de vuelos introducida es negativa o cero lanza una excepción.
			throw new CompanyException("El número de vuelos no puede ser negativo o cero.");

		this.nombre = nombre;
		this.vuelos = new Vuelo[cantidadDeVuelos];
		this.numeroRealDeVuelos = 0;
	}

	// GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public Vuelo[] getVuelos() {
		return vuelos;
	}

	public int getNumeroRealVuelos() {
		return numeroRealDeVuelos;
	}

	// MÉTODOS
	/**
	 * Método para introducir un nuevo vuelo a la lista de vuelos de la compañía.
	 * @param company
	 * @throws AeropuertoException
	 */
	public void introducirVuelo(Vuelo vuelo) throws CompanyException {
		if(this.numeroRealDeVuelos>=this.vuelos.length)		// Lanza una excepción si la lista de vuelos de la compañía está completa.
			throw new CompanyException("No se pueden añadir más compañias.");
		
		if(buscarVuelo(vuelo.getIdentificador()) != null)	// Lanza una excepción si el vuelo ya existe en la lista de vuelos de la compañía.
			throw new CompanyException("La compañía ya existe dentro de la lista de compañias de este aeropuerto.");
		
		vuelos[numeroRealDeVuelos] = vuelo;
		numeroRealDeVuelos++;
	}

	/**
	 * Método que busca si el vuelo ya existe en la lista de vuelos de la compañía.
	 * @param nombre
	 * @return
	 */
	private Vuelo buscarVuelo(int id) {
		Vuelo v = null;
		for(int i=0; i<this.numeroRealDeVuelos; i++) {					// Itera sobre la lista de vuelos de la compañía.
			if(vuelos[i]!=null && vuelos[i].getIdentificador() == id) {	// Si en la posición i hay un vuelo y este tiene el mismo identificador que el vuelo que queremos añadir...
				v = vuelos[i];											// Guardamos en v el vuelo.
				break;
			}
		}
		return v;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Compañía [" + "nombre=" + nombre + ", vuelos=" + Arrays.toString(vuelos) + "]";
	}

}
