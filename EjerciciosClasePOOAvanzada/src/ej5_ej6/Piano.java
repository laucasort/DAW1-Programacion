package ej5_ej6;

public class Piano extends Instrumento {
	
	public Piano() {
		super();
	}

	@Override
	public void interpretar() {
		System.out.println("Interpretando en Piano...");
		for(int i=0; i<this.ocupado; i++) {
			switch(notas[i]) {
			case DO:
				System.out.println("Do de piano.");
				break;
			case RE:
				System.out.println("Re de piano.");
				break;
			case MI:
				System.out.println("Mi de piano.");
				break;
			case FA:
				System.out.println("Fa de piano.");
				break;
			case SOL:
				System.out.println("Sol de piano.");
				break;
			case LA:
				System.out.println("La de piano.");
				break;
			case SI:
				System.out.println("Si de piano.");
				break;
			}
		}
	}

}
