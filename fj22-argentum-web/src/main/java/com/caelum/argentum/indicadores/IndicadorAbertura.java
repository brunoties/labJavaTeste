package com.caelum.argentum.indicadores;

import com.caelum.argentum.modelo.SerieTemporal;

public class IndicadorAbertura implements Indicador {

	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getPrecoAbertura();
	}
	
	@Override
	public String toString() {
		return "Abertura";
	}

}
