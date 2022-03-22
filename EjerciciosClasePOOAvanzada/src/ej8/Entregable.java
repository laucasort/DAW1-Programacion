package ej8;

public interface Entregable {

	// • entregar(): cambia el atributo entregado a true.
	public void entregar();
	// • devolver(): cambia el atributo entregado a false.
	public void devolver();
	// • isEntregado(): devuelve el estado del atributo entregado.
	public boolean isEntregado();
	// • Método compareTo (Object a), compara las horas estimadas en los videojuegos y
	// en las series el numero de temporadas. Recuerda el uso de los casting de objetos.
	public int compareTo(Object a);
	
}
