package ej1;

public class CuentaCredito extends Cuenta {

	// ATRIBUTOS
	private double credito;
	
	// CONSTANTES
	private final static double DEFAULT_SALDO_INICIAL = 0.;
	private final static double DEFAULT_CREDITO = 0.;
	
	// CONSTRUCTORES
	public CuentaCredito(String titular) throws CuentaException {
		super(DEFAULT_SALDO_INICIAL, titular);
		setCredito(DEFAULT_CREDITO);
	}
	public CuentaCredito(double saldo, String titular, double credito) throws CuentaException {
		super(saldo, titular);
		this.credito = credito;
	}
	
	// GETTERS & SETTERS
	public double getCredito() {
		return credito;
	}
	public void setCredito(double credito) throws CuentaException {
		if(credito<0 || credito>300) {
			throw new CuentaException("ERROR: El crédito no puede ser negativo o mayor de 300.");
		}
		if(credito>this.saldo) {
			throw new CuentaException("ERROR: El crédito no puede ser mayor que el saldo de la cuenta.");
		}
		this.credito = credito;
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
		if (reintegro > (this.saldo + this.credito)) {
			throw new CuentaException("No tienes suficiente saldo.");
		} 
			
		this.saldo = this.saldo - reintegro;
		this.contadorReintegros++;
	}
	
	// TOSTRNG
	@Override
	public String toString() {
		return "CuentaCredito [credito=" + credito + ", toString()=" + super.toString() + "]";
	}
}
