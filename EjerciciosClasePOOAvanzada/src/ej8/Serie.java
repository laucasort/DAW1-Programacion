package ej8;

public class Serie implements Entregable {
	// • Sus atributos son titulo, numero de temporadas, entregado, genero y creador.
	private String titulo;
	private int numeroTemporadas;
	private boolean entregado;
	private String genero;
	private String creador;
	
	// • Por defecto, el número de temporadas es de 3 temporadas y entregado false. El
	// resto de atributos serán valores por defecto según el tipo del atributo.
	private final static int DEFAULT_TEMPORADAS = 3;
	
	// • Los constructores que se implementarán serán:
	//	o Un constructor con todos los atributos, excepto de entregado.
	public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
		super();
		this.titulo = titulo;
		this.numeroTemporadas = numeroTemporadas;
		this.entregado = false;
		this.genero = genero;
		this.creador = creador;
	}
//	o Un constructor con el título y creador. El resto por defecto.
	public Serie(String titulo, String creador) {
		this(titulo, DEFAULT_TEMPORADAS, "", creador);
	}
	//	o Un constructor por defecto.
	public Serie() {
		this("", DEFAULT_TEMPORADAS, "", "");
	}
	
	// • Los métodos que se implementarán serán:
	//	o Métodos get de todos los atributos, excepto de entregado.
	//	o Métodos set de todos los atributos, excepto de entregado.
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getNumeroTemporadas() {
		return numeroTemporadas;
	}
	public void setNumeroTemporadas(int numeroTemporadas) {
		this.numeroTemporadas = numeroTemporadas;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCreador() {
		return creador;
	}
	public void setCreador(String creador) {
		this.creador = creador;
	}	
	//	o Sobrescribe los métodos toString.
	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", numeroTemporadas=" + numeroTemporadas + ", entregado=" + entregado
				+ ", genero=" + genero + ", creador=" + creador + "]";
	}
	
	// MÉTODO INTERFAZ ENTREGABLE
	@Override
	public void entregar() {
		this.entregado = true;
	}
	@Override
	public void devolver() {
		this.entregado = false;
	}
	@Override
	public boolean isEntregado() {
		return this.entregado;
	}
	@Override
	public int compareTo(Object a) {
		int res = -1; // MENOR
		
		Serie s = (Serie) a;
		
		if(this.numeroTemporadas == s.numeroTemporadas) {
			res = 0;
		} else if(this.numeroTemporadas > s.numeroTemporadas) {
			res = 1;
		}

		return res;
	}
}
