package com.caelum.argentum.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.caelum.argentum.modelo.Candle;
import com.caelum.argentum.modelo.SerieTemporal;

public class GeradorDeSerie {
	
	public static SerieTemporal criaSerie(double... valores) {
		
		List<Candle> candles = new ArrayList<Candle>();
		
		
		for(double valor : valores) {
			candles.add(new Candle(valor, valor, valor, valor, 1000, Calendar.getInstance()));
		}
		
		return new SerieTemporal(candles);
		
	}

}
