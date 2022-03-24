package examen;

import java.util.Arrays;

public class JefeDepartamento extends Empleado implements ActualizableSueldo {

	// CONSTANTES
	private final static int MAX_EMPLEADOS_SUBORDINADOS = 12;
	public final static double INCREMENTO_ANUAL_3SUB = 103.;
	public final static double INCREMENTO_ANUAL_4TO8SUB = 104.;
	public final static double INCREMENTO_ANUAL_MAS8SUB = 106.;
	
	// ATRIBUTOS
	private String departamento;
	private Empleado[] empleadosSubordinados;
	private int numeroSubordinados;
	
	// CONSTRUCTORES
	public JefeDepartamento(String dni, String nombre, double sueldo, String departamento) throws EmpresaException {
		super(dni, nombre, sueldo);
		this.departamento = departamento;
		this.empleadosSubordinados= new Empleado[MAX_EMPLEADOS_SUBORDINADOS];
		this.numeroSubordinados = 0;
	}
	
	// MÉTODOS
	public void addSubordinate(Empleado e) throws EmpresaException {
		if(this.numeroSubordinados>=this.empleadosSubordinados.length) {
			throw new EmpresaException("Este jefe de departamento no puede tener más subordinados.");
		}
		if(e.getSueldo()>=this.getSueldo()) {
			throw new EmpresaException("El sueldo del subordinado tiene que ser menor que el del jefe de departamento.");
		}
		boolean existe = false;
		int posicion = 0;
		for(int i=0; i<empleadosSubordinados.length; i++) {
			if(empleadosSubordinados[i]==null) {
				posicion = i;
			} else if(empleadosSubordinados[i].getDni().equals(e.getDni())) {
				existe = true;
			}
		}
		if(!existe) {
			empleadosSubordinados[posicion] = e;
			this.numeroSubordinados++;
		} else {
			throw new EmpresaException("Este jefe de departamento ya tiene asignado este subordinado.");
		}
	}
	
	public void actualizarSueldo() throws EmpresaException {
		if(this.numeroSubordinados <= 3) {
			this.setSueldo(this.getSueldo()*INCREMENTO_ANUAL_3SUB);
		} else if(this.numeroSubordinados>=4 && this.numeroSubordinados<=8) {
			this.setSueldo(this.getSueldo()*INCREMENTO_ANUAL_4TO8SUB);
		} else {
			this.setSueldo(this.getSueldo()*INCREMENTO_ANUAL_MAS8SUB);
		}
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "JefeDepartamento [departamento=" + departamento + ", empleadosSubordinados="
				+ Arrays.toString(empleadosSubordinados) + ", numeroSubordinados=" + numeroSubordinados
				+ ", toString()=" + super.toString() + "]";
	}
	
}
