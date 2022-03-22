package ej5_ej6;

public class Campana extends Instrumento {
	
	public Campana() {
		super();
	}

	@Override
	public void interpretar() {
		System.out.println("Interpretando en Campana...");
		for(int i=0; i<this.ocupado; i++) {
			switch(notas[i]) {
			case DO:
				System.out.println("Do de campana.");
				break;
			case RE:
				System.out.println("Re de campana.");
				break;
			case MI:
				System.out.println("Mi de campana.");
				break;
			case FA:
				System.out.println("Fa de campana.");
				break;
			case SOL:
				System.out.println("Sol de campana.");
				break;
			case LA:
				System.out.println("La de campana.");
				break;
			case SI:
				System.out.println("Si de campana.");
				break;
			}
		}
	}

}
