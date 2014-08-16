package com.caelum.argentum.indicadores;

import com.caelum.argentum.modelo.SerieTemporal;

public class IndicadorFechamento implements Indicador {

	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getPrecoFechamento();
	}
	
	@Override
	public String toString() {
		return "Fechamento";
	}

}
