package com.caelum.argentum.modelo;

import java.util.Calendar;

public class NegociacaoBuilder {
	
	private int quantidade;
	private double preco;
	private Calendar data;
	
	public Negociacao negociacaoBuilder() {
		return new Negociacao(quantidade, preco, data);
	}

	public NegociacaoBuilder comQuantidade(int quantidade) {
		this.quantidade = quantidade;
		return this;
	}

	public NegociacaoBuilder comPreco(double preco) {
		this.preco = preco;
		return this;
	}

	public NegociacaoBuilder comData(Calendar data) {
		this.data = data;
		return this;
	}
	
}
