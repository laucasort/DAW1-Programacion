package ej1;

import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {

		// matrizNotas[filas][columnas]
		int[][] matrizNotas = new int[30][5];

		// Rellenamos matriz con notas generadas aleatoriamente.
		for(int i=0; i<matrizNotas.length; i++) {
			for(int j=0; j<matrizNotas[i].length; j++) {
				matrizNotas[i][j] = (int) (Math.random()*10) + 1;
			}
		}

		System.out.println("--- MATRIZ DE NOTAS ---");
		imprimirMatriz(matrizNotas);

		System.out.println();

		System.out.println("--- SUSPENSOS POR ALUMNO ---");
		muestraSuspensosPorAlumno(matrizNotas);

		System.out.println();

		System.out.println("--- NOTA MEDIA DE LAS ASIGNATURAS ---");
		notaMediaAsignatura(matrizNotas, "programacion");
		notaMediaAsignatura(matrizNotas, "BBDD");
		notaMediaAsignatura(matrizNotas, "SI");
		notaMediaAsignatura(matrizNotas, "LMYSG");
		notaMediaAsignatura(matrizNotas, "ED");

		System.out.println();

		System.out.println("--- ALUMNOS CON 5 ASIGNATURAS SUSPENSAS ---");
		numeroAlumnosConCincoAsignaturasSuspensas(matrizNotas);
		
		System.out.println();

		System.out.println("--- MEJOT ASIGNATURA ALUMNO 0 ---");
		mejorAsignaturaAlumno(matrizNotas, 0);

	}

	/**
	 * Método que imprime la matriz de notas. Una fila por alumno con sus cinco notas correspondientes.
	 * @param matrizNotas
	 */
	private static void imprimirMatriz(int[][] matrizNotas) {
		for(int[] alumno:matrizNotas) {
			System.out.println(Arrays.toString(alumno));
		}
	}

	/**
	 * Muestra el número de asignaturas suspensas por alumno.
	 * @param matrizNotas
	 */
	static void muestraSuspensosPorAlumno(int[][] matrizNotas) {
		for(int i=0; i<matrizNotas.length; i++) {
			int suspensos = contarSuspensosAlumno(matrizNotas, i);
			System.out.println("Alumno " + i + ": " + suspensos + " suspenso(s).");
		}
	}

	/**
	 * Muestra la nota media por asignatura.
	 * @param matrizNotas
	 * @param asignatura
	 */
	static void notaMediaAsignatura(int[][] matrizNotas, String asignatura) {
		switch(Asignaturas.valueOf(asignatura.toUpperCase())) {
		case PROGRAMACION:
			System.out.println("La nota media de " + asignatura.toUpperCase() + " es " + String.format("%.2f", calcularNotaMedia(matrizNotas, 0)) + ".");			
			break;
		case BBDD:
			System.out.println("La nota media de " + asignatura.toUpperCase() + " es " + String.format("%.2f", calcularNotaMedia(matrizNotas, 1)) + ".");
			break;
		case SI:
			System.out.println("La nota media de " + asignatura.toUpperCase() + " es " + String.format("%.2f", calcularNotaMedia(matrizNotas, 2)) + ".");
			break;
		case LMYSG:
			System.out.println("La nota media de " + asignatura.toUpperCase() + " es " + String.format("%.2f", calcularNotaMedia(matrizNotas, 3)) + ".");
			break;
		case ED:
			System.out.println("La nota media de " + asignatura.toUpperCase() + " es " + String.format("%.2f", calcularNotaMedia(matrizNotas, 4)) + ".");
			break;
		default:
			System.out.println("La asignatura introducida no existe.");
			break;
		}
	}

	/**
	 * Método que calcula la nota media de una asignatura.
	 * @param matrizNotas
	 * @param i
	 * @return double
	 */
	static double calcularNotaMedia(int[][] matrizNotas, int i) {
		double res = 0.;
		for(int a=0; a<matrizNotas.length; a++) {
			res += matrizNotas[a][i];
		}
		return res/matrizNotas.length;
	}

	/**
	 * Método que muestra los alumnos con cinco asignaturas suspensas.
	 * @param matrizNotas
	 */
	static void numeroAlumnosConCincoAsignaturasSuspensas(int[][] matrizNotas) {
		for(int i=0; i<matrizNotas.length; i++) {
			int suspensos = contarSuspensosAlumno(matrizNotas, i);
			if(suspensos>=5) {
				System.out.println("Alumno " + i + ".");
			}
		}
	}

	/**
	 * Método que calcula el número de suspensos de un alumno.
	 * @param matrizNotas
	 * @param alumno
	 * @return
	 */
	static int contarSuspensosAlumno(int[][] matrizNotas, int alumno) {
		int suspensos = 0;
		for(int i=0; i<matrizNotas[alumno].length; i++) {
			if(matrizNotas[alumno][i]<5) {
				suspensos++;
			}
		}
		return suspensos;
	}

	/**
	 * Método que devuelve la mejor asignatura de un alumno.
	 * @param matrizNotas
	 * @param alumno
	 */
	static void mejorAsignaturaAlumno(int[][] matrizNotas, int alumno) {
		int res = matrizNotas[alumno][0];
		String asignatura = Asignaturas.PROGRAMACION.toString();
		for(int i=0; i<matrizNotas[alumno].length; i++) {
			if(matrizNotas[alumno][i]>res) {
				res = matrizNotas[alumno][i];
				asignatura = Asignaturas.values()[i].toString();
			}
		}
		System.out.println("Alumno " + alumno + ": La mejor nota es " + res + " en " + asignatura + ".");
	}

}
