package ej3;

public class Principal {

	public static void main(String[] args) {
		
		Caja c = new Caja(5, 5, 5, Unidades.cm);
		
		System.out.println(c.toString());
		System.out.println("Volumen: " + c.getVolumen());
		
	}

}
