package practica7;

import practica7.exceptions.AeropuertoException;

public class AeropuertoPublico extends Aeropuerto {

	// ATRIBUTOS
	private double subvencion;	// Cantidad de dinero correspondiente a la subvención gubernamental.

	// CONSTRUCTOR
	public AeropuertoPublico(String nombre, String ciudad, String pais, int cantidadCompanies, double subvencion) throws AeropuertoException {
		super(nombre, ciudad, pais, cantidadCompanies);
		setSubvencion(subvencion);;
	}

	// GETTERS & SETTERS
	public double getSubvencion() {
		return subvencion;
	}
	
	/*
	 *  El método setSubvencion lo declaramos como private ya que no se podrá modifica la subvención una vez creado el aeropuerto público.
	 */
	private void setSubvencion(double subvencion) throws AeropuertoException {
		if(subvencion<=0)
			throw new AeropuertoException("La subvención del aeropuerto público no puede ser negativa o cero.");
		
		this.subvencion = subvencion;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "AeropuertoPublico [toString()=" + super.toString() + "]";
	}

}
