package ej1;

import java.time.LocalDate;

public class TestProducto {

	public static void main(String[] args) {
		
		ProductoFresco pf = null;
		do {
			try {
				pf = new ProductoFresco(LocalDate.of(2022, 4, 23), 1, LocalDate.of(3033, 2, 23), "España");
			} catch (ProductoException e) {
				System.out.println(e.getMessage());
			}
		} while(pf==null);
		
		ProductoRefrigerado pr = null;
		do {
			try {
				pr = new ProductoRefrigerado(LocalDate.of(2022, 6, 1), 2, 1);
			} catch (ProductoException e) {
				System.out.println(e.getMessage());
			}
		} while(pr==null);
		
		ProductoCongelado pc = null;
		do {
			try {
				pc = new ProductoCongelado(LocalDate.of(2022, 4, 25), 3, -3.5);
			} catch (ProductoException e) {
				System.out.println(e.getMessage());
			}
		} while(pc==null);
		
		
		System.out.println(pf.toString());
		System.out.println(pr.toString());
		System.out.println(pc.toString());
		
	}

}
