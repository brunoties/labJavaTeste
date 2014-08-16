package com.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.caelum.argentum.modelo.Candle;
import com.caelum.argentum.modelo.CandlestickFactory;
import com.caelum.argentum.modelo.Negociacao;
import com.caelum.argentum.modelo.NegociacaoBuilder;

public class TesteNegociacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar data = Calendar.getInstance();
		
		/*
		Negociacao negociacao5 = new Negociacao(50, 50.5, Calendar.getInstance());
		Negociacao negociacao1 = new Negociacao(10, 10.5, Calendar.getInstance());
		Negociacao negociacao2 = new Negociacao(20, 20.5, null);
		Negociacao negociacao4 = new Negociacao(40, 40.5, Calendar.getInstance());
		Negociacao negociacao3 = new Negociacao(30, 30.5, Calendar.getInstance());
		*/
		
		Negociacao negociacao5 = new NegociacaoBuilder().comData(data)
			.comPreco(50.5).comQuantidade(50).negociacaoBuilder();
		
		Negociacao negociacao1 = new NegociacaoBuilder().comData(data)
				.comPreco(10.5).comQuantidade(10).negociacaoBuilder();
		
		Negociacao negociacao2 = new NegociacaoBuilder().comData(data)
				.comPreco(20.5).comQuantidade(20).negociacaoBuilder();
		
		Negociacao negociacao4 = new NegociacaoBuilder().comData(data)
				.comPreco(40.5).comQuantidade(40).negociacaoBuilder();
		
		Negociacao negociacao3 = new NegociacaoBuilder().comData(data)
				.comPreco(30.5).comQuantidade(30).negociacaoBuilder();
				
		CandlestickFactory candlestickFactory = new CandlestickFactory();
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3,
				negociacao4, negociacao5);
		
		Candle candlestick = candlestickFactory.contruirCandlestick(data, negociacoes);
		
		/*
		negociacao1.setQuantidade(10);
		
		negociacao1.setPreco(40.5);
		
		Calendar hoje = Calendar.getInstance();
		
		negociacao1.setData(hoje);
		*/
		
		//System.out.println(negociacao1);
		
		System.out.println(candlestick);

	}

}
