package ej2;

import java.util.Arrays;

public class CentralElectrica {

	// ATRIBUTOS
	private double[][] energias = new double[52][3];
	
	// CONSTRUCTORES
	public CentralElectrica() {
		for(int i=0; i<this.energias.length; i++) {
			for(int j=0; j<this.energias[i].length; j++) {
				this.energias[i][j] = (Math.random()*100.) + 1.;;
			}
		}
	}
	
	// MÉTODOS
	/**
	 * Método que calcula la potencia media consumida.
	 */
	public void potenciaMediaConsumida() {
		for(int i=0; i<this.energias.length; i++) {
			double media = 0;
			for(int j=0; j<this.energias[i].length; j++) {
				media += this.energias[i][j];
			}
			media = media/this.energias[i].length;
			System.out.println("Semana " + (i+1) + ": " + String.format("%.2f", media) + ".");
		}
	}
	/**
	 * Método que muestra la potencia media de un tipo de energía.
	 * @param tipoEnergia
	 */
	public void potenciaMediaPorTipoDeEnergia(String tipoEnergia) {
		switch(Energias.valueOf(tipoEnergia.toUpperCase())) {
		case EOLICA:
			System.out.println("La energía " + Energias.EOLICA.toString() + " consimida es " + String.format("%.2f", calcularMediaEnergia(0)) + ".");
			break;
		case SOLAR:
			System.out.println("La energía " + Energias.EOLICA.toString() + " consimida es " + String.format("%.2f", calcularMediaEnergia(1)) + ".");
			break;
		case NUCLEAR:
			System.out.println("La energía " + Energias.EOLICA.toString() + " consimida es " + String.format("%.2f", calcularMediaEnergia(2)) + ".");
			break;
		}
	}
	/**
	 * Método que calcula la media del consumo de un tipo de energía.
	 * @param i
	 * @return double
	 */
	private double calcularMediaEnergia(int i) {
		double media = 0.;
		for(int e=0; e<this.energias.length; e++) {
			media += this.energias[e][i];
		}
		
		return media/this.energias.length;
	}
	/**
	 * Método que muestra la semana de mayor consumo de un tipo de energía.
	 * @param tipoEnergia
	 */
	public void semanaConMayorConsumo(String tipoEnergia) {
		switch(Energias.valueOf(tipoEnergia.toUpperCase())) {
		case EOLICA:
			System.out.println("La semana de energía " + Energias.EOLICA.toString() + " con mayor consumo es la semana " + (calcularConsumoTotalEnergia(0)+1) + ".");
			break;
		case SOLAR:
			System.out.println("La semana de energía " + Energias.EOLICA.toString() + " con mayor consumo es la semana " + (calcularConsumoTotalEnergia(1)+1) + ".");
			break;
		case NUCLEAR:
			System.out.println("La semana de energía " + Energias.EOLICA.toString() + " con mayor consumo es la semana " + (calcularConsumoTotalEnergia(2)+1) + ".");
			break;
		}
	}
	/**
	 * Método que calcula el total de consumo de un tipo de energía.
	 * @param i
	 * @return
	 */
	private int calcularConsumoTotalEnergia(int i) {
		int semana = 0;
		for(int e=0; e<this.energias.length; e++) {
			if(this.energias[e][i] > this.energias[semana][i]) {
				semana = e;
			}
		}
		
		return semana;
	}
	/**
	 * Método que muestra las semanas en las que se consume más energía solar que eólica.
	 */
	public void semanasMasSolarQueEolica() {
		for(int i=0; i<this.energias.length; i++) {
			if(this.energias[i][0] > this.energias[i][1]) {
				System.out.println("Semana " + (i+1) + ".");
			}
		}
	}
	
	// TOSTRING
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for(double[] semana:this.energias) {
			sb.append("Semana " + i + "= " + Arrays.toString(semana) + "\n");
			i++;
		}
		return "CentralElectrica [energias=\n" + sb + "]";
	}
	
}
