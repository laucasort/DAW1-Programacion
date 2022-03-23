package ej3;

public class FlotaVehiculos {
	
	// ATRIBUTOS
	/**
	 * Conjunto de vehículos que posee la empresa.
	 */
	private Vehiculo vehiculos[];
	/**
	 *  Variable que guarda donde se insertará el siguiente vehiculo
	 *  Empieza con 0 y si vale vehiculos.length el almacen esta lleno.
	 */
	private int numeroRealDeVehiculos;

	// CONSTRUCTORES
	public FlotaVehiculos(int capacidadAlmacen) throws VehiculoException {
		if (capacidadAlmacen <= 0)
			throw new VehiculoException("Numero de vehiculos no puede ser negativo o cero");
		vehiculos = new Vehiculo[capacidadAlmacen];
		numeroRealDeVehiculos = 0;
	}

	// MÉTODOS
	/**
	 * Este método guarda un vehículo en la flota.
	 * @param vehiculo
	 * @throws VehiculoException
	 */
	public void introducirVehiculo(Vehiculo vehiculo) throws VehiculoException {
		if(numeroRealDeVehiculos >= this.vehiculos.length) {
			throw new VehiculoException("ERROR: No puede añadir más vehículos a la flota.");
		}
		if(buscarMatricula(vehiculo.matricula) != null) {
			throw new VehiculoException("ERROR: El vehículo ya existe en la flota.");
		}
		
		this.vehiculos[numeroRealDeVehiculos] = vehiculo;
		numeroRealDeVehiculos++;
	}
	/**
	 * Busca un vehículo por su matrícula.
	 * @param matricula
	 * @return Vehiculo
	 */
	private Vehiculo buscarMatricula(String matricula) {
		Vehiculo v = null;
		for(int i=0; i<=numeroRealDeVehiculos; i++) {
			if(this.vehiculos[i]!=null && this.vehiculos[i].matricula.equals(matricula)) {
				v = this.vehiculos[i];
				break;
			}
		}
		
		return v;
	}
	/**
	 * Devuelve el precio total del alquiler de un vehículo.
	 * @param matricula
	 * @param dias
	 * @return double
	 * @throws VehiculoException
	 */
	public double precioAlquiler(String matricula, int dias) throws VehiculoException {
		double precio = 0.;

		Vehiculo v = buscarMatricula(matricula);
		if(v == null) {
			throw new VehiculoException("ERROR: La matricula introducida no existe en la flota.");
		}
		
		switch(v.gama) {
		case BAJA:
			precio += (TipoGama.BAJA.getPrecioGama() * dias);
			break;
		case MEDIA:
			precio += (TipoGama.MEDIA.getPrecioGama() * dias);
			break;
		case ALTA:
			precio += (TipoGama.ALTA.getPrecioGama() * dias);
			break;
		}
		
		return precio + v.precioAlquilerExtra(dias);
	}
	
	// TOSTRING
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < numeroRealDeVehiculos; i++) {
			sb.append(vehiculos[i].toString());
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
