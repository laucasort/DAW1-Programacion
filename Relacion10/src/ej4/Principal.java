package ej4;

public class Principal {

	public static void main(String[] args) {
		
		Mago a = null;
		Mago b = null;
		Clerigo c = null;
		try {
			a = new Mago("Mago A", TRaza.HUMANO, 15, 20, 100);
			b = new Mago("Mago B", TRaza.HUMANO, 15, 20, 100);
			c = new Clerigo("Clerigo c", TRaza.ELFO, 20, 15, 100, "Freya");
			
			a.aprendeHechizo("Enchantix");
			a.aprendeHechizo("Alohomora");
			b.aprendeHechizo("Lumos");
			
			System.out.println(a.toString());
			System.out.println(b.toString());
			
			a.lanzaHechizo("Enchantix", b);
			b.lanzaHechizo("Lumos", a);
			
			c.curar(b);
			
			a.lanzaHechizo("Alohomora", b);
			
			System.out.println(a.toString());
			System.out.println(b.toString());
			System.out.println(c.toString());
		} catch (PersonajeException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
