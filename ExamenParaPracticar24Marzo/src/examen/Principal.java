package examen;

import java.util.Scanner;

public class Principal {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws EmpresaException {

		Empleado[] empleados = new Empleado[5];

		JefeDepartamento jefe1 = null;
		JefeDepartamento jefe2 = null;
		EmpleadoBase empleado1 = null;
		EmpleadoBase empleado2 = null;
		EmpleadoBase empleado3 = null;
		try {
			jefe1 = new JefeDepartamento("12345678A", "Jefe 1", 2500, "Departamento 1");
			jefe2 = new JefeDepartamento("12345678B", "Jefe 2", 2500, "Departamento 2");
			empleado1 = new EmpleadoBase("12345678C", "Empleado 1", 1100, TPuesto.OPERARIO);
			empleado2 = new EmpleadoBase("12345678D", "Empleado 2", 1150, TPuesto.ADMINISTRATIVO);
			empleado3 = new EmpleadoBase("12345678E", "Empleado 3", 1350, TPuesto.CONTABLE);

			empleados[0] = jefe1;
			empleados[1] = jefe2;
			empleados[2] = empleado1;
			empleados[3] = empleado2;
			empleados[4] = empleado3;

			jefe1.addSubordinate(empleado1);
			jefe1.addSubordinate(empleado2);
			jefe2.addSubordinate(empleado3);

		} catch (EmpresaException e) {
			throw new EmpresaException(e.getMessage());
		}

		try {
			System.out.println("Introduce un puesto: ");
			String puesto = sc.nextLine();
			mostrarEmpleadosPuesto(empleados, puesto);
		} catch(IllegalArgumentException e) {
			throw new EmpresaException("El puesto introducido no existe.");
		}

	}

	private static void mostrarEmpleadosPuesto(Empleado[] empleados, String puesto) throws IllegalArgumentException {
		TPuesto p = TPuesto.valueOf(puesto.toUpperCase());
		for(Empleado e:empleados) {
			if(e instanceof EmpleadoBase && ((EmpleadoBase) e).getPuesto().equals(p)) {
				System.out.println(e.toString());
			}
		}
	}

}
