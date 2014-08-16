package com.caelum.argentum.modelo;

import java.util.Calendar;

public class CandlestickBuilder {
	
	private double precoAbertura;
	private double precoFechamento;
	private double precoMinimo;
	private double precoMaximo;
	private double volume;
	private Calendar data;
	
	public Candlestick candlestickBuilder() {
		return new Candlestick(precoAbertura, precoFechamento, precoMinimo, 
				precoMaximo, volume, data);
	}
	
	public CandlestickBuilder comPrecoAbertura(double precoAbertura) {
		this.precoAbertura = precoAbertura;
		return this;
	}

	public CandlestickBuilder comPrecoFechamento(double precoFechamento) {
		this.precoFechamento = precoFechamento;
		return this;
	}

	public CandlestickBuilder comPrecoMinimo(double precoMinimo) {
		this.precoMinimo = precoMinimo;
		return this;
	}

	public CandlestickBuilder comPrecoMaximo(double precoMaximo) {
		this.precoMaximo = precoMaximo;
		return this;
	}

	public CandlestickBuilder comVolume(double volume) {
		this.volume = volume;
		return this;
	}

	public CandlestickBuilder comData(Calendar data) {
		this.data = data;
		return this;
	}
	
}
