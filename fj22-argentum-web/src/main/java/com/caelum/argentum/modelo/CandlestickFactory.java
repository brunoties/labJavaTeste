package com.caelum.argentum.modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {
	
	public Candle contruirCandlestick(Calendar data, 
		List<Negociacao> negociacoes) {
		
		double precoAbertura = negociacoes.isEmpty() ? 
				0.0 : negociacoes.get(0).getPreco();
		
		double precoFechamento = negociacoes.isEmpty() ?
				0.0 : negociacoes.get(negociacoes.size() - 1).getPreco();
		
		//double precoMinimo = negociacoes.get(0).getPreco();
		
		double precoMinimo = Double.MAX_VALUE;
		
		//double precoMaximo = precoMinimo;
		
		double precoMaximo = 0.0;
		
		double volume = 0.0;
		
		for(Negociacao negociacao : negociacoes) {
			
			volume += negociacao.getVolume();
			
			if(negociacao.getPreco() > precoMaximo) {
				precoMaximo = negociacao.getPreco();
			} 
			
			if(negociacao.getPreco() < precoMinimo) {
				precoMinimo = negociacao.getPreco();
			}
			
		}
		
		return new CandlestickBuilder().comData(data).comPrecoAbertura(precoAbertura)
				.comPrecoFechamento(precoFechamento).comPrecoMaximo(precoMaximo)
				.comPrecoMinimo(precoMinimo).comVolume(volume).candlestickBuilder();
				
				/*
				(precoAbertura, precoFechamento, precoMinimo, 
				precoMaximo, volume, data);
				*/
		
	}

	public List<Candle> contruirCandlestick(List<Negociacao> negociacoes) throws IOException {
		
		List<Candle> candlesticks = new ArrayList<Candle>();
		
		List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();
		
		Calendar dataInicial = negociacoes.get(0).getData();
		
		for(Negociacao n : negociacoes) {
			
			if(!n.isMesmoDia(dataInicial)) {
				
				Candle candleDoDia = contruirCandlestick(dataInicial, negociacoesDoDia);
				
				candlesticks.add(candleDoDia);
				
				negociacoesDoDia = new ArrayList<Negociacao>();
				
				dataInicial = n.getData();
				
			}
			
			negociacoesDoDia.add(n);
			
		}
		
		Candle candleDoDia = contruirCandlestick(dataInicial, negociacoesDoDia);
		
		candlesticks.add(candleDoDia);
		
		return candlesticks;
	}

	private void criandoCandlestickElegante() {
		List<Negociacao> negociacoesDoDia2 = new ArrayList<Negociacao>();
	}

}
