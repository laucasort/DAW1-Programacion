package practica7;

import practica7.exceptions.AeropuertoException;

public class AeropuertoPrivado extends Aeropuerto {

	// ATRIBUTOS
	private String[] empresasPatrocinadoras;		// Lista de empresas patrocinadoras del aeropuerto privado.
	private int	numeroRealDeEmpresasPatrocinadoras;	// Cantidad de empresas patrocinadoras que hay en la lista.
	
	// CONSTRUCTORES
	public AeropuertoPrivado(String nombre, String ciudad, String pais, int cantidadCompanies, int cantidadEmpresasPatrocinadoras)
			throws AeropuertoException {
		super(nombre, ciudad, pais, cantidadCompanies);
		
		if(cantidadEmpresasPatrocinadoras<=0) // Si la cantidad de empresas que patrocinan el aeropuerto privado es menor o igual a cero, se lanza una excepción.
			throw new AeropuertoException("El número de empresas patrocinadoras no puede ser negativo o cero");
	
		this.empresasPatrocinadoras = new String[cantidadEmpresasPatrocinadoras];
		numeroRealDeEmpresasPatrocinadoras = 0;
	}
	
	// GETTERS
	public String[] getEmpresasPatrocinadoras() {
		return empresasPatrocinadoras;
	}

	public int getNumeroRealDeEmpresasPatrocinadoras() {
		return numeroRealDeEmpresasPatrocinadoras;
	}
	
	// MÉTODOS
	/**
	 * Método para introducir una nueva empresa patrocinadora a la lista de empresas patrocinadoras del aeropuerto privado.
	 * @param empresa
	 * @throws AeropuertoException
	 */
	public void introducirEmpresaPatrocinadora(String empresa) throws AeropuertoException {
		if(this.numeroRealDeEmpresasPatrocinadoras>=empresasPatrocinadoras.length)	// Lanza una excepción si la lista de empresas patrocinadoras está completa.
			throw new AeropuertoException("No se pueden añadir más empresas patrocinadoras.");
		
		if(buscarEmpresa(empresa))													// Lanza una excepción si la empresa patrocinadora ya existe en la lista de empresas patrocinadoras del aeropuerto privado.
			throw new AeropuertoException("La empresa patrocinadora ya existe dentro de la lista de empresas patrocinadoras del aeropuerto privado.");
		
		empresasPatrocinadoras[numeroRealDeEmpresasPatrocinadoras] = empresa;
		numeroRealDeEmpresasPatrocinadoras++;
	}

	/**
	 * Método que busca si la empresa patrocinadora ya existe en la lista de empresas patrocinadoras del aeropuerto privado.
	 * @param empresa
	 * @return
	 */
	private boolean buscarEmpresa(String empresa) {
		boolean existe = false;
		for(int i=0; i<this.numeroRealDeEmpresasPatrocinadoras; i++) {							// Itera sobre la lista de empresas patrocinadoras del aeropuerto privado.
			if(empresasPatrocinadoras[i]!=null && empresasPatrocinadoras[i].equals(empresa)) {	// Si en la posición i hay una empresa patrocinadora y esta tiene el mismo nombre que la empresa patrocinadora que queremos añadir...
				existe = true;																	// Ponemos el boolean existe a true.
				break;
			}
		}
		return existe;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "AeropuertoPrivado [toString()=" + super.toString() + "]";
	}
	
}
