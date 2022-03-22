package ej2;

public class Principal {

	public static void main(String[] args) {
		// Crea un array de Electrodomesticos de 10 posiciones.
		Electrodomestico[] electrodomesticos = new Electrodomestico[10];
		//	• Asigna a cada posición un objeto de las clases anteriores con los valores 
		//	que desees.
		electrodomesticos[0] = new Electrodomestico();
		electrodomesticos[1] = new Lavadora();
		electrodomesticos[2] = new Television();
		electrodomesticos[3] = new Lavadora(250., 10.);
		electrodomesticos[4] = new Television(300., 8.);
		electrodomesticos[5] = new Lavadora(200., "BLANCO", 'A', 30., 35.);
		electrodomesticos[6] = new Television(500., "NEGRO", 'B', 30., 75., true);
		electrodomesticos[7] = new Lavadora();
		electrodomesticos[8] = new Lavadora();
		electrodomesticos[9] = new Electrodomestico();
		
		//	• Ahora, recorre este array y ejecuta el método precioFinal().
		//	• Deberás mostrar el precio de cada clase, es decir, el precio de todas 
		//	las televisiones por un lado, el de las lavadoras por otro y la suma de 
		//	los Electrodomesticos (puedes crear objetos Electrodomestico, 
		//	pero recuerda que Television y Lavadora también son
		//	electrodomésticos). Recuerda el uso operador instanceof.
		double sumaTotalElectrodomesticos = 0.;		// 
		double sumaTotalLavadoras = 0.;				// 
		double sumaTotalTelevisiones = 0.;
		for(int i=0; i<electrodomesticos.length; i++) {
			if(electrodomesticos[i] instanceof Electrodomestico) {
				sumaTotalElectrodomesticos += electrodomesticos[i].precioFinal();
			}
			if(electrodomesticos[i] instanceof Lavadora) {
				sumaTotalLavadoras += electrodomesticos[i].precioFinal();
			}
			if(electrodomesticos[i] instanceof Television) {
				sumaTotalTelevisiones += electrodomesticos[i].precioFinal();
			}
		}
		System.out.println("Precio total de los electrodomésticos: " + sumaTotalElectrodomesticos);
		System.out.println("Precio total de las lavadoras: " + sumaTotalLavadoras);
		System.out.println("Precio total de las televisiones: " + sumaTotalTelevisiones);

	}

}
