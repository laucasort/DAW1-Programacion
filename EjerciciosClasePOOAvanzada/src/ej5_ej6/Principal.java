package ej5_ej6;

public class Principal {

	public static void main(String[] args) {
		Piano p = new Piano();
		p.add(NotasMusicales.DO);
		p.add(NotasMusicales.RE);
		p.add(NotasMusicales.MI);
		p.interpretar();
		
		Campana c = new Campana();
		c.add(NotasMusicales.FA);
		c.add(NotasMusicales.SOL);
		c.add(NotasMusicales.LA);
		c.add(NotasMusicales.SI);
		c.interpretar();
	}

}
