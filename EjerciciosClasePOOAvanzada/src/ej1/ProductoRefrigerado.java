package ej1;

import java.time.LocalDate;

public class ProductoRefrigerado extends Producto {

	// ATRIBUTOS
	private int codigoOrganismoSupervisionAlimentaria;

	// CONSTRUCTORES
	public ProductoRefrigerado(LocalDate fechaCaducidad, int numeroLote, int codigoOrganismoSupervisionAlimentaria)
			throws ProductoException {
		super(fechaCaducidad, numeroLote);
		this.codigoOrganismoSupervisionAlimentaria = codigoOrganismoSupervisionAlimentaria;
	}

	// GETTERS & SETTER
	public int getCodigoOrganismoSupervisionAlimentaria() {
		return codigoOrganismoSupervisionAlimentaria;
	}

	public void setCodigoOrganismoSupervisionAlimentaria(int codigoOrganismoSupervisionAlimentaria) {
		this.codigoOrganismoSupervisionAlimentaria = codigoOrganismoSupervisionAlimentaria;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "ProductoRefrigerado [codigoOrganismoSupervisionAlimentaria=" + codigoOrganismoSupervisionAlimentaria
				+ ", toString()=" + super.toString() + "]";
	}

}
