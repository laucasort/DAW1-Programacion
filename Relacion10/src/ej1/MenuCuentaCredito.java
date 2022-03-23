package ej1;

import java.util.Scanner;

public class MenuCuentaCredito {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		CuentaCredito cc = null;
		do {
			try {
				System.out.println("Introduce el saldo inicial de la cuenta:");
				double saldo = leerDouble();
				System.out.println("Introduce el nombre del titular de la cuenta:");
				String titular = sc.nextLine();
				System.out.println("Introduce el crédito de la cuenta:");
				double credito = leerDouble();
				cc = new CuentaCredito(saldo, titular, credito);
			} catch(CuentaException e) {
				System.out.println("La cuenta no ha podido ser creada.");
				System.out.println(e.getMessage());
			}
		} while(cc == null);
		
		int op = 0;
		do {
			mostrarMenu();
			op = seleccionarOpcion();
			procesarOpcionSeleccionada(op, cc);
		} while(op!=4);
		
	}

	private static void procesarOpcionSeleccionada(int op, CuentaCredito cc) {
		switch(op) {
		case 1:
			System.out.println("Introduce la cantdad que desea ingresar:");
			double cantidadIngreso = leerDouble();
			try {
				cc.realizarIngreso(cantidadIngreso);
			} catch(CuentaException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			System.out.println("Introduce la cantdad que desea retirar:");
			double cantidadRetirar = leerDouble();
			try {
				cc.realizarReintegro(cantidadRetirar);
			} catch(CuentaException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			System.out.println(cc.toString());
			break;
		case 4:
			System.out.println("Saliendo...");
			break;
		}
	}

	private static double leerDouble() {
		return Double.parseDouble(sc.nextLine());
	}

	private static int seleccionarOpcion() {
		System.out.println("Introduce la opción que quiere realizar:");
		int op = Integer.parseInt(sc.nextLine());
		
		if(op<1 || op>4) {
			System.out.println("Introduce una opción válida.");
			op = seleccionarOpcion();
		}
		
		return op;
	}

	private static void mostrarMenu() {
		System.out.println("--- MENÚ ---\n"
				+ "1. Ingresar dinero\n"
				+ "2. Sacar dinero\n"
				+ "3. Mostrar saldo y crédito\n"
				+ "4. Salir\n");
	}

}
