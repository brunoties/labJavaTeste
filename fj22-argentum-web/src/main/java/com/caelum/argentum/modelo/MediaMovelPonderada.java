package com.caelum.argentum.modelo;

import com.caelum.argentum.indicadores.Indicador;

public class MediaMovelPonderada implements Indicador {

	private Indicador indicador;
	
	public MediaMovelPonderada(Indicador indicador) {
		this.indicador = indicador;
	}
	
	public double calcula(int posicao, SerieTemporal serie) {
		
		double soma = 0.0;
				
		for(int i = posicao; i > posicao - 3; i--) {
			soma += indicador.calcula(i, serie);
		}
		
		return soma / 6;
	}
	
	public Indicador getIndicador() {
		return indicador;
	}

	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}

	@Override
	public String toString() {
		return "MMP de Fechamento";
	}

}
