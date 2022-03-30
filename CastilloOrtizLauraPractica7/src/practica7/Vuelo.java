package practica7;

import java.util.Arrays;

import practica7.exceptions.VueloException;

public class Vuelo {

	// ATRIBUTOS
	private int identificador;
	private String origen;
	private String destino;
	private double precio;
	private int capacidad;
	private Pasajero[] listaPasajeros;
	private int numeroReservas;

	// CONSTRUCTOR
	public Vuelo(int identificador, String origen, String destino, double precio, int capacidad) throws VueloException{
		if(capacidad<=0)	// Si la cantidad de pasajeros (capacidad) introducida es negativa o cero lanza una excepción.
			throw new VueloException("Error");
		
		this.identificador = identificador;
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.capacidad = capacidad;
		this.listaPasajeros= new Pasajero[capacidad];
		this.numeroReservas = 0;  
	}

	// GETTERS
	public int getIdentificador() {
		return identificador;
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public double getPrecio() {
		return precio;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public Pasajero[] getListaPasajeros() {
		return listaPasajeros;
	}

	public int getNumeroReservas() {
		return numeroReservas;
	}

	// MÉTODOS
	/**
	 * Método para introducir un nuevo pasajero a la lista de pasajeros del vuelo.
	 * @param pasajero
	 * @throws VueloException
	 */
	public void introducirPasajero(Pasajero pasajero) throws VueloException {
		if(this.numeroReservas>=this.capacidad)	// Lanza una excepción si la lista de pasajeros está completa.
			throw new VueloException("No se pueden añadir más pasajeros.");
		
		if(buscarPasajero(pasajero.getPasaporte()) != null)		// Lanza una excepción si el pasajero ya existe en la lista de pasajeros del vuelo.
			throw new VueloException("El pasajero ya existe dentro de la lista de pasajeros de este vuelo.");

		this.listaPasajeros[numeroReservas]=pasajero;
		this.numeroReservas++;
	}

	/**
	 * Método que busca si el pasajero ya existe en la lista de pasajeros del vuelo.
	 * @param pasaporte
	 * @return
	 * @throws VueloException
	 */
	private Pasajero buscarPasajero(int pasaporte) {
		Pasajero p = null;
		for (int i=0; i<this.numeroReservas; i++) {											// Itera sobre la lista de pasajeros del vuelo.
			if (listaPasajeros[i]!=null && listaPasajeros[i].getPasaporte()==pasaporte) {	// Si en la posición i hay un pasajero y este tiene el mismo pasaporte que el pasajero que queremos añadir...
				p = listaPasajeros[i];														// Guardamos en p el pasajero.
				break;
			}
		}
		return p;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Vuelo [" + "identificador=" + identificador +
				", origen=" + origen + ", destino=" +
				destino + ", precio=" + precio +
				", capacidad=" + capacidad +
				", listaPasajeros=" + Arrays.toString(listaPasajeros) +
				", numeroReservas=" + numeroReservas + "]";
	}

}
