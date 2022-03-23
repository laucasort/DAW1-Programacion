package ej5;


public class ListaPersonajes {
	
	private Personaje listaPersonajes[];
	private int cantidadPersonajes;
	
	/**
	 * Se encarga de inicializar el array con la cantidad del array que se le pasa por parametro
	 * @param capacidad Entero de la capacidad de espacio en el array, es
	 * decir, el número máximo de personajes que se pueden almacenar
	 * @throws PersonajeException Al comprobar que la cantidad del espacio del array no es negativo
	 */
	public ListaPersonajes(int capacidad) throws PersonajeException {
		
		if (capacidad<=0){
			
			throw new PersonajeException("ERROR. La cantidad de la lista tiene que ser mayor que 0");
		}
		
		listaPersonajes=new Personaje[capacidad];
		cantidadPersonajes=0;
	}
	
	/**
	 * Se encarga de annadir en el array el personaje pasado por parametro
	 * @param personajeAnnadir Objeto personaje que se va annadir
	 * @throws PersonajeException Al comprobar que el personaje ya existe y tambien si no hay mas espacio en el array
	 */
	public void annadirPersonaje (Personaje personajeAnnadir) throws PersonajeException{
		
		
		
		
		
	}

	/**
	 * Se encarga de añadir el hechizo al objeto personaje
	 * @param nombreMago String nombre del mago que aprende el hechizo
	 * @param nombreHechizo String nombre del hechizo que va a aprender el mago
	 * @throws PersonajeException En el metodo comprobarPersonajeExiste, cuando se comprueba que si el objeto
	 * de array es un mago
	 */
	public void aprenderHechizoMago(String nombreMago, String nombreHechizo) throws PersonajeException{
		
		
	}

	/**
	 * Se encarga de buscar el nombre del mago, su hechizo y nombre del personaje
	 * @param nombreMagoAtaca String nombre del mago que ataca
	 * @param nombrePersonajeDefiende String nombre del personaje que es atacado
	 * @param nombreHechizo String del hechizo del mago que ataca
	 * @throws PersonajeException Se utiliza en el metodo comprobarPersonajeExiste, si nombreMagoAtaca
	 * es un mago y que si nombreMagoAtaca esta en la misma posicion nombrePersonajeDefiende no se ataca
	 * asi mismo comprobando la posicion en el array
	 * @throws MuerteException 
	 */
	public void lanzarHechizoPersonaje (String nombreMagoAtaca,
			String nombrePersonajeDefiende, String nombreHechizo) 
					throws PersonajeException{
		
		
		
	}
	
	/**
	 * Se encarga de buscar un clerigo y buscar un personaje, y el clerigo cura al personaje.
	 * @param nombreClerigo String que contiene el nombre del clerigo que va a curar
	 * @param nombrePersonaje String que contiene el nombre del personaje que se va a curar
	 * @throws PersonajeException En el metodo comprobarPersonajeExiste, si es un clerigo en la posClerigo del array y
	 * si la posClerigo y posPersonaje no son iguales para comprobar que no se cura asi mismo
	 * 
	 */
	public void curarPersonaje (String nombreClerigo, String nombrePersonaje) throws PersonajeException{
		
		
		
		
	
	}
	
	/**
	 * Almacena en un String todos los personajes almacenados en el array
	 * @return String de todos los personajes creados
	 */
	public String toString (){
		
		int i;
	
		StringBuilder sb=new StringBuilder();
		
		for (i=0; i< cantidadPersonajes; i++){
			
			sb.append((i+1) + ". " + listaPersonajes[i] + "\n");
			
		}
		
		return sb.toString();
	}
	
	/**
	 * Ordena el array de personajes por el numero de vida actual
	 *  de mayor a menor y luego lo muesta en forma de String
	 * @return String del array ya ordenado
	 */
	public String mostrarListadoPuntosActuales (){
		
		// TODO
		return "";
	}
	
	

	
	
	
	/**
	 * Busca un personaje por su nombre en el array
	 * @param nombre String nombre del personaje a buscar
	 * @return null si no encuentra el personaje, y el personaje encontrado si se encuentra
	 *
	 */
	private Personaje encontrarPersonaje(String nombre)  {
		
		// TODO
		Personaje p = null;
		return p;
	}

	

	
	
}
