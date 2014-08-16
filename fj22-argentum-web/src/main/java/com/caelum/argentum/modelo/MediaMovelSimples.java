package com.caelum.argentum.modelo;

import com.caelum.argentum.indicadores.Indicador;

public class MediaMovelSimples implements Indicador {

	public double calcula(int posicao, SerieTemporal serie) {
		
		double soma = 0.0;
		for(int i = posicao; i > posicao - 3; i--) {
			soma += serie.getCandle(i).getPrecoFechamento();
		}
		
		return soma / 3;
	}
	
	@Override
	public String toString() {
		return "MMS de Fechamento";
	}

}
