package practica7;

import practica7.exceptions.AeropuertoException;

// Declaramos la clase tipo abstract para que as� no podamos crear aeropuertos, solo aeropuertos privados o p�blicos.
abstract class Aeropuerto {
	
	// ATRIBUTOS
	protected Company[] companies;		// Compa��as de vuelo que operan en el aeropuesto.
	protected String nombre;			// Nombre del aeropuerto.
	protected String ciudad;			// Ciudad en la que se ubica el aeropuerto.
	protected String pais;				// Pa�s en el que se ubica el aeropuerto.
	private int numeroRealDeCompanies;	// Variable que guarda donde se insertar� la siguiente compa��a. Empieza con 0 y si vale companies.length la lista de compa��as est� llena.
	
	// CONSTRUCTOR
	protected Aeropuerto(String nombre, String ciudad, String pais, int cantidadCompanies) throws AeropuertoException {
		if (cantidadCompanies<=0)	// Si la cantidad de compa��as introducida es negativa o cero lanza una excepci�n.
			throw new AeropuertoException("El n�mero de compa��as no puede ser negativo o cero.");
		
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
	
	// M�TODOS
	/**
	 * M�todo para introducir una nueva compa��a a la lista de compa��as del aeropuerto.
	 * @param company
	 * @throws AeropuertoException
	 */
	public void introducirCompany(Company company) throws AeropuertoException {
		if(this.numeroRealDeCompanies>=companies.length)	// Lanza una excepci�n si la lista de compa��as est� completa.
			throw new AeropuertoException("No se pueden a�adir m�s compa�ias.");
		
		if(buscarCompany(company.getNombre()) != null)		// Lanza una excepci�n si la compa��a ya existe en la lista de compa��as del aeropuerto.
			throw new AeropuertoException("La compa��a ya existe dentro de la lista de compa�ias de este aeropuerto.");
		
		companies[numeroRealDeCompanies] = company;
		numeroRealDeCompanies++;
	}
	
	/**
	 * M�todo que busca si la compa��a ya existe en la lista de compa��as del aeropuerto.
	 * @param nombre
	 * @return
	 */
	private Company buscarCompany(String nombre) {
		Company c = null;
		for(int i=0; i<this.numeroRealDeCompanies; i++) {						// Itera sobre la lista de compa��as del aeropuerto.
			if(companies[i]!=null && companies[i].getNombre().equals(nombre)) {	// Si en la posici�n i hay una compa��a y esta tiene el mismo nombre que la compa��a que queremos a�adir...
				c = companies[i];												// Guardamos en c la compa��a.
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
			Vuelo[] vuelos = this.companies[i].getVuelos();					// Listado de vuelos de la compa��a i.
			for(int j=0; j<this.companies[i].getNumeroRealVuelos(); j++) {	// Itera sobre los vuelos de los que dispone la compa��a i.
				if(vuelos[j].getOrigen().equals(origen) && vuelos[j].getDestino().equals(destino))
					System.out.println("   � Comapa��a " + this.companies[i].getNombre() + " -> Vuelo " + vuelos[j].getIdentificador() + ": " + vuelos[j].getPrecio());
			}
		}
	}

	/**
	 * M�todo que muestra por pantalla los vuelos que tiene una compa��a del aeropuerto.
	 * @param company
	 * @throws AeropuertoException 
	 */
	public void vuelosPorCompanyYAeropuerto(String company) {
		Company c = buscarCompany(company);
		
		// No lanzamos una excepci�n si la compa��a no existe en la lista de compa��as de ese aeropuerto dado que de la manera que pedimos los
		// datos al usuario no se puede dar esta situaci�n.
		
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
