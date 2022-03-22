package ej2;

public class Electrodomestico {

	// precio base, color, consumo energético (letras entre A y F) y peso.
	protected double precioBase;
	protected String color;
	protected char consumoEnergetico;
	protected double peso;
	
	// Por defecto, el color será blanco, el consumo energético será F, el precioBase es 
	// de 100€ y el peso de 5 kg. Usa constantes para ello.
	protected final static String DEFAULT_COLOR = "BLANCO";
	protected final static char DEFAULT_CONSUMO_ENERGETICO = 'F';
	protected final static double DEFAULT_PRECIO_BASE = 100.;
	protected final static double DEFAULT_PESO = 5.;
	private final static double[] PRECIO_CONSUMO = {100., 80., 60., 50., 30., 10.};
	private final static double[] PRECIO_PESO = {10., 50., 80., 100.};
	
	public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
		super();
		this.precioBase = precioBase;
		this.color = comprobarColor(color);
		this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
		this.peso = peso;
	}
	public Electrodomestico(double precioBase, double peso) {
		this(precioBase, DEFAULT_COLOR, DEFAULT_CONSUMO_ENERGETICO, peso);
	}
	public Electrodomestico() {
		this(DEFAULT_PRECIO_BASE, DEFAULT_COLOR, DEFAULT_CONSUMO_ENERGETICO, DEFAULT_PESO);
	}
	
	// GETTERS
	public double getPrecioBase() {
		return precioBase;
	}
	public String getColor() {
		return color;
	}
	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}
	public double getPeso() {
		return peso;
	}
	
	// comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta,
	// sino es correcta usará la letra por defecto. Se invocará al crear el objeto y no sera
	// visible.
	private char comprobarConsumoEnergetico(char letra) {
		char res = Character.toUpperCase(letra);
		if(letra!='A' && letra!='B' && letra!='C' && letra!='D' && letra!='E' && letra!='F') {
			res = DEFAULT_CONSUMO_ENERGETICO;
		}
		return res;
	}
	
	// comprobarColor(String color): comprueba que el color es correcto, sino lo es usa el
	// color por defecto. Se invocará al crear el objeto y no será visible.
	private String comprobarColor(String color) {
		boolean b = false;
		String res = color;
		for(Colores c:Colores.values()) {
			if(c.toString().equals(color.toUpperCase())) {
				b = true;
				res = color.toUpperCase();
			}
		}
		if(!b) {
			res = DEFAULT_COLOR;
		}
		return res;
	}
	
	// precioFinal(): según el consumo energético, aumentará su precio, y según su tamaño,
	// también.
	public double precioFinal() {
		double res = this.precioBase;
		
		switch(this.consumoEnergetico) {
		case 'A':
			res += PRECIO_CONSUMO[0];
			break;
		case 'B':
			res += PRECIO_CONSUMO[1];
			break;
		case 'C':
			res += PRECIO_CONSUMO[2];
			break;
		case 'D':
			res += PRECIO_CONSUMO[3];
			break;
		case 'E':
			res += PRECIO_CONSUMO[4];
			break;
		case 'F':
			res += PRECIO_CONSUMO[5];
			break;
		}
		
		if(this.peso>=0. && this.peso<=19.) {
			res += PRECIO_PESO[0];
		} else if(this.peso>=20. && this.peso<=49.) {
			res += PRECIO_PESO[1];
		} else if(this.peso>=50. && this.peso<=79.) {
			res += PRECIO_PESO[2];
		} else {
			res += PRECIO_PESO[3];
		}
		
		return res;
	}

	
}
