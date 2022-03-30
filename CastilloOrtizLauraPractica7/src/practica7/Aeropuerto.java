package practica7;

import practica7.exceptions.AeropuertoException;

// Declaramos la clase tipo abstract para que así no podamos crear aeropuertos, solo aeropuertos privados o públicos.
abstract class Aeropuerto {
	
	// ATRIBUTOS
	protected Company[] companies;		// Compañías de vuelo que operan en el aeropuesto.
	protected String nombre;			// Nombre del aeropuerto.
	protected String ciudad;			// Ciudad en la que se ubica el aeropuerto.
	protected String pais;				// País en el que se ubica el aeropuerto.
	private int numeroRealDeCompanies;	// Variable que guarda donde se insertará la siguiente compañía. Empieza con 0 y si vale companies.length la lista de compañías está llena.
	
	// CONSTRUCTOR
	protected Aeropuerto(String nombre, String ciudad, String pais, int cantidadCompanies) throws AeropuertoException {
		if (cantidadCompanies<=0)	// Si la cantidad de compañías introducida es negativa o cero lanza una excepción.
			throw new AeropuertoException("El número de compañías no puede ser negativo o cero.");
		
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		companies = new Company[cantidadCompanies];
		numeroRealDeCompanies = 0;
	}
	
	// GETTERS
	public Company[] getCompanies() {
		return companies;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getPais() {
		return pais;
	}
	
	public int getNumeroRealDeCompanies() {
		return numeroRealDeCompanies;
	}
	
	// MÉTODOS
	/**
	 * Método para introducir una nueva compañía a la lista de compañías del aeropuerto.
	 * @param company
	 * @throws AeropuertoException
	 */
	public void introducirCompany(Company company) throws AeropuertoException {
		if(this.numeroRealDeCompanies>=companies.length)	// Lanza una excepción si la lista de compañías está completa.
			throw new AeropuertoException("No se pueden añadir más compañias.");
		
		if(buscarCompany(company.getNombre()) != null)		// Lanza una excepción si la compañía ya existe en la lista de compañías del aeropuerto.
			throw new AeropuertoException("La compañía ya existe dentro de la lista de compañias de este aeropuerto.");
		
		companies[numeroRealDeCompanies] = company;
		numeroRealDeCompanies++;
	}
	
	/**
	 * Método que busca si la compañía ya existe en la lista de compañías del aeropuerto.
	 * @param nombre
	 * @return
	 */
	private Company buscarCompany(String nombre) {
		Company c = null;
		for(int i=0; i<this.numeroRealDeCompanies; i++) {						// Itera sobre la lista de compañías del aeropuerto.
			if(companies[i]!=null && companies[i].getNombre().equals(nombre)) {	// Si en la posición i hay una compañía y esta tiene el mismo nombre que la compañía que queremos añadir...
				c = companies[i];												// Guardamos en c la compañía.
				break;
			}
		}
		return c;
	}
	
	/**
	 * Muestra por pantalla los vuelos que existen en el aeropuerto de un origen a un destino concreto.
	 * @param origen
	 * @param destino
	 */
	public void vuelosPorOrigenYDestino(String origen, String destino) {
		for(int i=0; i<this.numeroRealDeCompanies; i++) {
			Vuelo[] vuelos = this.companies[i].getVuelos();					// Listado de vuelos de la compañía i.
			for(int j=0; j<this.companies[i].getNumeroRealVuelos(); j++) {	// Itera sobre los vuelos de los que dispone la compañía i.
				if(vuelos[j].getOrigen().equals(origen) && vuelos[j].getDestino().equals(destino))
					System.out.println("   · Comapañía " + this.companies[i].getNombre() + " -> Vuelo " + vuelos[j].getIdentificador() + ": " + vuelos[j].getPrecio());
			}
		}
	}

	/**
	 * Método que muestra por pantalla los vuelos que tiene una compañía del aeropuerto.
	 * @param company
	 * @throws AeropuertoException 
	 */
	public void vuelosPorCompanyYAeropuerto(String company) {
		Company c = buscarCompany(company);
		
		// No lanzamos una excepción si la compañía no existe en la lista de compañías de ese aeropuerto dado que de la manera que pedimos los
		// datos al usuario no se puede dar esta situación.
		
		Vuelo[] vuelos = c.getVuelos();
		for(int i=0; i<c.getNumeroRealVuelos(); i++) {
			System.out.println("- Vuelo " + vuelos[i].getIdentificador() + " [origen=" + vuelos[i].getOrigen() 
					+ ", destino=" + vuelos[i].getDestino() + ", precio=" + vuelos[i].getPrecio() + "]");
		}
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Aeropuerto [nombre=" + nombre + ", ciudad=" + ciudad + ", pais=" + pais + "]";
	}
	
}
