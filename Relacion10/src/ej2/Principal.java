package ej2;

import java.util.Scanner;

public class Principal {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		Operario o = null;
		Informatico i = null;
		Directivo d = null;
		do {
			try {
				o = crearOperario();
				i = crearInformatico();
				d = crearDirectivo();
				System.out.println(o.toString());
				System.out.println(i.toString());
				System.out.println(d.toString());
			} catch(EmpleadoException e) {
				System.out.println(e.getMessage());
			}
		} while(o==null || i==null || d==null);
		
	}

	private static Directivo crearDirectivo() throws EmpleadoException {
		System.out.println("Introduce el DNI del directivo:");
		String dni = sc.nextLine();
		System.out.println("Introduce el nombre del directivo:");
		String nombre = sc.nextLine();
		System.out.println("Introduce el sueldo del directivo:");
		int sueldo = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce el departamento del directivo:");
		String departamento = sc.nextLine();
		
		return new Directivo(dni, nombre, sueldo, departamento);
	}

	private static Informatico crearInformatico() throws EmpleadoException {
		System.out.println("Introduce el DNI del informatico:");
		String dni = sc.nextLine();
		System.out.println("Introduce el nombre del informatico:");
		String nombre = sc.nextLine();
		System.out.println("Introduce el sueldo del informatico:");
		int sueldo = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce la especialidad del informatico (1-DESARROLLO, 2-SISTEMAS, 3-BD):");
		int selec = Integer.parseInt(sc.nextLine());
		Especialidad especialidad = Especialidad.DESARROLLO;
		switch(selec) {
		case 1:
			break;
		case 2:
			especialidad = Especialidad.SISTEMAS;
			break;
		case 3:
			especialidad = Especialidad.BD;
			break;
		default:
			System.out.println("La opcioón seleccionada no existe. Prueba de nuevo.");
			crearInformatico();
			break;
		}
		
		return new Informatico(dni, nombre, sueldo, especialidad);
	}

	private static Operario crearOperario() throws EmpleadoException {
		System.out.println("Introduce el DNI del operario:");
		String dni = sc.nextLine();
		System.out.println("Introduce el nombre del operario:");
		String nombre = sc.nextLine();
		System.out.println("Introduce el sueldo del operario:");
		int sueldo = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce la nave del operario:");
		int nave = Integer.parseInt(sc.nextLine());
		
		return new Operario(dni, nombre, sueldo, nave);
	}

}
