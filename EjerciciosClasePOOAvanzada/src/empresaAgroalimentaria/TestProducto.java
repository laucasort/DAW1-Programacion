package empresaAgroalimentaria;

import java.sql.Date;

public class TestProducto {

	public static void main(String[] args) {
		
		ProductoFresco pf = new ProductoFresco(Date.valueOf("2022-03-02"), 001, Date.valueOf("2022-02-20"), "España");
		System.out.println(pf.toString());
		
		ProductoRefrigerado pr = new ProductoRefrigerado(Date.valueOf("2022-03-02"), 002, 001);
		System.out.println(pr.toString());
		
		ProductoCongelado pc = new ProductoCongelado(Date.valueOf("2022-03-02"), 003, 12.5);
		System.out.println(pc.toString());
		
	}

}
