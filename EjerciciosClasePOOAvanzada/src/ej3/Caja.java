package ej3;

public class Caja {

	// Las empresas de transportes, para evitar daños en los paquetes, embalan todas sus
	// mercancías en cajas con el tamaño adecuado. Una caja se crea expresamente con un
	// ancho, un alto y un fondo y, una vez creada, se mantiene inmutable. 
	// Cada caja lleva pegada una etiqueta con información útil como el nombre del 
	// destinatario, dirección, etc. 
	// Se pide implementar la clase Caja con los siguientes métodos:
	// • Caja (int ancho, int alto, int fondo, Unidades u): que construye una caja con las
	// dimensiones especificadas, que pueden encontrarse en diferentes unidades: “cm”
	// (centímetros) o “m” (metros).
	// • double getVolumen(): que devuelve el volumen de la caja en metros cuadrados.
	// • String toString(): que devuelva una cadena con la representación de la caja.
	
	// ATRIBUTOS
	private String etiqueta;
	private int ancho;
	private int alto;
	private int fondo;
	private Unidades u;
	
	// CONSTRUCTOR
	public Caja(int ancho, int alto, int fondo, Unidades u) {
		this.ancho = ancho;
		this.alto = alto;
		this.fondo = fondo;
		this.u = u;
	}

	// GETTERS
	public String getEtiqueta() {
		return etiqueta;
	}
	public int getAncho() {
		return ancho;
	}
	public int getAlto() {
		return alto;
	}
	public int getFondo() {
		return fondo;
	}
	public Unidades getU() {
		return u;
	}
	
	// MÉTODOS
	public double getVolumen() {
		double volumen = this.ancho * this.alto * this.fondo;
		if(this.u.name().equals(Unidades.cm.toString())) {
			volumen = volumen/1000000.;
		}
		return volumen;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Caja [etiqueta=" + etiqueta + ", ancho=" + ancho + ", alto=" + alto + ", fondo=" + fondo + ", u=" + u
				+ "]";
	}	
	
}
