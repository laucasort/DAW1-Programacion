package ej1;

public class Cuenta {

	// ATRIBUTOS
	protected double saldo;
	protected String titular;
	protected int contadorIngresos;
	protected int contadorReintegros;

	// CONSTRUCTORES
	public Cuenta(String titular) {
		saldo = 0;
		contadorIngresos = 0;
		contadorReintegros = 0;
		this.titular=titular;
	}
	public Cuenta(double saldo, String titular) throws CuentaException {
		if (saldo < 0) {			
			throw new CuentaException("No se puede crear una cuenta con saldo negativo.");
		} 
		this.saldo = saldo;
		contadorIngresos = 0;
		contadorReintegros = 0;
		this.titular=titular;
	}
	
	

	// GETTERS & SETTERS
	public String getTitular() {
		return titular;
	}
	public double getSaldo() {
		return this.saldo;
	}
	public int getContadorIngresos() {
		return this.contadorIngresos;
	}
	public int getContadorReintegros() {
		return this.contadorReintegros;
	}

	// MÉTODOS
	/**
	 * Método que realiza un reintegro en la cuenta.
	 * @param reintegro
	 * @throws CuentaException 
	 */
	public void realizarReintegro(double reintegro) throws CuentaException {
		if (reintegro <= 0){
			throw new CuentaException("El reintegro solo puede realizarse con cantidades positivas.");
		}
		if (reintegro > this.saldo) {
			throw new CuentaException("No tienes suficiente saldo.");
		} 
			
		this.saldo = this.saldo - reintegro;
		this.contadorReintegros++;
	}

	/**
	 * Método que realiza un ingreso en la cuenta
	 * @param ingreso
	 * @throws CuentaException 
	 */
	public void realizarIngreso(double ingreso) throws CuentaException {
		if (ingreso <= 0){
			throw new CuentaException("El ingreso solo puede realizarse con cantidades positivas."); 
		}
		this.saldo = this.saldo + ingreso;
		this.contadorIngresos++;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Cuenta [Saldo=" + saldo +  ", Titular=" + titular + "]";
	}
}