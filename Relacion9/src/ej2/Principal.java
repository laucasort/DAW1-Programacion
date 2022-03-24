package ej2;

public class Principal {

	public static void main(String[] args) {

		CentralElectrica ce = new CentralElectrica();

		System.out.println("--- CENTRAL ELÉCTRICA ---");
		System.out.println(ce.toString());

		System.out.println();

		System.out.println("--- POTENCIA MEDIA CONSUMIDA ---");
		ce.potenciaMediaConsumida();

		System.out.println();

		System.out.println("--- POTENCIA MEDIA CONSUMIDA DE ENERGÍA EÓLICA ---");
		ce.potenciaMediaPorTipoDeEnergia("eolica");
		
		System.out.println();

		System.out.println("--- SEMANA DE MAYOR CONSUMO DE ENERGÍA EÓLICA ---");
		ce.semanaConMayorConsumo("eolica");
		
		System.out.println();

		System.out.println("--- SEMANA DE MAYOR CONSUMO DE ENERGÍA SOLAR QUE DE ENERGÍA EÓLICA ---");
		ce.semanasMasSolarQueEolica();

	}

}
