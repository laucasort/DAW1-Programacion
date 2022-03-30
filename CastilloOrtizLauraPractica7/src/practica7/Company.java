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
		if(cantidadDeVuelos<=0)	// Si la cantidad de vuelos introducida es negativa o cero lanza una excepci�n.
			throw new CompanyException("El n�mero de vuelos no puede ser negativo o cero.");

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

	// M�TODOS
	/**
	 * M�todo para introducir un nuevo vuelo a la lista de vuelos de la compa��a.
	 * @param company
	 * @throws AeropuertoException
	 */
	public void introducirVuelo(Vuelo vuelo) throws CompanyException {
		if(this.numeroRealDeVuelos>=this.vuelos.length)		// Lanza una excepci�n si la lista de vuelos de la compa��a est� completa.
			throw new CompanyException("No se pueden a�adir m�s compa�ias.");
		
		if(buscarVuelo(vuelo.getIdentificador()) != null)	// Lanza una excepci�n si el vuelo ya existe en la lista de vuelos de la compa��a.
			throw new CompanyException("La compa��a ya existe dentro de la lista de compa�ias de este aeropuerto.");
		
		vuelos[numeroRealDeVuelos] = vuelo;
		numeroRealDeVuelos++;
	}

	/**
	 * M�todo que busca si el vuelo ya existe en la lista de vuelos de la compa��a.
	 * @param nombre
	 * @return
	 */
	private Vuelo buscarVuelo(int id) {
		Vuelo v = null;
		for(int i=0; i<this.numeroRealDeVuelos; i++) {					// Itera sobre la lista de vuelos de la compa��a.
			if(vuelos[i]!=null && vuelos[i].getIdentificador() == id) {	// Si en la posici�n i hay un vuelo y este tiene el mismo identificador que el vuelo que queremos a�adir...
				v = vuelos[i];											// Guardamos en v el vuelo.
				break;
			}
		}
		return v;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Compa��a [" + "nombre=" + nombre + ", vuelos=" + Arrays.toString(vuelos) + "]";
	}

}
