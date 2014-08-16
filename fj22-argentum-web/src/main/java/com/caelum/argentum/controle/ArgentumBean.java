package com.caelum.argentum.controle;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.ChartModel;

import com.caelum.argentum.modelo.Candle;
import com.caelum.argentum.modelo.CandlestickFactory;
import com.caelum.argentum.modelo.ClienteWebService;
import com.caelum.argentum.modelo.MediaMovelSimples;
import com.caelum.argentum.modelo.Negociacao;
import com.caelum.argentum.modelo.SerieTemporal;


@ManagedBean
public class ArgentumBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ChartModel modeloGrafico;
	
	private List<Negociacao> negociacoes = new ArrayList<Negociacao>();

	public ArgentumBean() throws IOException {
				
		this.negociacoes = new ClienteWebService().getNegociacoes();
		
		List<Candle> candles = new CandlestickFactory().contruirCandlestick(negociacoes);
		
		SerieTemporal serie = new SerieTemporal(candles);
		
		GeradorDeGrafico grafico = new GeradorDeGrafico(serie, 2, serie.getUltimaPosicao());
		
		grafico.plota(new MediaMovelSimples());
		
		this.modeloGrafico = grafico.getModelo();

	}
	
	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}

	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}

//	public void setModeloGrafico(ChartModel modeloGrafico) {
//		this.modeloGrafico = modeloGrafico;
//	}
	
	

}
