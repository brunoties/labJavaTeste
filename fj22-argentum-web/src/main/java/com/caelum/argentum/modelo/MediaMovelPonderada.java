package com.caelum.argentum.modelo;

public class MediaMovelPonderada {
	
	public double calcula(int posicao, SerieTemporal serie) {
		
		double soma = 0.0;
		
		int peso = 3;
		
		for(int i = posicao; i > posicao - 3; i--) {
			soma += serie.getCandle(i).getPrecoFechamento() * peso;
			peso--;
		}
		
		return soma / 6;
	}

}
