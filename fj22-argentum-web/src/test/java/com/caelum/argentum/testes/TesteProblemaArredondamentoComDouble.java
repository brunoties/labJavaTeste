package com.caelum.argentum.testes;

import java.math.BigDecimal;

public class TesteProblemaArredondamentoComDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double y = 1.92;

		double z = 1.02;

		double x = (double) (y - z);

		System.out.println(x);

		BigDecimal y2 = new BigDecimal(1.92);

		BigDecimal z2 = new BigDecimal(1.02);

		BigDecimal x2 = y2.subtract(z2);
		
		System.out.println(x2);
		
		BigDecimal y3 = new BigDecimal("1.92");

		BigDecimal z3 = new BigDecimal("1.02");

		BigDecimal x3 = y3.subtract(z3);
		
		System.out.println(x3);

	}

}
