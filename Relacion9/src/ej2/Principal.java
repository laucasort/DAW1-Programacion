package ej2;

public class Principal {

	public static void main(String[] args) {

		CentralElectrica ce = new CentralElectrica();

		System.out.println("--- CENTRAL EL�CTRICA ---");
		System.out.println(ce.toString());

		System.out.println();

		System.out.println("--- POTENCIA MEDIA CONSUMIDA ---");
		ce.potenciaMediaConsumida();

		System.out.println();

		System.out.println("--- POTENCIA MEDIA CONSUMIDA DE ENERG�A E�LICA ---");
		ce.potenciaMediaPorTipoDeEnergia("eolica");
		
		System.out.println();

		System.out.println("--- SEMANA DE MAYOR CONSUMO DE ENERG�A E�LICA ---");
		ce.semanaConMayorConsumo("eolica");
		
		System.out.println();

		System.out.println("--- SEMANA DE MAYOR CONSUMO DE ENERG�A SOLAR QUE DE ENERG�A E�LICA ---");
		ce.semanasMasSolarQueEolica();

	}

}
