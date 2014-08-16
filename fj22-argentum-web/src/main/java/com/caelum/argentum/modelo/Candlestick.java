package com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candlestick {
	
	private final double precoAbertura;
	private final double precoFechamento;
	private final double precoMinimo;
	private final double precoMaximo;
	private final double volume;
	private final Calendar data;
	
	public Candlestick(double precoAbertura, double precoFechamento,
			double precoMinimo, double precoMaximo, double volume, Calendar data) {
		this.precoAbertura = precoAbertura;
		this.precoFechamento = precoFechamento;
		this.precoMinimo = precoMinimo;
		this.precoMaximo = precoMaximo;
		this.volume = volume;
		this.data = data;
	}
	
	public boolean isEmAlta() {
		return this.precoAbertura < this.precoFechamento;
	}
	
	public boolean isEmBaixa() {
		return this.precoAbertura > this.precoFechamento;
	}

	public double getPrecoAbertura() {
		return precoAbertura;
	}

	public double getPrecoFechamento() {
		return precoFechamento;
	}

	public double getPrecoMinimo() {
		return precoMinimo;
	}

	public double getPrecoMaximo() {
		return precoMaximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Candlestick [precoAbertura=" + precoAbertura
				+ ", precoFechamento=" + precoFechamento + ", precoMinimo="
				+ precoMinimo + ", precoMaximo=" + precoMaximo + ", volume="
				+ volume + ", data=" + 
					new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(this.data.getTime()) + "]";
	}
	
	
	

}
