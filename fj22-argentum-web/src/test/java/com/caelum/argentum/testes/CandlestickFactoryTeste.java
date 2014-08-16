package com.caelum.argentum.testes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.caelum.argentum.modelo.Candle;
import com.caelum.argentum.modelo.CandlestickFactory;
import com.caelum.argentum.modelo.Negociacao;
import com.caelum.argentum.modelo.NegociacaoBuilder;

public class CandlestickFactoryTeste {

	@Test
	public void paraNegociacoesDeTresDiasDistintosGerarTresCandles() throws IOException {

		int numInicial = 1;
		int numFinal = 3;
		int numVariacao = 2;
		double delta = 0.00001;
		double volume = 0.0;
		int numDias = 3;

		Calendar hoje = Calendar.getInstance();
		
		Calendar data = null;

		Negociacao negociacao = null;

		List<Negociacao> negociacoes = new ArrayList<Negociacao>();

		for (int j = numInicial; j <= numDias; j++) {
			
			for (int i = numInicial; i <= numFinal; i++) {
				
				data = (Calendar) hoje.clone();
				
				data.add(Calendar.DAY_OF_MONTH, j);

				negociacao = new NegociacaoBuilder().comData(data)
						.comPreco(i * numVariacao)
						.comQuantidade(i * numVariacao).negociacaoBuilder();

				volume += negociacao.getVolume();

				negociacoes.add(negociacao);

			}
			
		}
		
		CandlestickFactory candlestickFactory = new CandlestickFactory();
		
		List<Candle> candlesticks = candlestickFactory.contruirCandlestick(negociacoes);
		

	}

	@Test
	public void testarCandlestickFactoryComUmaNegociacao() {

		int numInicial = 1;
		int numFinal = 1;
		int numVariacao = 2;
		double delta = 0.00001;
		double volume = 0.0;

		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao = null;

		List<Negociacao> negociacoes = new ArrayList<Negociacao>();

		for (int i = numInicial; i <= numFinal; i++) {

			negociacao = new NegociacaoBuilder().comData(hoje)
					.comPreco(i * numVariacao).comQuantidade(i * numVariacao)
					.negociacaoBuilder();

			volume += negociacao.getVolume();

			negociacoes.add(negociacao);

		}

		CandlestickFactory candlestickFactory = new CandlestickFactory();

		Candle candlestick = candlestickFactory.contruirCandlestick(hoje,
				negociacoes);

		Assert.assertEquals(numInicial * numVariacao,
				candlestick.getPrecoAbertura(), delta);

		Assert.assertEquals(numFinal * numVariacao,
				candlestick.getPrecoFechamento(), delta);

		Assert.assertEquals(numInicial * numVariacao,
				candlestick.getPrecoMinimo(), delta);

		Assert.assertEquals(numFinal * numVariacao,
				candlestick.getPrecoMaximo(), delta);

		Assert.assertEquals(volume, candlestick.getVolume(), delta);

	}

	@Test
	public void sequenciaSimplesNegociacoes() {

		int numInicial = 1;
		int numFinal = 50;
		int numVariacao = 2;
		double delta = 0.00001;
		double volume = 0.0;

		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao = null;

		List<Negociacao> negociacoes = new ArrayList<Negociacao>();

		for (int i = numInicial; i <= numFinal; i++) {

			negociacao = new NegociacaoBuilder().comData(hoje)
					.comPreco(i * numVariacao).comQuantidade(i * numVariacao)
					.negociacaoBuilder();

			volume += negociacao.getVolume();

			negociacoes.add(negociacao);

		}

		CandlestickFactory candlestickFactory = new CandlestickFactory();

		Candle candlestick = candlestickFactory.contruirCandlestick(hoje,
				negociacoes);

		Assert.assertEquals(numInicial * numVariacao,
				candlestick.getPrecoAbertura(), delta);

		Assert.assertEquals(numFinal * numVariacao,
				candlestick.getPrecoFechamento(), delta);

		Assert.assertEquals(numInicial * numVariacao,
				candlestick.getPrecoMinimo(), delta);

		Assert.assertEquals(numFinal * numVariacao,
				candlestick.getPrecoMaximo(), delta);

		Assert.assertEquals(volume, candlestick.getVolume(), delta);

	}

	@Test
	public void sequenciaIdenticaNegociacoes() {

		int numInicial = 1;
		int numFinal = 50;
		int numVariacao = 1;
		double delta = 0.00001;
		double volume = 0.0;

		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao = null;

		List<Negociacao> negociacoes = new ArrayList<Negociacao>();

		for (int i = numInicial; i <= numFinal; i++) {

			negociacao = new NegociacaoBuilder().comData(hoje)
					.comPreco(i * numVariacao).comQuantidade(i * numVariacao)
					.negociacaoBuilder();

			volume += negociacao.getVolume();

			negociacoes.add(negociacao);

		}

		CandlestickFactory candlestickFactory = new CandlestickFactory();

		Candle candlestick = candlestickFactory.contruirCandlestick(hoje,
				negociacoes);

		Assert.assertEquals(numInicial * numVariacao,
				candlestick.getPrecoAbertura(), delta);

		Assert.assertEquals(numFinal * numVariacao,
				candlestick.getPrecoFechamento(), delta);

		Assert.assertEquals(numInicial * numVariacao,
				candlestick.getPrecoMinimo(), delta);

		Assert.assertEquals(numFinal * numVariacao,
				candlestick.getPrecoMaximo(), delta);

		Assert.assertEquals(volume, candlestick.getVolume(), delta);

	}

	@Test
	public void semNegociacoes() {

		int numInicial = 1;
		int numFinal = 0;
		int numVariacao = 2;
		double delta = 0.00001;
		double volume = 0.0;

		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao = null;

		List<Negociacao> negociacoes = new ArrayList<Negociacao>();

		for (int i = numInicial; i <= numFinal; i++) {

			negociacao = new NegociacaoBuilder().comData(hoje)
					.comPreco(i * numVariacao).comQuantidade(i * numVariacao)
					.negociacaoBuilder();

			volume += negociacao.getVolume();

			negociacoes.add(negociacao);

		}

		CandlestickFactory candlestickFactory = new CandlestickFactory();

		Candle candlestick = candlestickFactory.contruirCandlestick(hoje,
				negociacoes);

		Assert.assertEquals(volume, candlestick.getVolume(), delta);

	}

}
