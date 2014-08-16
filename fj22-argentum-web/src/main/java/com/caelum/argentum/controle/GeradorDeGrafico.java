package com.caelum.argentum.controle;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.caelum.argentum.indicadores.Indicador;
import com.caelum.argentum.modelo.SerieTemporal;

public class GeradorDeGrafico {

	private CartesianChartModel modelo;
	private SerieTemporal serie;
	private int inicio;
	private int fim;

	public GeradorDeGrafico(SerieTemporal serie, int inicio, int fim) {
		this.modelo = new CartesianChartModel();
		this.serie = serie;
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public void plota(Indicador indicador) {
		
		LineChartSeries linhas = new LineChartSeries(indicador.toString());
				
		for(int i = inicio; i <= fim; i++) {
			linhas.set(i, indicador.calcula(i, this.serie));
		}
		
		this.modelo.addSeries(linhas);
		
	}

	public ChartModel getModelo() {
		return modelo;
	}

	public void setModelo(CartesianChartModel modelo) {
		this.modelo = modelo;
	}

	public SerieTemporal getSerie() {
		return serie;
	}

	public void setSerie(SerieTemporal serie) {
		this.serie = serie;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFim() {
		return fim;
	}

	public void setFim(int fim) {
		this.fim = fim;
	}

}
