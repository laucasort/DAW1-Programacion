package ej7;

public class Ejecutable {

	public static void main(String[] args) {
		
		Repartidor r1 = null;
		Repartidor r2 = null;
		do {
			try {
				r1 = new Repartidor("Daniel", 26, 1100, "zona 1");
			} catch (EmpleadoException e) {
				System.out.println(e.getMessage());
			}
		} while(r1==null);
		do {
			try {
				r2 = new Repartidor("Javier", 20, 1100, "zona 3");
			} catch (EmpleadoException e) {
				System.out.println(e.getMessage());
			}
		} while(r2==null);
		
		Comercial c1 = null;
		Comercial c2 = null;
		do {
			try {
				c1 = new Comercial("Fernando", 35, 1200, 300);
			} catch (EmpleadoException e) {
				System.out.println(e.getMessage());
			}
		} while(c1==null);
		do {
			try {
				c2 = new Comercial("Julia", 25, 1200, 300);
			} catch (EmpleadoException e) {
				System.out.println(e.getMessage());
			}
		} while(c2==null);
		
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
	}

}
