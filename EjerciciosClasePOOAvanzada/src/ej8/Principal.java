package ej8;

public class Principal {

	public static void main(String[] args) {
		
		Serie[] series = new Serie[5];
		Videojuego[] videojuegos = new Videojuego[5];
		
		series[0] = new Serie();
		series[1] = new Serie("Juego de Tronos", "George Rusell");
		series[2] = new Serie("Los Simpsons", 25, "Humor", "Matt Groning");
		series[3] = new Serie("Padre de Familia", 12, "Humor", "Seth M.");
		series[4] = new Serie("Breaking Bad", 5, "Thriller", "Vince O.");
		
		videojuegos[0] = new Videojuego();
		videojuegos[1] = new Videojuego("Assesin Creed 2", 30, "Aventuras", "EA");
		videojuegos[2] = new Videojuego("God of War 3", 30);
		videojuegos[3] = new Videojuego("Super Mario 3D", 20, "Aventuras", "Nintendo");
		videojuegos[4] = new Videojuego("Final Fantasy", 200, "Rol", "Square");
		
		series[1].entregar();
		series[4].entregar();
		
		videojuegos[0].entregar();
		videojuegos[3].entregar();
		
		int prestados = 0;
		for(Serie s:series) {
			if(s.isEntregado()) {
				prestados++;
				s.devolver();
			}
		}
		for(Videojuego v:videojuegos) {
			if(v.isEntregado()) {
				prestados++;
				v.devolver();
			}
		}
		System.out.println("Hay " + prestados + " artículos prestados.");
		
		Serie serieMayor = series[0];
		Videojuego videojuegoMayor = videojuegos[0];
		for(Serie s:series) {
			if(s.compareTo(serieMayor) == 1) {
				serieMayor = s;
			}
		}
		for(Videojuego v:videojuegos) {
			if(v.compareTo(videojuegoMayor) == 1) {
				videojuegoMayor = v;
			}
		}
		System.out.println("La serie mayor es: " + serieMayor.toString());
		System.out.println("El videojuego mayor es: " + videojuegoMayor.toString());
		
	}

}
