package br.com.sisjupiter.bo;

import java.math.BigDecimal;

public class teste {

	public static void main(String[] args) {
		BigDecimal total = new BigDecimal(350);
		BigDecimal paginas = total.divide(new BigDecimal(50));
		System.out.println(paginas);
	}

}
