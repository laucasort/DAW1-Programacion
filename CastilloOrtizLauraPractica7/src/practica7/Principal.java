package practica7;

import java.util.Arrays;
import java.util.Scanner;

import practica7.exceptions.AeropuertoException;
import practica7.exceptions.CompanyException;
import practica7.exceptions.VueloException;

public class Principal {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws AeropuertoException, CompanyException, VueloException {

		// INTRODUCCI�N DE DATOS
		//	- Creamos un listado de cuatro aeropuertos, dos privados y dos p�blicos:
		Aeropuerto[] aeropuertosGestionados = new Aeropuerto[4];
		AeropuertoPrivado ap1 = null;
		AeropuertoPrivado ap2 = null;
		AeropuertoPublico apub1 = null;
		AeropuertoPublico apub2 = null;
		try {
			ap1 = new AeropuertoPrivado("Aeropuerto Privado 1", "Sevilla", "Espa�a", 3, 2);
			ap2 = new AeropuertoPrivado("Aeropuerto Privado 2", "M�laga", "Espa�a", 3, 2);
			apub1 = new AeropuertoPublico("Aeropueto P�blico 1", "Barcelona", "Espa�a", 3, 500.);
			apub2 = new AeropuertoPublico("Aeropueto P�blico 2", "Madrid", "Espa�a", 3, 1000.);
		} catch (AeropuertoException e) {
			throw new AeropuertoException(e.getMessage());
		}
		aeropuertosGestionados[0] = ap1;
		aeropuertosGestionados[1] = ap2;
		aeropuertosGestionados[2] = apub1;
		aeropuertosGestionados[3] = apub2;
		//	- Creamos 3 compa��as:
		Company c1 = null;
		Company c2 = null;
		Company c3 = null;
		try {
			c1 = new Company("Compa��a 1", 5);
			c2 = new Company("Compa��a 2", 5);
			c3 = new Company("Compa��a 3", 5);
		} catch (CompanyException e) {
			throw new CompanyException(e.getMessage());
		}
		//	- Creamos 5 vuelos:
		Vuelo v1 = null;
		Vuelo v2 = null;
		Vuelo v3 = null;
		Vuelo v4 = null;
		Vuelo v5 = null;
		try {
			v1 = new Vuelo(1, Ciudades.SEVILLA.toString(), Ciudades.MADRID.toString(), 50., 10);
			v2 = new Vuelo(2, Ciudades.SEVILLA.toString(), Ciudades.BARCELONA.toString(), 80., 10);
			v3 = new Vuelo(3, Ciudades.SEVILLA.toString(), Ciudades.M�LAGA.toString(), 20., 10);
			v4 = new Vuelo(4, Ciudades.M�LAGA.toString(), Ciudades.MADRID.toString(), 60., 10);
			v5 = new Vuelo(5, Ciudades.M�LAGA.toString(), Ciudades.BARCELONA.toString(), 90., 10);
		} catch (VueloException e) {
			throw new VueloException(e.getMessage());
		}
		//	- Creamos 6 pasajeros:
		Pasajero p1 = new Pasajero("Pasajero 1", 1, "Espa�ol");
		Pasajero p2 = new Pasajero("Pasajero 2", 2, "Espa�ol");
		Pasajero p3 = new Pasajero("Pasajero 3", 3, "Espa�ol");
		Pasajero p4 = new Pasajero("Pasajero 4", 4, "Espa�ol");
		Pasajero p5 = new Pasajero("Pasajero 5", 5, "Espa�ol");
		Pasajero p6 = new Pasajero("Pasajero 6", 6, "Espa�ol");
		//	- A�adimos los pasajeros a los vuelos:
		try {
			v1.introducirPasajero(p1);
			v1.introducirPasajero(p2);
			v1.introducirPasajero(p3);

			v2.introducirPasajero(p3);
			v2.introducirPasajero(p4);

			v3.introducirPasajero(p4);
			v3.introducirPasajero(p5);
			v3.introducirPasajero(p6);

			v4.introducirPasajero(p5);
			v4.introducirPasajero(p6);

			v5.introducirPasajero(p1);
			v5.introducirPasajero(p6);
			v5.introducirPasajero(p3);
			v5.introducirPasajero(p4);
		} catch(VueloException e) {
			throw new VueloException(e.getMessage());
		}
		//	- A�adimos los vuelos a las compa��as:
		try {
			c1.introducirVuelo(v1);
			c1.introducirVuelo(v2);
			c1.introducirVuelo(v3);

			c2.introducirVuelo(v3);
			c2.introducirVuelo(v4);
			c2.introducirVuelo(v5);

			c3.introducirVuelo(v1);
			c3.introducirVuelo(v2);
			c3.introducirVuelo(v4);
			c3.introducirVuelo(v5);
		} catch(CompanyException e) {
			throw new CompanyException(e.getMessage());
		}
		//	- A�adimos las compa��as a los aeropuertos:
		try {
			ap1.introducirCompany(c1);
			ap1.introducirCompany(c2);

			ap2.introducirCompany(c2);
			ap2.introducirCompany(c3);

			apub1.introducirCompany(c1);
			apub1.introducirCompany(c2);
			apub1.introducirCompany(c3);

			apub2.introducirCompany(c1);
			apub2.introducirCompany(c3);
		} catch(AeropuertoException e) {
			throw new AeropuertoException(e.getMessage());
		}
		//	- A�adimos las empresas patrocinadoras a los aeropuertos privados:
		ap1.introducirEmpresaPatrocinadora("Empresa patrocinadora 1");
		ap1.introducirEmpresaPatrocinadora("Empresa patrocinadora 2");
		ap2.introducirEmpresaPatrocinadora("Empresa patrocinadora 1");

		int op = 0;
		do {
			mostrarMenu();
			op = leerInt();
			realizarOperacion(op, aeropuertosGestionados);
		} while(op!=6);

	}

	private static void mostrarMenu() {
		System.out.println("--- MEN� ---\n"
				+ "   1. Consultar aeropuertos gestionados.\n"
				+ "   2. Visualizar las empresas que patrocinan o la subvenci�n que recibe un determinado aeropuerto.\n"
				+ "   3. Mostrar la lista de compa��as que vuelan desde un determinado aeropuerto.\n"
				+ "   4. Listar vuelos que ofrece una determinada compa��a de un determinado aeropuerto.\n"
				+ "   5. Mostrar los vuelos que parten de una ciudad origen a otra destino.\n"
				+ "   6. Salir.");
	}

	private static int leerInt() {
		return Integer.parseInt(sc.nextLine());
	}

	private static void realizarOperacion(int op, Aeropuerto[] aeropuertosGestionados) {
		switch(op) {
		case 1:
			// Consultar los aeropuertos gestionados, indicando separadamente los aeropuertos
			// p�blicos y los privados. Para cada uno de ellos deber� mostrar su nombre, la
			// ciudad de ubicaci�n y el pa�s al que pertenece.
			consultarAeropuertosPrivados(aeropuertosGestionados);
			consultarAeropuertosPublicos(aeropuertosGestionados);
			break;
		case 2:
			// Visualizar las empresas que patrocinan un determinado aeropuerto en caso que
			// sea privado, o la cuant�a de la subvenci�n en caso de que se trate de un
			// aeropuerto p�blico.
			int aer = seleccionarAeropuerto(aeropuertosGestionados);
			visualizarEmpresasOSubvencion(aeropuertosGestionados[aer-1]);
			break;
		case 3:
			// Para un determinado aeropuerto, se debe poder mostrar la lista de compa��as que
			// vuelan desde ese aeropuerto.
			int aero = seleccionarAeropuerto(aeropuertosGestionados);
			visualizarListaCompanies(aeropuertosGestionados[aero-1]);
			break;
		case 4:
			// Para una determinada compa��a que opera en un aeropuerto concreto, listar todos
			// los posibles vuelos que dicha compa��a ofrece, mostrando su identificador, la
			// ciudad de origen y destino y el precio del vuelo.
			int aerop = seleccionarAeropuerto(aeropuertosGestionados);
			int company = seleccionarCompany(aeropuertosGestionados[aerop-1]);
			listarPosiblesVuelos(aeropuertosGestionados[aerop-1], aeropuertosGestionados[aerop-1].getCompanies()[company-1]);
			break;
		case 5:
			// Mostrar todos los posibles vuelos (identificador) que parten de una ciudad de
			// origen a otra ciudad destino (indicadas por el usuario) y mostrar su precio.
			String origen = seleccionarCiudad();
			String destino = seleccionarCiudad();
			listarPosiblesVuelos(aeropuertosGestionados, origen, destino);
			break;
		case 6:
			// Finaliza el programa.
			System.out.println("Saliendo...");
			break;
		default:
			// Devuelve un mensaje advirtiendo de que la opci�n seleccionada no existe.
			System.out.println("La opci�n seleccionada no existe.");
			break;
		}
	}

	/**
	 * M�todo que muestra por pantalla los datos de los aeropuertos de tipo privado.
	 * @param aeropuertosGestionados
	 */
	private static void consultarAeropuertosPrivados(Aeropuerto[] aeropuertosGestionados) {
		System.out.println("AEROPUERTOS PRIVADOS ->");
		for(int i=0; i<aeropuertosGestionados.length; i++) {
			if(aeropuertosGestionados[i] instanceof AeropuertoPrivado) {
				System.out.println("� [nombre=" + aeropuertosGestionados[i].nombre 
						+ ", ciudad=" + aeropuertosGestionados[i].getCiudad() + ", pa�s=" + aeropuertosGestionados[i].getCiudad() + "]");
			}
		}
	}

	/**
	 * M�todo que muestra por pantalla los datos de los aeropuertos de tipo p�blico.
	 * @param aeropuertosGestionados
	 */
	private static void consultarAeropuertosPublicos(Aeropuerto[] aeropuertosGestionados) {
		System.out.println("AEROPUERTOS P�BLICOS ->");
		for(int i=0; i<aeropuertosGestionados.length; i++) {
			if(aeropuertosGestionados[i] instanceof AeropuertoPublico) {
				System.out.println("� [nombre=" + aeropuertosGestionados[i].nombre 
						+ ", ciudad=" + aeropuertosGestionados[i].getCiudad() + ", pa�s=" + aeropuertosGestionados[i].getCiudad() + "]");
			}
		}
	}

	/**
	 * M�todo que muestra por pantalla un men� con los aeropuertos existentes y recoge el aeropuerto seleccionado como un
	 * int por el n�mero que lo acompa�a en la lista.
	 * De no seleccionar una opci�n v�lida seguir� preguntado.
	 * @param aeropuertosGestionados
	 * @return
	 */
	private static int seleccionarAeropuerto(Aeropuerto[] aeropuertosGestionados) {
		int aer = 0;

		System.out.println("Introduce el n�mero del aeropuerto que desea seleccionar:");
		for(int i=0; i<aeropuertosGestionados.length; i++) {
			System.out.println((i+1) + ". " + aeropuertosGestionados[i].toString());
		}

		do {
			aer = leerInt();
			if(aer<1 || aer>aeropuertosGestionados.length) {
				System.out.println("Introduce un valor v�lido.");
			}
		} while(aer<1 || aer>aeropuertosGestionados.length);

		return aer;
	}

	/**
	 * M�todo que muestra por pantalla las empresas patrocinadoras de un aeropuerto en el caso de que este sea privado,
	 * o la subvenci�n recibida en caso de que sea p�blico.
	 * @param aeropuerto
	 */
	private static void visualizarEmpresasOSubvencion(Aeropuerto aeropuerto) {
		if(aeropuerto instanceof AeropuertoPrivado) {
			System.out.println("Las empresas patrocinadoras del aeropuerto son: " + Arrays.toString(((AeropuertoPrivado) aeropuerto).getEmpresasPatrocinadoras()));
		} else {
			System.out.println("La subvenci�n del aeropuerto es: " + ((AeropuertoPublico)aeropuerto).getSubvencion());
		}
	}

	/**
	 * M�todo que muestra por pantalla la lista de compa��as que vuelan desde un determinado aeropuerto.
	 * @param aeropuerto
	 */
	private static void visualizarListaCompanies(Aeropuerto aeropuerto) {
		System.out.println("Compa��as que vuelan desde el aeropuerto " + aeropuerto.getNombre() + ": ");
		for(int i=0; i<aeropuerto.getNumeroRealDeCompanies(); i++) {
			System.out.println("- " + aeropuerto.getCompanies()[i]);
		}
	}

	/**
	 * M�todo que muestra por pantalla un men� con las compa��as existentes y recoge la compa��a seleccionado como un
	 * int por el n�mero que lo acompa�a en la lista.
	 * De no seleccionar una opci�n v�lida seguir� preguntado.
	 * @param aeropuerto
	 * @return
	 */
	private static int seleccionarCompany(Aeropuerto aeropuerto) {
		int res = 0;

		System.out.println("Introduce el n�mero de la compa��a que desea seleccionar:");
		for(int i=0; i<aeropuerto.getNumeroRealDeCompanies(); i++) {
			System.out.println((i+1) + ". " + aeropuerto.getCompanies()[i].toString());
		}

		do {
			res = leerInt();
			if(res<1 || res>aeropuerto.getNumeroRealDeCompanies()) {
				System.out.println("Introduce un valor v�lido.");
			}
		} while(res<1 || res>aeropuerto.getNumeroRealDeCompanies());

		return res;
	}
	
	/**
	 * M�todo que muestra por pantalla los posibles vuelos de una compa��a desde una aeropuerto concreto.
	 * @param aeropuerto
	 * @param company
	 */
	private static void listarPosiblesVuelos(Aeropuerto aeropuerto, Company company) {
		System.out.println("Vuelos de la compa��a " + company.getNombre() + ": ");
		aeropuerto.vuelosPorCompanyYAeropuerto(company.getNombre());
	}
	
	/**
	 * M�todo que recoge la ciudad introducidad por pantalla.
	 * De no seleccionar una opci�n v�lida seguir� preguntado.
	 * @return
	 */
	private static String seleccionarCiudad() {
		System.out.println("Introduce el nombre de la ciudad que desea seleccionar " + Arrays.toString(Ciudades.values()) + ": ");
		String res;
		do {
			res = sc.nextLine();
		} while(Ciudades.valueOf(res.toUpperCase())==null);

		return Ciudades.valueOf(res.toUpperCase()).toString();
	}
	
	/**
	 * M�todo que muestra por pantalla los posibles vuelos que hay desde una ciudad a otra (ambas introducidas por pantalla).
	 * Muestra el aeropuesto del que salen y la compa��a que realiza dicho vuelo.
	 * @param aeropuertosGestionados
	 * @param origen
	 * @param destino
	 */
	private static void listarPosiblesVuelos(Aeropuerto[] aeropuertosGestionados, String origen, String destino) {
		System.out.println("Vuelos desde " + origen + " a " + destino + ": ");
		for(int i=0; i<aeropuertosGestionados.length; i++) {
			System.out.println("- Aeropuerto " + aeropuertosGestionados[i].getNombre());
			aeropuertosGestionados[i].vuelosPorOrigenYDestino(origen, destino);
		}
	}

}
