package ej9_ej10;

import java.time.LocalDate;
import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		
		Publicacion[] publicaciones = new Publicacion[4];
		
		publicaciones[0] = new Libro("SPY X FAMILY Vol.3", "Tatsuya Endo", LocalDate.of(2020, 11, 1));
		publicaciones[1] = new Libro("Haikyu!! Vol.1", "Haruichi Furudate", LocalDate.of(2012, 6, 4));
		
		Revista r1 = null;
		Revista r2 = null;
		do {
			try {
				r1 = new Revista("Vogue", "Arthur Baldwin", LocalDate.of(1892, 12, 17), 1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while(r1==null);
		do {
			try {
				r2 = new Revista("Cosmopolitan", "Schlicht & Field", LocalDate.of(1886 , 3, 1),1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while(r2==null);
		publicaciones[2] = r1;
		publicaciones[3] = r2;
		
		Libro libroPrestado = (Libro) publicaciones[0];
		libroPrestado.prestar();
		publicaciones[0] = libroPrestado;
		
		System.out.println(Arrays.toString(publicaciones));
		System.out.println("Hay " + cuentaPrestados(publicaciones) + " libros prestados.");
		System.out.println("Hay " + publicacionesAnterioresA(publicaciones) + " publicaciones anteriores a 1990.");
	}
	
	static int cuentaPrestados(Publicacion[] publicaciones) {
		int res = 0;
		for(Publicacion p:publicaciones) {
			if(p instanceof Libro) {
				Libro libro = (Libro) p;
				if(libro.prestado()) {
					res++;
				}
			}
		}
		
		return res;
	}
	
	static int publicacionesAnterioresA(Publicacion[] publicaciones) {
		int res = 0;
		for(Publicacion p:publicaciones) {
			if(p.releaseYear() < 1990) {
				res++;
			}
		}
		
		return res;
	}

}
