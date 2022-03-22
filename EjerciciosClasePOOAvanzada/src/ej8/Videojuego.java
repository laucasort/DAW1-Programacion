package ej8;

public class Videojuego implements Entregable {
	// � Sus atributos son titulo, horas estimadas, entregado, genero y compa�ia.
	private String titulo;
	private int horasEstimadas;
	private boolean entregado;
	private String genero;
	private String company;
	
	// � Por defecto, las horas estimadas ser�n de 10 horas y entregado false. El resto de
	// atributos ser�n valores por defecto seg�n el tipo del atributo.
	private final static int DEFAULT_HORAS = 10;
	
	// � Los constructores que se implementar�n ser�n:
	//	o Un constructor con todos los atributos, excepto de entregado.
	public Videojuego(String titulo, int horasEstimadas, String genero, String company) {
		super();
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.entregado = false;
		this.genero = genero;
		this.company = company;
	}
	//	o Un constructor con el titulo y horas estimadas. El resto por defecto.
	public Videojuego(String titulo, int horasEstimadas) {
		this(titulo, horasEstimadas, "", "");
	}
	//	o Un constructor por defecto.
	public Videojuego() {
		this("", DEFAULT_HORAS, "", "");
	}
	
	// � Los m�todos que se implementara ser�n:
	//	o M�todos get de todos los atributos, excepto de entregado.
	//	o M�todos set de todos los atributos, excepto de entregado.
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getHorasEstimadas() {
		return horasEstimadas;
	}
	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	//	o Sobrescribe los m�todos toString.
	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", horasEstimadas=" + horasEstimadas + ", entregado=" + entregado
				+ ", genero=" + genero + ", company=" + company + "]";
	}
	
	// M�TODOS INTERFAZ ENTREGABLE
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
		int res = -1;
		
		Videojuego v = (Videojuego) a;
		
		if(this.horasEstimadas == v.horasEstimadas) {
			res = 0;
		} else if(this.horasEstimadas > v.horasEstimadas) {
			res = 1;
		}
		
		return res;
	}
}
