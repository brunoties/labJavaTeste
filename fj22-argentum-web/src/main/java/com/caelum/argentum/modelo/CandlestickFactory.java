package com.caelum.argentum.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.caelum.argentum.util.LeitorXML;

public class CandlestickFactory {
	
	public Candlestick contruirCandlestick(Calendar data, 
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

	public List<Candlestick> contruirCandlestick(List<Negociacao> negociacoes) throws IOException {
		
		List<Candlestick> candlesticks = new ArrayList<Candlestick>();
		
		List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();
		
		
		
		return null;
	}

}
