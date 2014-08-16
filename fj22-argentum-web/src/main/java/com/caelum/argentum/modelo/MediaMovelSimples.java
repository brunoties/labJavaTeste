package com.caelum.argentum.modelo;

import com.caelum.argentum.indicadores.Indicador;

public class MediaMovelSimples implements Indicador {
	
	private Indicador indicador;

	public MediaMovelSimples(Indicador indicador) {
		this.indicador = indicador;
	}

	public double calcula(int posicao, SerieTemporal serie) {
		
		double soma = 0.0;
		for(int i = posicao; i > posicao - 3; i--) {
			soma += this.indicador.calcula(i, serie);
		}
		
		return soma / 3;
	}
	
	public Indicador getIndicador() {
		return indicador;
	}

	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}

	@Override
	public String toString() {
		return "MMS de Fechamento";
	}

}
