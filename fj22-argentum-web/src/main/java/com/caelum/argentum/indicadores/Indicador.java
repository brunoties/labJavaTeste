package com.caelum.argentum.indicadores;

import com.caelum.argentum.modelo.SerieTemporal;

public interface Indicador {

	public abstract double calcula(int posicao, SerieTemporal serie);

}