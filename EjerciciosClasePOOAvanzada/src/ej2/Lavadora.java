package ej2;

public class Lavadora extends Electrodomestico {

	private double carga;
	
	private final static double DEFAULT_CARGA = 5.;
	
	// CONSTRUCTORES
	public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, double carga) {
		super(precioBase, color, consumoEnergetico, peso);
		this.carga = carga;
	}
	public Lavadora(double precioBase, double peso) {
		this(precioBase, DEFAULT_COLOR, DEFAULT_CONSUMO_ENERGETICO, peso, DEFAULT_CARGA);
	}
	public Lavadora() {
		this(DEFAULT_PRECIO_BASE, DEFAULT_COLOR, DEFAULT_CONSUMO_ENERGETICO, DEFAULT_PESO, DEFAULT_CARGA);
	}	
	
	// GETTERS
	public double getCarga() {
		return carga;
	}
	
	// precioFinal():, si tiene una carga mayor de 30 kg, aumentar� el precio 50 �, sino es
	// as� no se incrementar� el precio. Llama al m�todo padre y a�ade el c�digo necesario.
	// Recuerda que las condiciones que hemos visto en la clase Electrodomestico tambi�n
	// deben afectar al precio.
	public double precioFinal() {
		double res = super.precioFinal();
		if(this.carga>30.) {
			res += 50.;
		}
		return res;
	}
	
}
