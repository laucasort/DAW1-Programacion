package ej8;

public class Serie implements Entregable {
	// � Sus atributos son titulo, numero de temporadas, entregado, genero y creador.
	private String titulo;
	private int numeroTemporadas;
	private boolean entregado;
	private String genero;
	private String creador;
	
	// � Por defecto, el n�mero de temporadas es de 3 temporadas y entregado false. El
	// resto de atributos ser�n valores por defecto seg�n el tipo del atributo.
	private final static int DEFAULT_TEMPORADAS = 3;
	
	// � Los constructores que se implementar�n ser�n:
	//	o Un constructor con todos los atributos, excepto de entregado.
	public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
		super();
		this.titulo = titulo;
		this.numeroTemporadas = numeroTemporadas;
		this.entregado = false;
		this.genero = genero;
		this.creador = creador;
	}
//	o Un constructor con el t�tulo y creador. El resto por defecto.
	public Serie(String titulo, String creador) {
		this(titulo, DEFAULT_TEMPORADAS, "", creador);
	}
	//	o Un constructor por defecto.
	public Serie() {
		this("", DEFAULT_TEMPORADAS, "", "");
	}
	
	// � Los m�todos que se implementar�n ser�n:
	//	o M�todos get de todos los atributos, excepto de entregado.
	//	o M�todos set de todos los atributos, excepto de entregado.
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
	//	o Sobrescribe los m�todos toString.
	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", numeroTemporadas=" + numeroTemporadas + ", entregado=" + entregado
				+ ", genero=" + genero + ", creador=" + creador + "]";
	}
	
	// M�TODO INTERFAZ ENTREGABLE
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
