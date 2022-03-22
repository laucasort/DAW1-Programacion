package ej5_ej6;

public abstract class Instrumento {
	
	protected NotasMusicales[] notas;
	protected int ocupado;
	
	public Instrumento() {
		this.notas = new NotasMusicales[100];
		this.ocupado = 0;
	}
	
	public void add(NotasMusicales nota) {
		if(ocupado>=100) {
			System.out.println("No se pueden añadir más notas.");
		} else {
			notas[ocupado] = nota;
			ocupado++;
		}
	}
	
	public abstract void interpretar();
	
}
