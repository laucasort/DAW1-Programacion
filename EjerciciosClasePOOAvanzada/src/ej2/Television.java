package ej2;

public class Television extends Electrodomestico {

	// resolución (en pulgadas) y sintonizador TDT (booleano)
	private double pulgadas;
	private boolean sintonizadorTDT;
	
	// Por defecto, la resolución será de 20 pulgadas y el sintonizador será false.
	private final static double DEFAULT_PULGADAS = 20.;
	private final static boolean DEFAULT_SINTONIZADOR_TDT = false;
	
	// CONSTRUCTORES
	public Television(double precioBase, String color, char consumoEnergetico, double peso, double pulgadas,
			boolean sintonizadorTDT) {
		super(precioBase, color, consumoEnergetico, peso);
		this.pulgadas = pulgadas;
		this.sintonizadorTDT = sintonizadorTDT;
	}
	public Television(double precioBase, double peso) {
		this(precioBase, DEFAULT_COLOR, DEFAULT_CONSUMO_ENERGETICO, peso, DEFAULT_PULGADAS, DEFAULT_SINTONIZADOR_TDT);
	}
	public Television() {
		this(DEFAULT_PRECIO_BASE, DEFAULT_COLOR, DEFAULT_CONSUMO_ENERGETICO, DEFAULT_PESO, DEFAULT_PULGADAS, DEFAULT_SINTONIZADOR_TDT);
	}	
	
	// GETTERS
	public double getPulgadas() {
		return pulgadas;
	}
	public boolean isSintonizadorTDT() {
		return sintonizadorTDT;
	}
	
	// precioFinal(): si tiene una resolución mayor de 40 pulgadas, se incrementará 
	// el precio un 30% y si tiene un sintonizador TDT incorporado, aumentará 50 €.
	public double precioFinal() {
		double res = super.precioFinal();
		
		if(this.pulgadas > 40) {
			res = res*1.3;
		}
		if(this.sintonizadorTDT) {
			res += 50;
		}
		
		return res;
	}
	
}
